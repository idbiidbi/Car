// Create cars
// View cars
// View specific car
// Remove cars
// Update cars

import cars.Car;
import cars.ShowRoom;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    ShowRoom showRoom = new ShowRoom();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();

        main.showMenu();

    }

    // меню обычно loop
    void showMenu() {

        String userInput;

        do {
            System.out.println("Welcome to show room, please choose activity: \n" +
                    "1. Add Car" + "\n" +
                    "2. View All Cars" + "\n" +
                    "3. View Single Car" + "\n" +
                    "4. Remove Car" + "\n" +
                    "5. Update Car" + "\n" +
                    "Enter Quit to end program.");
            System.out.println();
            System.out.print("Enter your choice:");
            userInput = scanner.nextLine();

            switch (userInput) {
                case "quit":
                    System.out.println("Existing application.");
                    break;
                case "1":
                    addCar();
                    break;
                case "2":
                    viewAllCars();
                    break;
                case "3":
                    viewSingleCar();
                    break;
                case "4":
                    deleteCar();
                    break;
                case "5":
                    updateCar();
                    break;
                default:
                    break;
            }
//            System.out.println("\n Enter to continue\n");
//            scanner.nextLine();

        } while (!userInput.equalsIgnoreCase("quit"));

        return;
    }

    void addCar() {

        System.out.println("ADD CAR");

        Car car = new Car();
        System.out.print("Enter Name: ");
        car.name = scanner.nextLine();

        System.out.print("Enter Manufacturer: ");
        car.manufacturer = scanner.nextLine();

        System.out.print("Enter Type: ");
        car.type = scanner.nextLine();

        car.id = UUID.randomUUID();

        String message = showRoom.addCar(car);
        System.out.println(message);
        System.out.println();

    }

    void viewAllCars() {
        ArrayList<Car> allCars = showRoom.getAllCars();

        System.out.println("ALL AVAILABLE CARS");
        System.out.println("Id\t Car name\t Manufacturer \t Car Type");

        int counter = 0;
        for (Car car: allCars) {
            System.out.println(counter + ".\t" + car.name + " \t" + car.manufacturer + " \t" + car.type);
            counter++;
        }
    }

    void viewSingleCar() {
        System.out.println("VIEW CAR");
        System.out.print("Enter Car ID: ");

        int carId = scanner.nextInt();
        Car car = showRoom.getSingleCar(carId);

        System.out.println("Car number: " + car.id);
        System.out.println("Car name: " + car.name);
        System.out.println("Car manufacturer: " + car.manufacturer);
        System.out.println("Car type: " + car.type);
    }

    void deleteCar() {
        System.out.println("DELETE CAR");
        System.out.print("Enter car ID: ");

        int carId = scanner.nextInt();
        String message = showRoom.removeCar(carId);

        System.out.println(message);

    }

    void updateCar() {

        Car car = new Car();
        this.viewAllCars();

        System.out.println("UPDATE CAR");

        System.out.println("Enter car ID");
        int carId = Integer.parseInt(scanner.nextLine());



        System.out.println("Enter new name for car");
        car.name = scanner.nextLine();

        System.out.println("Enter new type for car");
        car.type = scanner.nextLine();

        System.out.println("Enter new manufacturer for car");
        car.manufacturer = scanner.nextLine();

        String response = showRoom.updateCar(carId, car);
        System.out.println(response);
    }
}

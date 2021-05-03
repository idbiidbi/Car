package cars;

import java.util.ArrayList;

public class ShowRoom {

    private ArrayList<Car> cars = new ArrayList<Car>();

    public String addCar(Car car){  // Car - data type;  car - variable
        this.cars.add(car);
        return car.name + " Added successfully";
    }

    public ArrayList<Car> getAllCars(){
        return cars;
    }

    public Car getSingleCar(int carId){
       return this.cars.get(carId);
    }
    public String removeCar(int carId){
        try {
            cars.remove(carId);
        } catch (Exception ex){
           return "Unable to remove specified car";
        }
        return "car removed successfully";
    }

    public String updateCar(int carIndex, Car newCar){
        if(this.cars.get(carIndex) != null) {
            Car oldcar = this.cars.get(carIndex);
            oldcar.name = newCar.name;
            oldcar.manufacturer = newCar.manufacturer;
            oldcar.type = newCar.type;
            return "car update successfully";
        }
        return "Car not found";
    }
}



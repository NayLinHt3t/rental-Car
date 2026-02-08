package car;

import java.util.List;
import java.util.ArrayList;
public class CarDAO {
    private static final List<Car> cars = new ArrayList<>();
    private static int count = 0;
    public  void addCar(Car car) {
        if(count == 10){
            throw new RuntimeException("Maximum number of cars reached.");
        }
        cars.add(car);
        count++;
    }
    public  List<Car> getAllCars() {  
        return cars;
    }
    public Car getCarByRegNumber(String regNumber) {
        for (Car car : getAllCars()) {
            if (car != null && car.getRegNumber().equals(regNumber)) {
                return car;
            }
        }
        throw new RuntimeException("Car with registration number " + regNumber + " not found.");
    }
    public List<Car> getAvailableCars() {
        List<Car> availableCars = new ArrayList<>();
        for (Car car : cars) {
            if (car != null && car.isAvailable()) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }
}

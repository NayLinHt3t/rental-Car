package car;

public class CarDAO {
    private static final Car[] cars = new Car[10];
    private static int count = 0;
    public  void addCar(Car car) {
        if(count == 10){
            throw new RuntimeException("Maximum number of cars reached.");
        }
        cars[count] = car;
        count++;
    }
    public  Car[] getAllCars() {  
        Car[] result = new Car[count];
        System.arraycopy(cars, 0, result, 0, count);
        return result;
    }
    public Car getCarByRegNumber(String regNumber) {
        for (Car car : getAllCars()) {
            if (car != null && car.getRegNumber().equals(regNumber)) {
                return car;
            }
        }
        throw new RuntimeException("Car with registration number " + regNumber + " not found.");
    }
    public Car[] getAvailableCars() {
        Car[] availableCars = new Car[cars.length];
        int index = 0;
        for (Car car : cars) {
            if (car != null && car.isAvailable()) {
                availableCars[index] = car;
                index++;
            }
        }
        return availableCars;
    }
}

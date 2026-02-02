package car;

public class CarService {
    private CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public Car createCar(Car car) {
        carDAO.addCar(car);
        return car;
    }
    public Car getCarByRegNumber(String regNumber) {
        for (Car car : getAllCars()) {
            if (car != null && car.getRegNumber().equals(regNumber)) {
                return car;
            }
        }
        throw new RuntimeException("Car with registration number " + regNumber + " not found.");
    }

    public Car[] getElectricCars(){
        Car[] allCars = getAllCars();
        Car[] electricCars = new Car[allCars.length];
        int index = 0;
        for (Car car : allCars) {
            if (car != null && car.isElectric()) {
                electricCars[index] = car;
                index++;
            }
        }
        return electricCars;
    }

    public Car[] getAllCars() {
        return carDAO.getAllCars();
    }
}

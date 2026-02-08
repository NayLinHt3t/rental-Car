package car;
import java.util.List;
import java.util.ArrayList;
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

    public List<Car> getElectricCars(){
        List<Car> allCars = carDAO.getAllCars();
        List<Car> electricCars = new ArrayList<>();
        for (Car car : allCars) {
            if (car != null && car.isElectric()) {
                electricCars.add(car);
            }
        }
        return electricCars;
    }

    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }
}

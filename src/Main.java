import java.math.BigDecimal;
import java.util.Scanner;

import user.User;
import user.UserDAO;
import user.UserService;
import car.Car;
import car.CarDAO;
import car.CarService;

public class Main{
    public static void main(String[] args) {

    //     UserDAO userDAO = new UserDAO();
    //     UserService userService = new UserService(userDAO);
    //     userService.createUser(user1);
    //     userService.createUser(user2);
    //     User[] users = userService.getAllUsers();
    //     for (User user : users) {
    //          System.out.println(user);
    //      }
    UserDAO userDAO = new UserDAO();
    UserService userService = new UserService(userDAO);
    CarDAO carDAO = new CarDAO();
    CarService carService = new CarService(carDAO);

    Scanner scanner = new Scanner(System.in);
    Boolean running = true;
    while (running) {
        try{
            displayMenu();
            String choice = scanner.nextLine();
            switch(choice){
                case "1":
                    userServiceDisplay(userService, scanner);
                    break;
                case "2":
                    carServiceDisplay(carService, scanner);
                    break;
                // 
                
                case "4":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");           

            }
            
        }catch (Exception e) {
            throw new RuntimeException(e);   

        }
    }
    scanner.close();
    }
    public static void displayMenu(){
        System.out.println("Select an option:");
        System.out.println("1. User Service");
        System.out.println("2. Car Service");
        System.out.println("3. Booking Service");
        System.out.println("4. Exit");
    }
    public static void userServiceDisplay(UserService userService, Scanner scanner){
        System.out.println("Select an option:");
        System.out.println("1. Create User");
        System.out.println("2. View Users");
        System.out.println("3. Back to Main Menu");
       
        String choice = scanner.nextLine();
        switch(choice){
            case "1":
                createUser(userService, scanner);
                break;
            case "2":
                viewUsers(userService);
                break;
            case "3": 
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    public static void createUser(UserService userService, Scanner scanner){
        System.out.println("Enter user name:");
        String name = scanner.nextLine();
        User newUser = new User(name);
        userService.createUser(newUser);
        System.out.println("User created: " + newUser);
    }
    public static void viewUsers(UserService userService){
        User[] users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    public static void carServiceDisplay(CarService carService, Scanner scanner){
        System.out.println("Select an option:");
        System.out.println("1. Add Car");
        System.out.println("2. View Cars");
        System.out.println("3. Get Car By Registration Number");
        System.out.println("4. Get Electric Cars");
        System.out.println("5. Back to Main Menu");
       
        String choice = scanner.nextLine();
        switch(choice){
            case "1":
                createCar(carService, scanner);
                break;
            case "2":
                viewCars(carService);
                break;
            case "3":
                getCarByRegNumber(carService, scanner);
                break;
            case "4": 
                getElectricCars(carService);
                break;
            case "5": 
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    public static void createCar(CarService carService, Scanner scanner){
        System.out.println("Enter car registration number:");
        String regNumber = scanner.nextLine();
        System.out.println("Enter car price:");
        String priceInput = scanner.nextLine();
        BigDecimal price = new BigDecimal(priceInput);
        System.out.println("Enter car brand:");
        String brand = scanner.nextLine();
        // Additional prompts for rentalPerDay, isElectric can be added here
        System.out.println("Is the car electric? (true/false):");
        boolean isElectric = Boolean.parseBoolean(scanner.nextLine());
        Car newCar = new Car(regNumber, brand, price, isElectric);
       
        carService.createCar(newCar);
        System.out.println("Car created: " + newCar);
    }
    public static void viewCars(CarService carService){
        Car[] cars = carService.getAllCars();
        for (Car car : cars) {
            System.out.println(car);
        }
    }
    public static void getCarByRegNumber(CarService carService, Scanner scanner){
        System.out.println("Enter car registration number:");
        String regNumber = scanner.nextLine();
        
        Car car = carService.getCarByRegNumber(regNumber);
        if(car == null){
            System.out.println("Car not found with registration number: " + regNumber);
            return;
        }
        System.out.println("Car found: " + car);
    }
    public static void getElectricCars(CarService carService){
        Car[] cars = carService.getElectricCars();
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
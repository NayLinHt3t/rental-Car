import java.math.BigDecimal;
import java.util.Scanner;
import java.util.List;
import booking.Booking;
import booking.BookingDAO;
import booking.BookingService;
import user.User;
import user.UserDAO;
import user.UserService;
import car.Car;
import car.CarDAO;
import car.CarService;

public class Main{
/*************  ✨ Windsurf Command ⭐  *************/
/**
 * Main entry point for the application.
 * 
 * This program creates instances of UserDAO, UserService, CarDAO, CarService, BookingDAO, and BookingService.
 * 
 * It then runs a loop that displays a menu and responds to user input.
 * 
 * The menu options are:
 * 1. User Service
 * 2. Car Service
 * 3. Booking Service
 * 4. Exit
 * 
/*******  b7cb838c-2537-429e-92e9-084fa0e358d0  *******/
    public static void main(String[] args) {
    UserDAO userDAO = new UserDAO();
    UserService userService = new UserService(userDAO);
    CarDAO carDAO = new CarDAO();
    CarService carService = new CarService(carDAO);
    BookingDAO bookingDAO = new BookingDAO();
    BookingService bookingService = new BookingService(bookingDAO, carDAO);

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
                case "3":
                    bookingServiceDisplay(bookingService,userService,carService, scanner);
                    break;
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
        List<User> users = userService.getAllUsers();
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
        List<Car> cars = carService.getAllCars();
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
        List<Car> cars = carService.getElectricCars();
        for (Car car : cars) {
            System.out.println(car);
        }
    }
   
    public static void bookingServiceDisplay(BookingService bookingService,UserService userService,CarService carService, Scanner scanner){
        System.out.println("Select an option:");
        System.out.println("1. Create Booking");
        System.out.println("2. View Bookings");
        System.out.println("3. Get Booking By ID");
        System.out.println("4. Get Booking By User ID");
        System.out.println("5. Back to Main Menu");
       
        String choice = scanner.nextLine();
        switch(choice){
            case "1":
                createBooking(bookingService, userService, carService, scanner);
                break;
            case "2":
                viewBookings(bookingService);
                break;
            case "3":
                getBookingById(bookingService, scanner);
                break;
            case "4": 
                getBookingByUserId(bookingService, scanner);
                break;
            case "5": 
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    public static void createBooking(BookingService bookingService,UserService userService,CarService carService, Scanner scanner){
        System.out.println("Enter User ID:");
        String userId = scanner.nextLine();
        System.out.println("Enter Car Registration Number:");
        String carRegNumber = scanner.nextLine();
        User user = userService.getUserById(userId); // You would typically fetch the user from UserService
        Car car = carService.getCarByRegNumber(carRegNumber); // You would typically fetch the car from CarService
        Booking newBooking = bookingService.createBooking(user, car);
        System.out.println("Booking created: " + newBooking);   

    }
    public static void viewBookings(BookingService bookingService){
        List<Booking> bookings = bookingService.getAllBookings();
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
    public static void getBookingById(BookingService bookingService, Scanner scanner){
        System.out.println("Enter Booking ID:");
        String bookingId = scanner.nextLine();
        Booking booking = bookingService.getBookingById(bookingId);
        System.out.println("Booking found: " + booking);    
    }
    public static void getBookingByUserId(BookingService bookingService, Scanner scanner){
        System.out.println("Enter User ID:");
        String userId = scanner.nextLine();
        Booking booking = bookingService.getBookingByUserId(userId);
        System.out.println("Booking found: " + booking);    
    }
}
package booking;
import java.time.LocalDate;
import user.User;
import car.Car;
import car.CarDAO;
public class BookingService {
    private BookingDAO bookingDAO;
    private CarDAO carDAO;
    
    public Booking createBooking(User user, Car car ) {
        Car [] avaliableCars = carDAO.getAvailableCars();
        if(avaliableCars.length == 0){
            throw new RuntimeException("No cars available for booking.");
        }
        for( Car avaliableCar : avaliableCars){
            if(avaliableCar != null && avaliableCar.getRegNumber().equals(car.getRegNumber())){
                Booking booking = bookingDAO.addBooking(new Booking( user, car, LocalDate.now()));
                avaliableCar.setAvailable(false);
                return booking;
            }
        }
        throw new RuntimeException("Car with registration number " + car.getRegNumber() + " not found.");
    }

    public Booking[] getAllBookings() {
        return bookingDAO.getAllBookings();
    }
    public Booking getBookingById(String id) {
        for (Booking booking : getAllBookings()) {
            if (booking != null && booking.getId().toString().equals(id)) {
                return booking;
            }
        }
        throw new RuntimeException("Booking with ID " + id + " not found.");
    }

    public Booking getBookingByUserId(String userId) {
        for (Booking booking : getAllBookings()) {
            if (booking != null && booking.getUser().getId().toString().equals(userId)) {
                return booking;
            }
        }
        throw new RuntimeException("Booking with User ID " + userId + " not found.");
    }
    public Car[] getAllCars() {
        return carDAO.getAllCars();
    }
}

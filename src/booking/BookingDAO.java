package booking;
import java.util.ArrayList;
import java.util.List;
public class BookingDAO {
    private static final List<Booking> bookings = new ArrayList<>();
    private static int count = 0;
    public Booking addBooking(Booking booking) {
        if(count == 10){
            throw new RuntimeException("Maximum number of bookings reached.");
        }
        bookings.add(booking);
        count++;
        return booking;
    }
    public List<Booking> getAllBookings() {  
        return bookings;
    }
}

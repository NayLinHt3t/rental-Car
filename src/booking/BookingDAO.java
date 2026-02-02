package booking;

public class BookingDAO {
    private static final Booking[] bookings = new Booking[10];
    private static int count = 0;
    public Booking addBooking(Booking booking) {
        if(count == 10){
            throw new RuntimeException("Maximum number of bookings reached.");
        }
        bookings[count] = booking;
        count++;
        return booking;
    }
    public Booking[] getAllBookings() {  
        return bookings;
    }
}

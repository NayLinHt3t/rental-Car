package booking;
import java.time.LocalDate;
import java.util.UUID;
import car.Car;
import user.User;
public class Booking {
    private UUID id;
    private User user;
    private Car car;
    private LocalDate bookingTime;
    private boolean isCancelled;
    public Booking(User user, Car car, LocalDate bookingTime) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.car = car;
        this.bookingTime = bookingTime;
        this.isCancelled = false;
    }
   
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }
    public LocalDate getBookingTime() {
        return bookingTime;
    }
    public void setBookingTime(LocalDate bookingTime) {
        this.bookingTime = bookingTime;
    }
    public boolean isCancelled() {
        return isCancelled;
    }
    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }
    @Override
    public String toString() {
        return "Booking [id=" + id + ", user=" + user + ", car=" + car + ", bookingTime=" + bookingTime
                + ", isCancelled=" + isCancelled + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + ((car == null) ? 0 : car.hashCode());
        result = prime * result + ((bookingTime == null) ? 0 : bookingTime.hashCode());
        result = prime * result + (isCancelled ? 1231 : 1237);
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Booking other = (Booking) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        if (car == null) {
            if (other.car != null)
                return false;
        } else if (!car.equals(other.car))
            return false;
        if (bookingTime == null) {
            if (other.bookingTime != null)
                return false;
        } else if (!bookingTime.equals(other.bookingTime))
            return false;
        if (isCancelled != other.isCancelled)
            return false;
        return true;
    }
    
}

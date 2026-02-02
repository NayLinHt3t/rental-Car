package car;

import java.math.BigDecimal;

public class Car {
    private String regNumber;
    private String brand;
    private BigDecimal rentalPerDay;
    private boolean isElectric;
    private boolean isAvailable;

    public Car(String regNumber, String brand, BigDecimal rentalPerDay, boolean isElectric) {
        this.regNumber = regNumber;
        this.brand = brand;
        this.rentalPerDay = rentalPerDay;
        this.isElectric = isElectric;
        this.isAvailable = true;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getRentalPerDay() {
        return rentalPerDay;
    }

    public void setRentalPerDay(BigDecimal rentalPerDay) {
        this.rentalPerDay = rentalPerDay;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean isElectric) {
        this.isElectric = isElectric;
    }

    @Override
    public String toString() {
        return "Car [regNumber=" + regNumber + ", brand=" + brand + ", rentalPerDay=" + rentalPerDay + ", isElectric="
                + isElectric + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        if (regNumber == null) {
            if (other.regNumber != null)
                return false;
        } else if (!regNumber.equals(other.regNumber))
            return false;
        return true;
    }

    public void setAvailable(boolean b) {
        isAvailable = b;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    
}

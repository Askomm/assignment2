public class Bus extends Vehicle implements Servicable {
    private int passengerCapacity;

    public Bus() {
        super();
    }

    public Bus(String model, int year, double basePrice, int passengerCapacity) {
        super(model, year, basePrice);
        setPassengerCapacity(passengerCapacity);
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity <= 0) {
            throw new IllegalArgumentException("Passenger capacity must be positive");
        }
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public void performService() {
        System.out.println("Oil change and clean the interior");
    }

    @Override
    public int getServiceIntervalKm() {
        return 8000;
    }

    @Override
    public double calculateInsuranceFee() {
        return getBasePrice() / getPassengerCapacity();
    }

    @Override
    public String toString() {
        return super.toString() +
                " Capacity: " + passengerCapacity +
                " Insurance fee: " + calculateInsuranceFee();
    }
}

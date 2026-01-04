public class Car extends Vehicle implements Servicable {
    private int numberOfDoors;

    public Car() {
        super();
    }

    public Car(String model, int year, double basePrice, int numberOfDoors) {
        super(model, year, basePrice);
        setNumberOfDoors(numberOfDoors);
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors <= 0) {
            throw new IllegalArgumentException("Number of doors must be positive");
        }
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void performService() {
        System.out.println("Oil change");
    }

    @Override
    public int getServiceIntervalKm() {
        return 10000;
    }

    @Override
    public double calculateInsuranceFee() {
        return getBasePrice() / getNumberOfDoors();
    }

    @Override
    public String toString() {
        return super.toString() +
                " Doors: " + numberOfDoors +
                " Insurance fee: " + calculateInsuranceFee();
    }
}
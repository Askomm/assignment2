public abstract class Vehicle {
    private int id;
    private static int idGen;
    private String model;
    private int year;
    private double basePrice;

    public Vehicle() {
        id = ++idGen;
    }

    public Vehicle(String model, int year, double basePrice) {
        this();
        setModel(model);
        setYear(year);
        setBasePrice(basePrice);
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setModel(String model) {
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Model must be declared");
        }
        this.model = model;
    }

    public void setYear(int year) {
        if (year < 1980 || year > 2026) {
            throw new IllegalArgumentException("Invalid year");
        }
        this.year = year;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        this.basePrice = basePrice;
    }

    public int getAge(int currentYear) {
        return currentYear - year;
    }

    public abstract double calculateInsuranceFee();

    @Override
    public String toString() {
        return "Id: " + id +
                " Model: " + model +
                " Year: " + year +
                " Base price: " + basePrice;
    }
}

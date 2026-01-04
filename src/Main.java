public class Main {
    public static void main(String[] args) {
        Servicable s = new Car("Audi", 2019, 100000, 4);
        s.performService();

        FleetApp app = new FleetApp();
        app.run();
    }
}

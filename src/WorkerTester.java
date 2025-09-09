public class WorkerTester {
    public static void main(String[] args) {
        Worker askar = new Worker("000001", "Askar", "Bolot", "Esq.", 18, 20.0);
        System.out.println("Weekly Pay: " + askar.calculateWeeklyPay(20));
        askar.displayWeeklyPay(40.0);
    }
}

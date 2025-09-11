import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args) {
        ArrayList<Worker>  workers = new ArrayList<>();
        Worker workerOne = new Worker("000001", "Askar", "Bolot", "Esq.", 2007, 30.0);
        Worker workerTwo = new Worker("000002", "Aidar", "Bolot", "Esq.", 2000, 35.0);
        Worker worketThree = new Worker("000003", "Aidai", "Bolot", "Esq.", 1997, 33.0);

        SalaryWorker salaryWorkerOne = new SalaryWorker("000004", "Billy", "Bob", "Mr.", 1999,48.08, 100000);
        SalaryWorker salaryWorkerTwo = new SalaryWorker("000005", "Adilet", "Barbatov", "Mr.", 2001, 57.69, 120000);
        SalaryWorker salaryWorkerThree = new SalaryWorker("000006", "Bolot", "Bek", "Dr.", 1978, 52.88, 110000);

        workers.add(workerOne);
        workers.add(workerTwo);
        workers.add(worketThree);
        workers.add(salaryWorkerOne);
        workers.add(salaryWorkerTwo);
        workers.add(salaryWorkerThree);
        System.out.print("\t");
        System.out.printf("%12s %11s %11s %11s %11s %11s", "Worker 1", "Worker 2", "Worker 3", "Worker 4",  "Worker 5", "Worker 6");
        System.out.println("\n\t\t=========================================================================");
        int hoursWorked = 0;
        for (int week = 0; week < 3; week++) {
            if (week == 0) {
                hoursWorked = 40;
            } else if (week == 1) {
                hoursWorked = 50;
            } else {
                hoursWorked = 40;
            }
            System.out.print("Week " + (week+1) + "\t");

            for (Worker worker : workers) {

                double weeklyPay = worker.calculateWeeklyPay(hoursWorked);
                System.out.printf("$%4.1f", weeklyPay);


                System.out.print(" \t");


            }
            System.out.println();
            System.out.println("\t\t-------------------------------------------------------------------------");



        }
    }
}

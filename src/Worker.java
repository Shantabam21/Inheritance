import java.util.Objects;

/**
 * Represents a worker who is paid by the hour.
 * Extends the Person class to include hourly pay rate.
 *
 * @author Askar Bolot
 */
public class Worker extends Person{
    private double hourlyPayRate;

    public Worker(String ID, String firstName, String lastName, String title, int age, double hourlyPayRate) {
        super(ID, firstName, lastName, title, age);
        this.hourlyPayRate = hourlyPayRate;
    }

    @Override
    public String toString(){
        return super.getIDNum() + ", " + super.getFirstName() + ", " + super.getLastName() + ", " + super.getTitle() + ", " + super.getYOB() + ", " + hourlyPayRate;
    }

    /**
     *
     * @return the hourly rate of this worker object
     */
    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    /**
     * Sets the hourly rate of this object to that of the parameter
     * @param hourlyPayRate The amount earned by the worker
     */
    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    /**
     * Calculates the worker's weekly pay based on hours worked
     * Regular hours (up to 40) are paid by a regular amount
     * Overtime hours (>40) are paid 1.5 times the hourly rate
     * @param hoursWorked The number of hours the worker worked
     * @return the total pay for this week
     */
    double calculateWeeklyPay(double hoursWorked) {
        if (hoursWorked <= 40) {
            return hourlyPayRate * hoursWorked;

        } else {

            double overtimeHours = (hoursWorked - 40);
            double regularPay = hourlyPayRate * (hoursWorked - overtimeHours);
            double overtimePay = overtimeHours * (hourlyPayRate * 1.5);
            return regularPay + overtimePay;
        }

    }

    /**
     * Displays the total pay for this week
     * @param hoursWorked The number of hours the worker worked
     */
    void displayWeeklyPay(double hoursWorked) {
        double regularPay = hourlyPayRate * hoursWorked;
        if (hoursWorked <= 40) {
            System.out.printf("%-22s %-18s %-22s %-18s %-18s", "Regular Pay hours", "Regular Pay", "Overtime Pay Hours", "Overtime Pay", "Combined Pay");
            System.out.println("======================================================================================================");
            System.out.printf("%-22s %-18s %-22s %-18s %-18s", hoursWorked, regularPay, 0, 0, regularPay);
        } else {
            double overtimeHours = (hoursWorked - 40);
            regularPay = hourlyPayRate * (hoursWorked - overtimeHours);
            double overtimePay = overtimeHours * (hourlyPayRate * 1.5);

            System.out.printf("%-22s %-18s %-22s %-18s %-18s", "Regular Pay hours", "Regular Pay", "Overtime Pay Hours", "Overtime Pay", "Combined Pay");
            System.out.println();
            System.out.println("======================================================================================================");
            System.out.printf("%-22s %-18s %-22s %-18s %-18s", (hoursWorked - overtimeHours), regularPay, overtimeHours, overtimePay, (regularPay + overtimePay));
        }

    }

    /**
     * creates a CSV data string that encodes all the data for this object instance
     * @return CSV data string containing ID number, first name, last name, title, year of birth, and hourly rate
     */
    @Override
    public String toCVS() {
        return super.getIDNum() + ", " + super.getFirstName() + ", " + super.getLastName() + ", " + super.getTitle() + ", " + super.getYOB() + ", " + hourlyPayRate;
    }

    /**
     * creates a JSON data string that encodes all the data for this object instance
     * @return JSON data string containing ID number, first name, last name, title, year of birth, and hourly rate
     */
    @Override
    public String toJSON() {
        return "{" +
                "\"IDNum\":\"" + super.getIDNum() + "\"," +
                "\"firstName\":\"" + super.getFirstName() + "\"," +
                "\"lastName\":\"" + super.getLastName() + "\"," +
                "\"title\":\"" + super.getTitle() + "\"," +
                "\"YOB\":\"" + super.getYOB() + "\"," +
                "\"hourlyPayRate\":\"" + hourlyPayRate + "\"" +
                "}";
    }
    /**
     * creates an XML data string that encodes all the data for this object instance
     * @return XML data string containing ID number, first name, last name, title, year of birth, and hourly rate
     */
    @Override
    public String toXML() {
        String retString = "<Worker>";
        retString += "<IDNum>" + super.getIDNum() + "</IDNum>";
        retString += "<firstName>" + super.getFirstName() + "</firstName>";
        retString += "<lastName>" + super.getLastName() + "</lastName>";
        retString += "<title>" + super.getTitle() + "</title>";
        retString += "<YOB>" + super.getYOB() + "</YOB>";
        retString += "<hourlyPayRate>" + hourlyPayRate + "</hourlyPayRate></Worker>";
        return retString;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return Double.compare(hourlyPayRate, worker.hourlyPayRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hourlyPayRate);
    }
}

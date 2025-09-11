import java.util.Objects;

public class SalaryWorker extends Worker{
    private double annualSalary;

    public SalaryWorker(String ID, String firstName, String lastName, String title, int age, double hourlyPayRate,double annualSalary) {
        super(ID, firstName, lastName, title, age, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52;
    }

    @Override
    public void displayWeeklyPay(double hoursWorked) {
        double weeklyPay = annualSalary / 52;
        System.out.println("Weekly Pay (a fraction of the yearly salary): ");
        System.out.printf("$%.2f", weeklyPay);

    }


    /**
     * creates a CSV data string that encodes all the data for this object instance
     * @return CSV data string containing ID number, first name, last name, title, year of birth, hourly rate, and annual salary
     */
    @Override
    public String toCVS() {
        return super.getIDNum() + ", " + super.getFirstName() + ", " + super.getLastName() + ", " + super.getTitle() + ", " + super.getYOB() + ", " + super.getHourlyPayRate() + ", " + annualSalary;
    }

    /**
     * creates a JSON data string that encodes all the data for this object instance
     * @return JSON data string containing ID number, first name, last name, title, year of birth, hourly rate, and annual salary
     */
    @Override
    public String toJSON() {
        return "{" +
                "\"IDNum\":\"" + super.getIDNum() + "\"," +
                "\"firstName\":\"" + super.getFirstName() + "\"," +
                "\"lastName\":\"" + super.getLastName() + "\"," +
                "\"title\":\"" + super.getTitle() + "\"," +
                "\"YOB\":\"" + super.getYOB() + "\"," +
                "\"hourlyPayRate\":\"" + super.getHourlyPayRate() + "\"," +
                "\"annualSalary\":\"" + annualSalary + "\"" +
                "}";
    }
    /**
     * creates an XML data string that encodes all the data for this object instance
     * @return XML data string containing ID number, first name, last name, title, year of birth, hourly rate, and annual salary
     */
    @Override
    public String toXML() {
        String retString = "<SalaryWorker>";
        retString += "<IDNum>" + super.getIDNum() + "</IDNum>";
        retString += "<firstName>" + super.getFirstName() + "</firstName>";
        retString += "<lastName>" + super.getLastName() + "</lastName>";
        retString += "<title>" + super.getTitle() + "</title>";
        retString += "<YOB>" + super.getYOB() + "</YOB>";
        retString += "<hourlyPayRate>" + super.getHourlyPayRate() + "</hourlyPayRate>";
        retString += "<annualSalary>" + annualSalary + "</annualSalary>" + "</SalaryWorker>";
        return retString;
    }

    /**
     *
     * @return annual salary amount for the salary worker
     */
    public double getAnnualSalary() {
        return annualSalary;
    }

    /**
     * Sets the annual salary of this object to that of the parameter
     * @param annualSalary The amount earned by the salary worker
     */
    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SalaryWorker that = (SalaryWorker) o;
        return Double.compare(annualSalary, that.annualSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), annualSalary);
    }
}

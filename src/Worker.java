public class Worker extends Person{
    private double hourlyPayRate;

    public Worker(String ID, String firstName, String lastName, String title, int age, double hourlyPayRate) {
        super(ID, firstName, lastName, title, age);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

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
    void displayWeeklyPay(double hoursWorked) {

        double overtimeHours = (hoursWorked - 40);
        double regularPay = hourlyPayRate * (hoursWorked - overtimeHours);
        double overtimePay = overtimeHours * (hourlyPayRate * 1.5);
        System.out.println("Regular Pay hours: " + (hoursWorked - overtimeHours));
        System.out.println("Regular Pay: " + regularPay);
        System.out.println("Overtime Pay hours: " + overtimeHours);
        System.out.println("Overtime Pay: " + overtimePay);
        System.out.println("Combined Pay: " + (regularPay + overtimePay));

    }

    /**
     * creates a CSV data string that encodes all the data for this object instance
     * @return CSV data string containing ID number, first name, last name, title, and year of birth
     */
    @Override
    public String toCVS() {
        return super.getIDNum() + ", " + super.getFirstName() + ", " + super.getLastName() + ", " + super.getTitle() + ", " + super.getYOB() + ", " + hourlyPayRate;
    }

    /**
     * creates a JSON data string that encodes all the data for this object instance
     * @return JSON data string containing ID number, first name, last name, title, and year of birth
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
     * @return XML data string containing ID number, first name, last name, title, and year of birth
     */
    @Override
    public String toXML() {
        String retString = "<Person>";
        retString += "<IDNum>" + super.getIDNum() + "</IDNum>";
        retString += "<firstName>" + super.getFirstName() + "</firstName>";
        retString += "<lastName>" + super.getLastName() + "</lastName>";
        retString += "<title>" + super.getTitle() + "</title>";
        retString += "<YOB>" + super.getYOB() + "</YOB>";
        retString += "<hourlyPayRate>" + hourlyPayRate + "</YOB></Person>";
        return retString;
    }



}

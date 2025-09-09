/**
 * author - Askar Bolot
 */

import java.util.Calendar;
import java.util.Objects;

public class Person {
    private String IDNum;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;
    private Calendar calendar;

    public Person(String IDNum, String firstName, String lastName, String title, int age) {
        this.IDNum = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = age;
        this.calendar = Calendar.getInstance();
    }

    /**
     * creates a CSV data string that encodes all the data for this object instance
     * @return CSV data string containing ID number, first name, last name, title, and year of birth
     */
    public String toCVS() {
        return IDNum + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }

    /**
     * creates a JSON data string that encodes all the data for this object instance
     * @return JSON data string containing ID number, first name, last name, title, and year of birth
     */
    public String toJSON() {
        return "{" +
                "\"IDNum\":\"" + IDNum + "\"," +
                "\"firstName\":\"" + firstName + "\"," +
                "\"lastName\":\"" + lastName + "\"," +
                "\"title\":\"" + title + "\"," +
                "\"YOB\":" + YOB + "," +
                "}";
    }
    /**
     * creates an XML data string that encodes all the data for this object instance
     * @return XML data string containing ID number, first name, last name, title, and year of birth
     */
    public String toXML() {
        String retString = "<Person>";
        retString += "<IDNum>" + IDNum + "</IDNum>";
        retString += "<firstName>" + firstName + "</firstName>";
        retString += "<lastName>" + lastName + "</lastName>";
        retString += "<title>" + title + "</title>";
        retString += "<YOB>" + YOB + "</YOB></Person>";
        return retString;
    }


    @Override
    public String toString() {
        return IDNum + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }

    /**
     * Acceses the instance variable IDNum
     * @return IDNum instance variable (a string)
     */
    public String getIDNum() {
        return IDNum;
    }

    /**
     * Sets the instance variable IDNum to that of the parameter
     * @param IDNum - the ID number to assign to this object
     */
    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    /**
     * Acceses the instance variable firstName
     * @return firstName instance variable (a string)
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the instance variable firstName to that of the parameter
     * @param firstName - the first name string to assign to this object
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Acceses the instance variable lastName
     * @return lastName instance variable (a string)
     *
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the instance variable lastName to that of the parameter
     * @param lastName - the last name string to assign to this object
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Acceses the instance variable title
     * @return title instance variable (a string)
     *
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the instance variable title to that of the parameter
     * @param title - the title string to assign to this object
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Acceses the instance variable YOB
     * @return YOB instance variable (an int)
     *
     */
    public int getYOB() {
        return YOB;
    }

    /**
     * Acceses the age of the person using the calendar class to calculate the person's current age by substracting
     * the current year and the year given by the parameter which would be the person's age
     * @param year - the year the person was born
     * @return Age of person
     *
     */
    public int getAge(int year) {
        return calendar.get(Calendar.YEAR) - year;
    }

    /**
     * Sets the instance variable YOB to that of the parameter
     * @param YOB - the YOB int to assign to this object
     */
    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return YOB == person.YOB && Objects.equals(IDNum, person.IDNum) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(title, person.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IDNum, firstName, lastName, title, YOB);
    }

    /**
     * Acceses the instance variables firstName and lastName and combines them into a full name
     * @return the full name of that person using the format "first name last name"
     *
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * Acceses the instance variables title, firstName and lastName and combines them into a formal name
     * @return the formal name of that person using the format "title first name last name"
     *
     */
    public String getFormalName() {
        return title + " " + firstName + " " + lastName;
    }


}
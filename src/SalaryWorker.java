public class SalaryWorker extends Worker {
    private double annualSalary;

    /**
     * Constructs a SalaryWorker object with the specified attributes.
     *
     * @param id the ID of the salary worker
     * @param firstName the first name of the salary worker
     * @param lastName the last name of the salary worker
     * @param title the title of the salary worker
     * @param yearOfBirth the year of birth of the salary worker
     * @param hourlyPayRate the hourly pay rate (not used in SalaryWorker)
     * @param annualSalary the annual salary of the salary worker
     */
    public SalaryWorker(String id, String firstName, String lastName, String title, int yearOfBirth, double hourlyPayRate, double annualSalary) {
        super(id, firstName, lastName, title, yearOfBirth, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    /**
     * Calculates the weekly pay based on the annual salary.
     *
     * @param hoursWorked the number of hours worked in a week (not used)
     * @return the weekly pay for the salary worker
     */
    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52;
    }

    /**
     * Displays the weekly pay details based on the annual salary.
     *
     * @param hoursWorked the number of hours worked in a week (not used)
     */
    @Override
    public void displayWeeklyPay(double hoursWorked) {
        double weeklyPay = calculateWeeklyPay(hoursWorked);
        System.out.println("Weekly Pay Details for Salary Worker:");
        System.out.printf("Weekly Pay: $%.2f (This is a fraction of the annual salary of $%.2f)%n", weeklyPay, annualSalary);
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + annualSalary;
    }

    @Override
    public String toJSON() {
        return super.toJSON().replace("}", ",\"annualSalary\":" + annualSalary + "}");
    }

    @Override
    public String toXML() {
        return super.toXML().replace("</Person>", "<AnnualSalary>" + annualSalary + "</AnnualSalary></Person>");
    }
}

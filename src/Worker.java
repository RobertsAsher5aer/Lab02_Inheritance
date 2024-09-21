public class Worker extends Person {
    private double hourlyPayRate;

    /**
     * Constructs a Worker object with the specified attributes.
     *
     * @param id the ID of the worker
     * @param firstName the first name of the worker
     * @param lastName the last name of the worker
     * @param title the title of the worker
     * @param yearOfBirth the year of birth of the worker
     * @param hourlyPayRate the hourly pay rate of the worker
     */
    public Worker(String id, String firstName, String lastName, String title, int yearOfBirth, double hourlyPayRate) {
        super(id, firstName, lastName, title, yearOfBirth);
        this.hourlyPayRate = hourlyPayRate;
    }

    /**
     * Calculates the weekly pay based on hours worked.
     *
     * @param hoursWorked the number of hours worked in a week
     * @return the total pay for the week
     */
    public double calculateWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(hoursWorked, 40);
        double overtimeHours = Math.max(0, hoursWorked - 40);
        double overtimePay = overtimeHours * hourlyPayRate * 1.5;
        double regularPay = regularHours * hourlyPayRate;
        return regularPay + overtimePay;
    }

    /**
     * Displays the weekly pay details.
     *
     * @param hoursWorked the number of hours worked in a week
     */
    public void displayWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(hoursWorked, 40);
        double overtimeHours = Math.max(0, hoursWorked - 40);
        double totalPay = calculateWeeklyPay(hoursWorked);

        double regularPay = regularHours * hourlyPayRate;
        double overtimePay = overtimeHours * hourlyPayRate * 1.5;

        System.out.println("Weekly Pay Details:");
        System.out.printf("Regular Hours: %.2f at $%.2f/hour = $%.2f%n", regularHours, hourlyPayRate, regularPay);
        System.out.printf("Overtime Hours: %.2f at $%.2f/hour = $%.2f%n", overtimeHours, hourlyPayRate * 1.5, overtimePay);
        System.out.printf("Total Pay: $%.2f%n", totalPay);
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + hourlyPayRate;
    }

    @Override
    public String toJSON() {
        return super.toJSON().replace("}", ",\"hourlyPayRate\":" + hourlyPayRate + "}");
    }

    @Override
    public String toXML() {
        return super.toXML().replace("</Person>", "<HourlyPayRate>" + hourlyPayRate + "</HourlyPayRate></Person>");
    }
}

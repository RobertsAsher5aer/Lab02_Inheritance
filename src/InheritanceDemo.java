import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args) {
        // Create an ArrayList to hold Workers
        ArrayList<Worker> workers = new ArrayList<>();

        // Create 3 Worker instances
        workers.add(new Worker("W001", "Asher", "Roberts", "Technician", 2007, 25.0));
        workers.add(new Worker("W002", "Jerry", "Seinfeld", "Operator", 1954, 20.0));
        workers.add(new Worker("W003", "Charlie", "Brown", "Assembler", 1992, 18.0));

        // Create 3 SalaryWorker instances
        workers.add(new SalaryWorker("SW001", "Bandit", "Heeler", "Manager", 2018, 0.0, 80000.0));
        workers.add(new SalaryWorker("SW002", "Spongebob", "Squarepants", "Director", 1999, 0.0, 95000.0));
        workers.add(new SalaryWorker("SW003", "Beast", "Boy", "Supervisor", 2013, 0.0, 72000.0));

        // Display the weekly pay for each worker for 3 weeks
        System.out.printf("%-20s %-15s %-10s %-10s %-10s %-10s %-10s%n", "Name", "ID", "Week 1", "Week 2", "Week 3", "Type", "YOB");
        System.out.println("-----------------------------------------------------------------------------------------");

        for (Worker worker : workers) {
            // Calculate pay for three weeks
            double week1Pay = worker.calculateWeeklyPay(40); // Week 1: 40 hours
            double week2Pay = worker.calculateWeeklyPay(50); // Week 2: 50 hours
            double week3Pay = worker.calculateWeeklyPay(40); // Week 3: 40 hours

            // Display the results
            System.out.printf("%-20s %-15s $%-10.2f $%-10.2f $%-10.2f %-10s %d%n",
                    worker.getFirstName() + " " + worker.getLastName(),
                    worker.getId(),
                    week1Pay,
                    week2Pay,
                    week3Pay,
                    (worker instanceof SalaryWorker) ? "Salary" : "Hourly",
                    worker.getYearOfBirth());
        }
    }
}

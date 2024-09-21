import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SalaryWorkerTest {

    private SalaryWorker salaryWorker;

    @Before
    public void setUp() {
        // Create a SalaryWorker instance for testing
        salaryWorker = new SalaryWorker("SW001", "Jane", "Smith", "Manager", 1985, 0.0, 52000.0);
    }

    @Test
    public void testCalculateWeeklyPay() {
        double pay = salaryWorker.calculateWeeklyPay(0); // hoursWorked parameter is not used
        assertEquals(1000.0, pay, 0.001); // 52000 / 52 = 1000
    }

    @Test
    public void testDisplayWeeklyPay() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        salaryWorker.displayWeeklyPay(0); // hoursWorked parameter is not used

        String output = outputStream.toString();
        assertTrue(output.contains("Weekly Pay: $1000.00 (This is a fraction of the annual salary of $52000.00)"));

        System.setOut(System.out); // Reset the System.out
    }

    @Test
    public void testToCSV() {
        String expectedCSV = "SW001,Jane,Smith,Manager,1985,0.0,52000.0";
        assertEquals(expectedCSV, salaryWorker.toCSV());
    }

    @Test
    public void testToJSON() {
        String expectedJSON = "{\"id\":\"SW001\",\"firstName\":\"Jane\",\"lastName\":\"Smith\",\"title\":\"Manager\",\"yearOfBirth\":1985,\"hourlyPayRate\":0.0,\"annualSalary\":52000.0}";
        assertEquals(expectedJSON, salaryWorker.toJSON());
    }

    @Test
    public void testToXML() {
        String expectedXML = "<Person><Id>SW001</Id><FirstName>Jane</FirstName><LastName>Smith</LastName><Title>Manager</Title><YearOfBirth>1985</YearOfBirth><HourlyPayRate>0.0</HourlyPayRate><AnnualSalary>52000.0</AnnualSalary></Person>";
        assertEquals(expectedXML, salaryWorker.toXML());
    }
}

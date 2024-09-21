import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class WorkerTest {

    private Worker worker;

    @Before
    public void setUp() {
        // Create a Worker instance for testing
        worker = new Worker("W001", "John", "Doe", "Engineer", 1990, 20.0);
    }

    @Test
    public void testCalculateWeeklyPayRegularHours() {
        double pay = worker.calculateWeeklyPay(40);
        assertEquals(800.0, pay, 0.001); // 40 hours * $20/hour
    }

    @Test
    public void testCalculateWeeklyPayOvertimeHours() {
        double pay = worker.calculateWeeklyPay(50);
        assertEquals(1100.0, pay, 0.001); // 40 hours * $20 + 10 hours * $30
    }

    @Test
    public void testCalculateWeeklyPayNoHours() {
        double pay = worker.calculateWeeklyPay(0);
        assertEquals(0.0, pay, 0.001); // No hours worked
    }

    @Test
    public void testDisplayWeeklyPay() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        worker.displayWeeklyPay(50);

        String output = outputStream.toString();
        assertTrue(output.contains("Regular Hours: 40.00 at $20.00/hour = $800.00"));
        assertTrue(output.contains("Overtime Hours: 10.00 at $30.00/hour = $300.00"));
        assertTrue(output.contains("Total Pay: $1100.00"));

        System.setOut(System.out); // Reset the System.out
    }

    @Test
    public void testToCSV() {
        String expectedCSV = "W001,John,Doe,Engineer,1990,20.0";
        assertEquals(expectedCSV, worker.toCSV());
    }

    @Test
    public void testToJSON() {
        String expectedJSON = "{\"id\":\"W001\",\"firstName\":\"John\",\"lastName\":\"Doe\",\"title\":\"Engineer\",\"yearOfBirth\":1990,\"hourlyPayRate\":20.0}";
        assertEquals(expectedJSON, worker.toJSON());
    }

    @Test
    public void testToXML() {
        String expectedXML = "<Person><Id>W001</Id><FirstName>John</FirstName><LastName>Doe</LastName><Title>Engineer</Title><YearOfBirth>1990</YearOfBirth><HourlyPayRate>20.0</HourlyPayRate></Person>";
        assertEquals(expectedXML, worker.toXML());
    }
}

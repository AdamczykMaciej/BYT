import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
	Employee employee;
	SimpleDateFormat sdf;
	Date startDate;
	Date endDate;
	Date birthDate;
	Task task;
	
	@Before
	public void setUp() throws ParseException {
		sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String startDateInString = "01-01-2019 10:20:56";
		String endDateInString = "20-01-2019 10:20:56";
		String birth = "20-01-1997 12:20:56";
		startDate = sdf.parse(startDateInString);
		endDate = sdf.parse(endDateInString);
		birthDate = sdf.parse(birth);
		employee = new Employee("Jan", "Kowalski", "kowal1234", "kowal@gmail.com", "Accountant", birthDate,"+48 767 876 234");
		task = new Task("BYT project", "finish LAB10_11", startDate, endDate, false, employee);
	}
	
	@Test
	public void testGetCreateTasks() {
		employee.createTask(task);
		assertEquals(task, employee.getTasks()[0]);
	}
	
	@Test
	public void testChangeGetPassword() {
		employee.changePassowrd("PJATK1234pass");
		assertEquals("PJATK1234pass", employee.getPassword());
	}
	
	@Test
	public void testDeleteTask() {
		employee.createTask(task);
		employee.deleteTask(task);
		Assert.assertEquals(0,employee.getTasks().length);
	}
	
	@Test
	public void testEditTask() {
		employee.createTask(task);
		Task t2 = new Task("BYT", "finish LAB10_11", startDate, endDate, false, employee);
		employee.editTask(task, t2);
		assertEquals(t2,employee.getTasks()[0]);
		
		//editing not own task
		Supervisor supervisor = new Supervisor("Pawe³", "Nowal", "blabla1234", "pablo@gmail.com", "Accountant", birthDate,"+48 797 876 234");
		Task t3 = new Task("BYT", "finish LAB10_11", startDate, endDate, false, supervisor);
		assertEquals(false, employee.editTask(t3, task));
		
		// editing supervisor's task for an employee by the employee
		supervisor.setTeam("13c", new Employee[] {employee});
		supervisor.assignTask(employee, t3);
		Task edited = new Task("BYT", "finish LAB10_11", startDate, endDate, false, employee);
		supervisor.assignTask(employee, edited);
		assertEquals(false,employee.editTask(t3, edited));
	}
	
	@Test
	public void testSetters() throws ParseException {
		employee.setFirstName("Franek");
		assertEquals("Franek", employee.getFirstName());
		
		employee.setLastName("Zielinski");
		assertEquals("Zielinski", employee.getLastName());
		
		employee.setEmail("franke@gmail.com");
		assertEquals("franke@gmail.com", employee.getEmail());
		
		employee.setPassword("franke1234");
		assertEquals("franke1234", employee.getPassword());
		
		employee.setPhoneNumber("+48 783 234 213");
		assertEquals("+48 783 234 213", employee.getPhoneNumber());
		
		employee.setPosition("Junior Programmer");
		assertEquals("Junior Programmer", employee.getPosition());
		
		Date bDate = sdf.parse("20-01-1999 12:20:56");
		employee.setDateOfBirth(bDate);
		assertEquals(bDate, employee.getDateOfBirth());
	}
}

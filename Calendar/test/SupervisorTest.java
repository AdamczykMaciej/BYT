import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class SupervisorTest {
	Supervisor supervisor;
	SimpleDateFormat sdf;
	Date startDate;
	Date endDate;
	Date birthDate;
	Task task;
	Group group;
	Employee employee;
	
	@Before
	public void setUp() throws ParseException {
		sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String startDateInString = "01-01-2019 10:20:56";
		String endDateInString = "20-01-2019 10:20:56";
		String birth = "20-01-1997 12:20:56";
		startDate = sdf.parse(startDateInString);
		endDate = sdf.parse(endDateInString);
		birthDate = sdf.parse(birth);
		supervisor = new Supervisor("Jan", "Kowalski", "kowal1234", "kowal@gmail.com", "Accountant", birthDate,"+48 767 876 234");
		task = new Task("BYT project", "finish LAB10_11", startDate, endDate, false, supervisor);
		employee = new Employee("Jan", "Kowalski", "kowal1234", "kowal@gmail.com", "Accountant", birthDate,"+48 767 876 234");
	}
	
	@Test
	public void testCreateGroup() {
		group = supervisor.createGroup("13c", new Employee[] {});
		assertNotNull(group);
	}
	
	@Test
	public void testAssignTask() {
		employee = new Employee("Jan", "Kowalski", "kowal1234", "kowal@gmail.com", "Accountant", birthDate,"+48 767 876 234");
		supervisor.setTeam("13c", new Employee[] {employee});
		supervisor.assignTask(employee, task);
		assertEquals(task, employee.getTasks()[0]);
		
	}
	
	@Test
	public void testDeleteSubordinateTask() {
		employee = new Employee("Jan", "Kowalski", "kowal1234", "kowal@gmail.com", "Accountant", birthDate,"+48 767 876 234");
		supervisor.setTeam("13c", new Employee[] {employee});
		supervisor.assignTask(employee, task);
		assertEquals(task, employee.getTasks()[0]);
	}
	
	@Test
	public void testEditSubordinateTask() {
		employee = new Employee("Jan", "Kowalski", "kowal1234", "kowal@gmail.com", "Accountant", birthDate,"+48 767 876 234");
		supervisor.setTeam("13c", new Employee[] {employee});
		supervisor.assignTask(employee, task);
		Task task2 = new Task("BYT LAB 2", "finish LAB2", startDate, endDate, false, supervisor);
		supervisor.editSubordinateTask(employee, task, task2);
		assertEquals(task2.getName(),employee.getTasks()[0].getName());
	}
}

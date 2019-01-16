import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskTest {
	Task task;
	Employee creator;
	SimpleDateFormat sdf;
	Date startDate;
	Date endDate;
	Date birthDate;
	
	@BeforeEach
	public void setUp() throws ParseException {
		sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String startDateInString = "01-01-2019 10:20:56";
		String endDateInString = "20-01-2019 10:20:56";
		String birth = "20-01-1997 12:20:56";
		startDate = sdf.parse(startDateInString);
		endDate = sdf.parse(endDateInString);
		birthDate = sdf.parse(birth);
		
		creator = new Employee("Jan", "Kowalski", "kowal1234", "kowal@gmail.com", "Accountant", birthDate,"+48 767 876 234");
		task = new Task("BYT project", "finish LAB10_11", startDate, endDate, false, creator);
	}
	
	@Test
	public void testGetters() throws ParseException {
		assertEquals("BYT project", task.getName());
		assertEquals("finish LAB10_11", task.getDescription());
		assertEquals(startDate, task.getStartDate());
		assertEquals(endDate, task.getEndDate());
		assertEquals(false, task.getMandatory());
		assertEquals(creator, task.getCreator());
	}
	
	@Test
	public void testSetters() throws ParseException {
		
		task.setName("BYT");
		assertEquals("BYT", task.getName());
		task.setDescription("description");
		assertEquals("description", task.getDescription());
		
		Date d1 = sdf.parse("09-04-2018 11:21:56");
		task.setStartDate(d1);
		assertEquals(d1, task.getStartDate());
		
		Date d2 = sdf.parse("19-04-2018 11:21:56");
		task.setEndDate(d2);
		assertEquals(d2, task.getEndDate());
		
		task.setMandatory(true);
		assertEquals(true, task.getMandatory());
		
		Employee creator2 = new Employee("Rudolf", "Kowalski", "kowal1234", "kowal@gmail.com", "Accountant", birthDate,"+48 767 876 234");
		task.setCreator(creator2);
		assertEquals(creator2, task.getCreator());
	}
	
	@Test
	public void testSeeDetails() {
		assertEquals("Name: BYT project , Description: finish LAB10_11 , Start date: " + startDate
		+ " , End date: " +endDate + " , Mandatory: " + false + " , Creator: " + creator,"Name: " + task.getName() + " , Description: " + task.getDescription() + " , Start date: " + task.getStartDate()
		+ " , End date: " + task.getEndDate() + " , Mandatory: " + task.getMandatory() + " , Creator: " + task.getCreator());
	}
	
	@Test
	public void testChangeType() {
		task = task.changeType("accepted",null);
		assertEquals(AcceptedTask.class ,task.getClass());
		
		task = task.changeType("declined",null);
		assertEquals(DeclinedTask.class ,task.getClass());
	}
}

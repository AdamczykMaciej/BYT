import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class GroupTest {
	Employee employee;
	Group group;
	SimpleDateFormat sdf;
	Date startDate;
	Date endDate;
	Date birthDate;
	
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
		group = new Group("13c");
	}
	
	@Test
	public void testAddGetEmployee() {
		group.add(employee);
		assertEquals(employee, group.get()[0]);
	}
	
	@Test
	public void testRemove() {
		group.add(employee);
		assertEquals(1, group.get().length);
		group.remove(employee);
		assertEquals(0, group.get().length);
	}
}

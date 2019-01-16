import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TechnicalAdminTest {
	TechnicalAdmin techAdmin;
	SimpleDateFormat sdf;
	Date startDate;
	Date endDate;
	Date birthDate;
	Employee e;
	
	@Before
	public void setUp() throws ParseException {
		sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String startDateInString = "01-01-2019 10:20:56";
		String endDateInString = "20-01-2019 10:20:56";
		String birth = "20-01-1997 12:20:56";
		startDate = sdf.parse(startDateInString);
		endDate = sdf.parse(endDateInString);
		birthDate = sdf.parse(birth);
		techAdmin = new TechnicalAdmin("Jan", "Kowalski", "kowal1234", "kowal@gmail.com", "Accountant", birthDate,"+48 767 876 234");
		e = new Employee("Robert", "Linette", "kowal12345", "kowal22@gmail.com", "Junior Accountant", birthDate,"+48 727 876 234");
	}
	
	@Test
	public void testCreateEmployee() {
		Assert.assertNotNull(e);
	}
	
	@Test
	public void testDeleteEmployee() {
		assertEquals("Deleted", techAdmin.deleteEmployee(e));
	}
	
	@Test
	public void testEditEmployee() {
		
		techAdmin.editEmployee(e, "Rudolf", "Linette", "kowal12345", "kowal22@gmail.com", "Junior Accountant", birthDate,"+48 727 876 234");
		assertEquals("Rudolf", e.getFirstName());
	}
	
}

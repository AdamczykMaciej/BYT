import java.util.Date;

public class TechnicalAdmin extends Employee {

	public TechnicalAdmin(String firstName, String lastName, String password, String email, String position,
			Date dateOfBirth, String phoneNumber) {
		super(firstName, lastName, password, email, position, dateOfBirth, phoneNumber);
	}

	public Employee createEmployee(String firstName, String lastName, String password, String email, String position,
			Date dateOfBirth, String phoneNumber) {
		return new Employee(firstName, lastName, password, email, position, dateOfBirth, phoneNumber);
	}

	public String deleteEmployee(Employee e) {
		return "Deleted";
	}

	public void editEmployee(Employee e, String firstName, String lastName, String password, String email,
			String position, Date dateOfBirth, String phoneNumber) {
		e.setFirstName(firstName);
		e.setLastName(lastName);
		e.setPassword(password);
		e.setEmail(email);
		e.setPosition(position);
		e.setDateOfBirth(dateOfBirth);
		e.setPhoneNumber(phoneNumber);
	}

}

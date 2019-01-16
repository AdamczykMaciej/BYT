import java.util.Date;

public class Employee {
	String firstName;
	String lastName;
	String password;
	String email;
	String position;
	Date dateOfBirth;
	String phoneNumber;
	Group[] groups;
	Task[] tasks;

	public Employee(String name, String surname, String password, String email, String position, Date birth,
			String phone) {
		this.firstName = name;
		this.lastName = surname;
		this.password = password;
		this.email = email;
		this.position = position;
		this.dateOfBirth = birth;
		this.phoneNumber = phone;

		groups = new Group[] {};
		tasks = new Task[] {};
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;

	}

	public void setPassword(String password) {
		this.password = password;

	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setPosition(String position) {
		this.position = position;

	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setTasks(Task[] tasks){
		this.tasks = tasks;
	}

	public String getPassword() {
		return password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getPosition() {
		return position;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}
	
	public Task[] getTasks() {
		return tasks;
	}

	public boolean changePassowrd(String newPassword) {
		password = newPassword;
		return password.equals(newPassword);
	}

	public boolean createTask(Task task) {
		int current = tasks.length;
		Task[] arr = new Task[current + 1];
		for(int i = 0; i<current;i++)
			arr[i] = tasks[i];
		arr[current] = task;
		tasks = arr;
		return check(task);
	}

	public boolean deleteTask(Task task) {
		Task[] substracted = new Task[tasks.length - 1];
		for (int i = 0; i < tasks.length; i++) {
			if (tasks[i] == task)
				for (int j = i + 1; j < tasks.length; j++)
					tasks[i] = tasks[j];
			else
				substracted[i] = tasks[i];
		}
		tasks = substracted;
		return !check(task);
	}
	

	public boolean editTask(Task to_edit, Task edited) { // zak³adam ¿e user dostaje liste tasków z get i wybiera task
											// do zimany
		if (!to_edit.getCreator().equals(this))
				return false;
		for (int i = 0; i < tasks.length; i++) {
			if (tasks[i].equals(to_edit)) {
				tasks[i] = edited;
				return true;
			}
		}
		return false;
	}

	private boolean check(Task task) {
		for (Task t : tasks)
			if (t.equals(task))
				return true;
		return false;
	}

}

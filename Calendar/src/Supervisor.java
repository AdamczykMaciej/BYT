import java.util.Date;

public class Supervisor extends Employee {

	Team team; // jest identyczny do grupy tylko supervisor ma referencjê

	public Supervisor(String name, String surname, String password, String email, String position, Date birth,
			String phone) {
		super(name, surname, password, email, position, birth, phone);
	}

	public void setTeam(String name, Employee[] emps) {
		team = new Team(name, emps);
	}

	public Employee[] getTeam() {
		return team.get();
	}

	public Group createGroup(String name, Employee emps[]) {
		return new Group(name, emps);
	}

	public boolean assignTask(Employee emp, Task task) {
		int e = check(emp);
		if (e < 0)
			return false;
		if (!team.get()[e].createTask(task))
			return false;
		return true;
	}

	public boolean deleteSubordinateTask(Employee emp, Task task) {
		int e = check(emp);
		if (e < 0)
			return false;
		if (!team.get()[e].deleteTask(task))
			return false;
		return true;
	}

	public boolean editSubordinateTask(Employee emp,Task task_to_edit ,Task edited){
		int e = check(emp);
		if(e<0)
			return false;
		else{
			tasks = this.getTeam()[e].getTasks();
			for(int i = 0; i < tasks.length;i++)
				if(tasks[i].equals(task_to_edit)){
					tasks[i] = edited;
					return true;
				}
			return false;		
		}
			
	}
	
	private int check(Employee emp) {
		for (int i = 0; i < team.get().length; i++) {
			if (team.get()[i].equals(emp))
				return i;
		}
		return -1;
	}
	
}

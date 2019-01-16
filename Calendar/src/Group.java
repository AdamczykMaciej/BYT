public class Group {

	Employee[] members;
	String name;

	public Group(String name) {
		this.name = name;
		members = new Employee[] {};
	}

	public Group(String name, Employee[] members) {
		this.name = name;
		this.members = members;
	}

	public boolean add(Employee e){
	    Employee[] arr = new Employee[members.length + 1];
	    arr[members.length] = e;
	    for(int i = 0; i < members.length; i++)
	      arr[i] = members[i];
	    members = arr;
	    if(check(e))
	      return true;
	    return false;
	  }

	public Employee[] get() {
		return members;
	}

	public boolean remove(Employee emp) {
		Employee[] arr = new Employee[members.length - 1];
		for (int i = 0, j = 0; i < members.length - 1; i++) {
			if (members[i].equals(emp))
				j = 1;
			arr[i] = members[i + j];
		}
		members = arr;
		return !check(emp);
	}

	private boolean check(Employee emp) {
		for (Employee e : members)
			if (e.equals(emp))
				return true;
		return false;
	}

}

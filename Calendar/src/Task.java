import java.util.Date;

public class Task {
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private boolean mandatory;
	private Employee creator;

	public Task(String name, String description, Date startDate, Date endDate, boolean mandatory, Employee creator) {
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.mandatory = mandatory;
		this.creator = creator;
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String d) {
		description = d;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date d) {
		startDate = d;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date d) {
		endDate = d;
	}

	public boolean getMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean b) {
		mandatory = b;
	}

	public Employee getCreator() {
		return creator;
	}

	public void setCreator(Employee c) {
		creator = c;
	}

	public String seeDetails() {
		return "Name: " + this.name + " , Description: " + this.description + " , Start date: " + this.startDate
				+ " , End date: " + this.endDate + " , Mandatory: " + this.mandatory + " , Creator: " + this.creator;
	}

	public Task changeType(String taskType, String comment) {
		if (taskType.equals("accepted")) {
			return new AcceptedTask(name, description, startDate, endDate, mandatory, creator);
		} else if(taskType.equals("declined")) {
			return new DeclinedTask(name, description, startDate, endDate, mandatory, creator, comment);
		} else {
			return null;
		}
	}

}

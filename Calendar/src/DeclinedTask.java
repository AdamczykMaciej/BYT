import java.util.Date;

public class DeclinedTask extends Task {
	private String comment;

	public DeclinedTask(String n, String d, Date sd, Date ed, boolean m, Employee c, String com) {
		super(n, d, sd, ed, m, c);
		comment = com;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String c) {
		comment = c;
	}

}

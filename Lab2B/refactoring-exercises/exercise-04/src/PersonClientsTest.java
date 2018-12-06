// The Person class has multiple clients, but all of the clients are in 
// one file for convenience.  Imagine them as non-test methods in separate 
// client classes.

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.*;

public class PersonClientsTest {

	@Test
	public void testClients() throws IOException {
		Person bobSmith = new Person("Smith", "Bob", null);
		Person jennyJJones = new Person("Jones", "Jenny", "J");

		StringWriter out = new StringWriter();
		Person.printPerson(out, bobSmith);
		assertEquals("Bob Smith", out.toString());

		out = new StringWriter();
		Person.printPerson(out, jennyJJones);
		assertEquals("Jenny J Jones", out.toString());

		assertEquals("Smith, Bob", Person.formatPerson(bobSmith));
		assertEquals("Jones, Jenny J", Person.formatPerson(jennyJJones));

		out = new StringWriter();
		Person.display(out, bobSmith);
		assertEquals("Smith, Bob", out.toString());

		out = new StringWriter();
		Person.display(out, jennyJJones);
		assertEquals("Jones, Jenny J", out.toString());

		assertEquals("Smith, Bob", Person.toString(bobSmith));
		assertEquals("Jones, Jenny J", Person.toString(jennyJJones));
	}
}

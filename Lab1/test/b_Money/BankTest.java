package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		assertEquals("SweBank",SweBank.getName());
		assertEquals("Nordea",Nordea.getName());
		assertEquals("DanskeBank",DanskeBank.getName());
	}

	@Test
	public void testGetCurrency() {
		assertEquals(SEK,SweBank.getCurrency());
		assertEquals(SEK,Nordea.getCurrency());
		assertEquals(DKK,DanskeBank.getCurrency());
	}
	
	// failed when no changes were made to methods in classes, AccountDoesNotExistException
	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		SweBank.openAccount("William");
		assertEquals("William",SweBank.getAccount("William").getName());
	}
	
	// failed before changes were made to methods in classes, NullPointerException
	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		SweBank.deposit("Bob", new Money(1000, SEK));
		assertEquals(Integer.valueOf(1000),SweBank.getBalance("Bob"));
	}
	
	// failed before changes were made to methods in classes, AccountDoesNotExistException
	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		SweBank.withdraw("Bob", new Money(1000, SEK));
		assertEquals(Integer.valueOf(-1000),SweBank.getBalance("Bob"));
		SweBank.withdraw("Bob", new Money(1000, DKK));
		assertEquals(Integer.valueOf(-2333),SweBank.getBalance("Bob"));
	}
	
	// failed before changes were made to methods in classes, NullPointerException
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		SweBank.deposit("Bob", new Money(1000, SEK));
		assertEquals(Integer.valueOf(1000),SweBank.getBalance("Bob"));
	}
	
	// failed before changes were made to methods in classes, NullPointerException
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		// the same bank
		SweBank.deposit("Bob", new Money(1000, SEK));
		SweBank.transfer("Bob", "Ulrika", new Money(1000, SEK));
		assertEquals(Integer.valueOf(0),SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf(1000),SweBank.getBalance("Ulrika"));
		
		// from a bank to another bank
		SweBank.deposit("Bob", new Money(1000, SEK));
		SweBank.transfer("Bob", Nordea, "Bob", new Money(1000, SEK));
		assertEquals(Integer.valueOf(0),SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf(1000),Nordea.getBalance("Bob"));
	}
	
	// failed before changes were made to methods in classes, a bug in Account tick() method
	// twice invoked
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		SweBank.addTimedPayment(
				"Bob",
				"Bob2 birthday",
				Integer.valueOf(10),
				Integer.valueOf(5),
				new Money(1000, SEK),
				Nordea,
				"Bob");
		
		SweBank.tick();
		assertEquals(Integer.valueOf(0), SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf(0), Nordea.getBalance("Bob"));
		for(int i=0; i<5; i++) {
			SweBank.tick();
		}
		assertEquals(Integer.valueOf(-1000), SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf(1000), Nordea.getBalance("Bob"));
		
		SweBank.addTimedPayment(
				"Bob",
				"Bob2 birthday",
				Integer.valueOf(10),
				Integer.valueOf(1),
				new Money(1000, SEK),
				Nordea,
				"Bob");
		SweBank.removeTimedPayment("Bob", "Bob2 birthday");
		SweBank.tick();
		SweBank.tick();
		assertEquals(Integer.valueOf(-1000), SweBank.getBalance("Bob"));
		assertEquals(Integer.valueOf(1000), Nordea.getBalance("Bob"));
	}
}

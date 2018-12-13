package com.vogella.maven.Lab9;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import com.vogella.maven.Lab9.memento.Caretaker;
import com.vogella.maven.Lab9.memento.Memento;

public class CaretakerTest {
	Caretaker c;
	
	@Before
	public void setUp() throws Exception {
		c = new Caretaker("D:\\PJATK_Informatyka\\3_rok\\BYT\\LAB9\\states.txt");
	}
	
	@Test
	public void testGetAddMemento() throws IOException, ParseException  {
		Memento mem = new Memento(new Date(1544704842000L));
		c.addMemento(mem);
		assertEquals(mem.GetState(), c.getMemento(0).GetState());
	}

}

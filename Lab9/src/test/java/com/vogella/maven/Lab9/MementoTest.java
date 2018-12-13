package com.vogella.maven.Lab9;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.vogella.maven.Lab9.memento.Memento;

public class MementoTest {
	Memento m;
	@Before
	public void setUp() throws Exception {
		m = new Memento(new Date(1544704842000L));
	}
	
	@Test
	public void getAddState() {
		assertEquals(new Date(1544704842000L), m.GetState());
		m.SetState(new Date(1544704844000L));
		assertEquals(new Date(1544704844000L), m.GetState());
	}
	
}

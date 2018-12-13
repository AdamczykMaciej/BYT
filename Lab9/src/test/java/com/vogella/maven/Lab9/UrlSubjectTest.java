package com.vogella.maven.Lab9;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.vogella.maven.Lab9.memento.Memento;
import com.vogella.maven.Lab9.observer.Observer;
import com.vogella.maven.Lab9.observer.UrlObserver;
import com.vogella.maven.Lab9.observer.UrlSubject;

public class UrlSubjectTest {
	Observer o;
	UrlSubject s;
	Date d;
	
	@Before
	public void setUp() throws MalformedURLException {
		s = new UrlSubject(new URL("http://www.pja.edu.pl/"));
		d = new Date(1544704842000L);
		o = new UrlObserver(s);
		s.setState(d);
	}
	
	@Test
	public void testAddGetState() {
		assertEquals(d, s.getState());
	}
	
	@Test
	public void testAttachUpdate() {
		Observer o2 = new UrlObserver(s);
		s.attach(o2);
		assertEquals("Changed http://www.pja.edu.pl/ Last modification: "+d.toString(),
				o.update());
	}
	
	@Test
	public void testDetach() {
		s.detach(o);
		s.notifyObservers();
		
		// nothing should be printed
	}
	
	@Test 
	public void testMemento() {
		Memento mem = s.createMemento();
		Date d2 = new Date(1544704844000L);
		s.setState(d2);
		assertEquals(d2, s.getState());
		s.setMemento(mem);
		assertEquals(d, s.getState());
	}
}

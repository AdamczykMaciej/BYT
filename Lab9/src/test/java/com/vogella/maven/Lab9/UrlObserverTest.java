package com.vogella.maven.Lab9;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.vogella.maven.Lab9.observer.Observer;
import com.vogella.maven.Lab9.observer.UrlObserver;
import com.vogella.maven.Lab9.observer.UrlSubject;

public class UrlObserverTest {
	Observer o;
	UrlSubject s;
	Date d;
	
	@Before
	public void setUp() throws MalformedURLException {
		s = new UrlSubject(new URL("http://www.pja.edu.pl/"));
		d = new Date(1544704842000L);
		o = new UrlObserver(s);
	}
	
	@Test
	public void testUpdate() {
		s.setState(d);
		assertEquals("Changed http://www.pja.edu.pl/ Last modification: "+d.toString(),
				o.update());
	}

}

package com.vogella.maven.Lab9;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import org.junit.Test;
import org.mockito.Mockito;

import com.vogella.maven.Lab9.memento.Caretaker;
import com.vogella.maven.Lab9.memento.Memento;
import com.vogella.maven.Lab9.observer.Observer;
import com.vogella.maven.Lab9.observer.UrlObserver;
import com.vogella.maven.Lab9.observer.UrlSubject;

public class AppTest  {

    @Test
    public void testMonitorWebPage() throws IOException  {
    //  create mock
        URLConnection connect1 = Mockito.mock(URLConnection.class);
        URLConnection connect2 = Mockito.mock(URLConnection.class);
        
        // define return value for method getUniqueId()
        Mockito.when(connect1.getLastModified()).thenReturn(1544704842000L);
        Mockito.when(connect2.getLastModified()).thenReturn(1544704844000L);
        
        UrlSubject subject1 = new UrlSubject( new URL("http://www.pja.edu.pl/"));
		Observer o1 = new UrlObserver(subject1);
		Observer o2 = new UrlObserver(subject1);

		long longtime;
		long prevLongTime = 0;
		String response = "NOT CHANGED";
		Caretaker c = new Caretaker("D:\\PJATK_Informatyka\\3_rok\\BYT\\LAB9\\states.txt");
		
		longtime = connect1.getLastModified();
		
		response = checkIfModified(longtime, prevLongTime, subject1, c);
		
		assertEquals(0,prevLongTime);
		prevLongTime = longtime;
		assertEquals("ENTERED",response);
		
		longtime = connect1.getLastModified();
		response = checkIfModified(longtime, prevLongTime, subject1, c);
		assertEquals("NOT ENTERED",response);
    }

	private String checkIfModified(long longtime, long prevLongTime, UrlSubject subject, Caretaker c) throws IOException {
		String response;
		if(longtime>prevLongTime) {
			response = "ENTERED";
			subject.setState(new Date(longtime));;
			Memento mem = subject.createMemento();
			c.addMemento(mem);
			subject.notifyObservers();
		}
		else {
			response = "NOT ENTERED";
		}
		return response;
	}
}
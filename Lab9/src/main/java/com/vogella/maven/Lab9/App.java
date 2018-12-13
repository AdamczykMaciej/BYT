package com.vogella.maven.Lab9;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.Date;

import com.vogella.maven.Lab9.memento.Caretaker;
import com.vogella.maven.Lab9.memento.Memento;
import com.vogella.maven.Lab9.observer.Observer;
import com.vogella.maven.Lab9.observer.UrlObserver;
import com.vogella.maven.Lab9.observer.UrlSubject;

public class App {
	
	public static void monitorWebPage(UrlSubject subject) throws IOException, ParseException {

		long longtime;
		URLConnection connect;
		long prevLongTime = 0;
		Caretaker c = new Caretaker("D:\\PJATK_Informatyka\\3_rok\\BYT\\LAB9\\states.txt");
		
		while(true) {
			connect = subject.getUrl().openConnection();
			longtime = connect.getLastModified();
			
			if(longtime>prevLongTime) {
				subject.setState(new Date(longtime));;
				Memento mem = subject.createMemento();
				c.addMemento(mem);
				subject.notifyObservers();
			}
			prevLongTime = longtime;
		}
	}
	
	public static void main(String[] args) throws IOException, ParseException {
		UrlSubject subject1 = new UrlSubject( new URL("http://www.pja.edu.pl/"));
		UrlSubject subject2 = new UrlSubject( new URL("https://www.wp.pl/"));
		Observer o1 = new UrlObserver(subject1);
		Observer o2 = new UrlObserver(subject1);
		Observer o3 = new UrlObserver(subject1);
		Observer o4 = new UrlObserver(subject2);
		
		monitorWebPage(subject1);
	}
}

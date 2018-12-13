package com.vogella.maven.Lab9.observer;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vogella.maven.Lab9.memento.Memento;

public class UrlSubject implements Subject {
	private Date state;
	private List<Observer> observers;
	private URL url;
	
	public UrlSubject(URL url) {
		observers = new ArrayList<>();
		this.url = url;
	}
	
	public URL getUrl() {
		return url;
	}
	
	@Override
	public Date getState() {
		return state;
	}
	
	@Override
	public void attach(Observer o) {
		if(!observers.contains(o))
			observers.add(o);
	}
	
	@Override
	public void detach(Observer o) {
		observers.remove(o);
	}
	
	@Override
	public void notifyObservers() {
		for(Observer o : observers ) {
			o.update();
		}
	}

	@Override
	public void setState(Date date) {
		state = date;
	}
	
	public void setMemento(Memento m) {
		state = m.GetState();
	}
	
	public Memento createMemento() {
		return new Memento(state);
	}
}

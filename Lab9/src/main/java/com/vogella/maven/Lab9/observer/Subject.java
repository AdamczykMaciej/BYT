package com.vogella.maven.Lab9.observer;

import java.util.Date;

public interface Subject {
	
	public void attach(Observer o);
	
	public void detach(Observer o);
	
	public void notifyObservers();
	
	public Date getState();
	
	public void setState(Date state);
}

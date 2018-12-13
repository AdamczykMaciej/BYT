package com.vogella.maven.Lab9.observer;

public class UrlObserver implements Observer {
	private String observerState;
	private UrlSubject subject;
	
	public UrlObserver(UrlSubject s) {
		subject = s;
		subject.attach(this);
	}
	public String update() {
		observerState = "Changed "+subject.getUrl()+ " Last modification: "+subject.getState().toString();
		System.out.println(observerState);
		return observerState;
	}
}

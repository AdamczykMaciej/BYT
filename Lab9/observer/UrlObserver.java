package com.vogella.maven.Lab9.observer;

public class UrlObserver implements Observer {
	//private String observerState;
	private UrlSubject subject;
	
	public UrlObserver(UrlSubject s) {
		subject = s;
		subject.attach(this);
	}
	public void update() {
		//observerState = subject.getState();
		System.out.println("Changed "+subject.getUrl()+ " Last modification: "+subject.getState().toString());
	}
}

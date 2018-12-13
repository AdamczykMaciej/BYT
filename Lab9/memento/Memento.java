package com.vogella.maven.Lab9.memento;

import java.util.Date;

public class Memento {
private Date state;
	
	public Memento(Date state) {
		this.state = state;
	}
	public Date GetState() {
		return state;
	}
	
	public void SetState(Date state) {
		this.state = state;
	}
}

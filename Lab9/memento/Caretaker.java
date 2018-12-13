package com.vogella.maven.Lab9.memento;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Caretaker {
private ArrayList<Memento> m = new ArrayList<>();
	
	public void addMemento(Memento mem) throws IOException {
		m.add(mem);
		BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\PJATK_Informatyka\\3_rok\\BYT\\quickstart\\src\\main\\java\\states.txt"));
	    writer.write(mem.GetState().toString());
	     
	    writer.close();
	}
	
	public Memento getMemento() {
		return m.get(0);
	}
}

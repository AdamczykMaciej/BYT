package com.vogella.maven.Lab9.memento;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Caretaker {
private String filename;
	
	public Caretaker(String filename) throws IOException{
		this.filename = filename;
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
	}
	public void addMemento(Memento mem) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(this.filename, true));
	    writer.write(mem.GetState().toString());
	    writer.newLine();
	     
	    writer.close();
	}
	
	public Memento getMemento(int n) throws IOException, ParseException {
		String line = Files.readAllLines(Paths.get(this.filename)).get(n);
		DateFormat format = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.ENGLISH);
		Date date = format.parse(line);
		Memento mem = new Memento(date);
		return mem;
	}
}

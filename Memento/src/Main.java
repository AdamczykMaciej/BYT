import java.util.ArrayList;
import java.util.List;

class Memento{
	private String state;
	
	public Memento(String state) {
		this.state = state;
	}
	public String GetState() {
		return state;
	}
	
	public void SetState(String state) {
		this.state = state;
	}
}

class Originator{
	private String state;
	
	public Originator(String state) {
		this.state = state;
	}
	
	public void SetState(String state) {
		this.state = state;
	}
	public void SetMemento(Memento m) {
		state = m.GetState();
	}
	
	public Memento CreateMemento() {
		return new Memento(state);
	}
}

class Caretaker {
	private ArrayList<Memento> m = new ArrayList<>();
	
	public void addMemento(Memento mem) {
		m.add(mem);
	}
	
	public Memento getMemento() {
		return m.get(0);
	}
	
}
public class Main {
	public static void main(String[] args) {
		
		Originator o = new Originator("active");
		Memento m = o.CreateMemento();
		System.out.println(m.GetState());
		Caretaker c = new Caretaker(); // for keeping track of mementos :)
		c.addMemento(m);
		
		// originator changed its state
		o.SetState("passive");
		// I changed my state and no one knows what it is :). Unless I create an instance of Memento.
		
		m = o.CreateMemento();
		System.out.println(m.GetState());
		// What was my previous state?
		
		System.out.println(c.getMemento().GetState());
		
		// Let's set our state to the previous state
		
		o.SetMemento(c.getMemento());
		// good, I changed my state and no one knows what it is. They can't access it. Only I can.
		// There isn't any method for accessing it :).
		
	}
}

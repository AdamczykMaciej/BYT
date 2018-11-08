// CHAIN OF RESPONSIBILITY PATTERN

/***
 * 
 * @author Maciej Adamczyk, s15170
 *
 */

class Request{
	protected double a;
	protected double b;
	protected double result;
	
	public Request(double a, double b) {
		this.a = a;
		this.b = b;
		result = 0;
	}
}

class Addition extends Request{
	public Addition(double a, double b) {
		super(a,b);
		this.result = this.a+this.b;
	}
}

class Multiplication extends Request{
	public Multiplication(double a, double b) {
		super(a,b);
		this.result = this.a*this.b;
	}
}

class Subtraction extends Request{
	public Subtraction(double a, double b) {
		super(a,b);
		this.result = this.a-this.b;
	}
}

class Division extends Request{
	public Division(double a, double b) {
		super(a,b);
		this.result = this.a/this.b;
	}
}
class Client{
	private Request request; 
	public void makeRequest(Request request) {
		this.request = request;
	};
	
	public Request getRequest() {
		return request;
	}
}

interface Handler{
	public void setNextHandler(Handler handler);
	public void handleRequest(Request request);
}

class AdditionHandler implements Handler{
	
	private Handler handler;
	
	@Override
	public void handleRequest(Request request) {
		System.out.println(this.getClass().getName()+": trying to handle the request...");
		if(request.getClass()==Addition.class) {
			add(request);
		}
		else {
			handler.handleRequest(request);
		}
	}
	
	@Override
	public void setNextHandler(Handler handler) {
		this.handler = handler;
	}
	
	public void add(Request request) {
		double result = request.a+request.b;
		System.out.println(this.getClass().getName()+" Result: "+result);
	}


}

class SubtractionHandler implements Handler{
	
	private Handler handler;
	
	@Override
	public void handleRequest(Request request) {
		System.out.println(this.getClass().getName()+": trying to handle the request...");
		if(request.getClass()==Subtraction.class) {
			subtract(request);
		}
		else {
			handler.handleRequest(request);
		}
	}
	
	@Override
	public void setNextHandler(Handler handler) {
		this.handler = handler;
	}
	
	public void subtract(Request request) {
		double result = request.a-request.b;
		System.out.println(this.getClass().getName()+" Result: "+result);
	}
	
	
}

class DivisionHandler implements Handler{
	
	private Handler handler;
	
	@Override
	public void handleRequest(Request request) {
		System.out.println(this.getClass().getName()+": trying to handle the request...");
		if(request.getClass()==Division.class) {
			divide(request);
		}
		else {
			handler.handleRequest(request);
		}
	}
	
	@Override
	public void setNextHandler(Handler handler) {
		this.handler = handler;
	}
	
	public void divide(Request request) {
		double result = request.a/request.b;
		System.out.println(this.getClass().getName()+" Result: "+result);
	}
	
}

class MultiplicationHandler implements Handler{
	
	private Handler handler;
	
	@Override
	public void handleRequest(Request request) {
		System.out.println(this.getClass().getName()+": trying to handle the request...");
		if(request.getClass()==Multiplication.class) {
			multiply(request);
		}
		else {
			handler.handleRequest(request);
		}
	}
	
	@Override
	public void setNextHandler(Handler handler) {
		this.handler = handler;
	}
	
	public void multiply(Request request) {
		double result = request.a*request.b;
		System.out.println(this.getClass().getName()+" Result: "+result);
	}
}

public class CalculateChain {
	
	private Handler h1; // the first handler
	
	public CalculateChain(Request request) {
		h1 = new AdditionHandler();
		Handler h2 = new SubtractionHandler();
		Handler h3 = new DivisionHandler();
		Handler h4 = new MultiplicationHandler();
		h1.setNextHandler(h2);
		h2.setNextHandler(h3);
		h3.setNextHandler(h4);
	}
	
	public static void main(String[] args) {
		
		int a = 2, b = 3;
		Request addRequest = new Addition(a,b);
		Request subtractRequest = new Subtraction(a,b);
		Request multRequest = new Multiplication(a,b);
		Request divRequest = new Division(a,b);
		
		Client client = new Client();
		client.makeRequest(addRequest);
		
		CalculateChain cc = new CalculateChain(client.getRequest());
		cc.h1.handleRequest(client.getRequest());  // of course we can give directly requests to the method,
		// but I wanted to have a class called Client as well, so as to have the structure similar to Class Diagram
		// of Chain of Responsibility
		client.makeRequest(subtractRequest);
		cc.h1.handleRequest(client.getRequest());
		client.makeRequest(multRequest);
		cc.h1.handleRequest(client.getRequest());
		client.makeRequest(divRequest);
		cc.h1.handleRequest(client.getRequest());
	}
}

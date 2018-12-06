// "Switch statement" Bad smell. I used State/ Strategy Design Pattern to "solve it".I think that in case it is "overkill",
// because we don't have many cases, classes where this switch is used. Yet, I wanted to practice and decided to implement State/Strategy.
// I created 2 solutions to this problem for practice. In the 2nd solution I used Replace Parameter with Explicit Method.
public class Expression {
	
	private char op;
	
	private Expression left;

	private Expression right;

	private int constant;

	private State state;

	public Expression(int constant) {
		this.state = new Constant();
		this.op = 'c'; 
		this.constant = constant;
	}
	
	public Expression(char op, Expression left, Expression right) {
		this.op = op;
		this.left = left;
		this.right = right;
	}

	public Expression(State state, Expression left, Expression right) {
		this.state = state;
		this.left = left;
		this.right = right;
	}

//	public int evaluate() {
//		
//		/* Replace Parameter with Explicit Method SOLUTION */
//		
//		switch (op) {
//		case 'c':
//			return constant;
//		case '+':
//			return add();
//		case '-':
//			return subtract();
//		case '*':
//			return multiply();
//		case '/':
//			return divide();
//		default:
//			throw new IllegalStateException();
//		}
//	}

	public int evaluate() {
		
		/* 
		 * STATE/STRATEGY PATTERN SOLUTION
		 * 
		 * return state.handle(this);
		 * 
		*/
		return state.handle(this);
	}

	// methods for Replace Parameter with Explicit Method SOLUTION
	public int add() {
		return left.evaluate() + right.evaluate();
	}

	public int subtract() {
		return left.evaluate() - right.evaluate();
	}

	public int multiply() {
		return left.evaluate() * right.evaluate();
	}

	public int divide() {
		return left.evaluate() / right.evaluate();
	}
	
	// methods for STATE/STRATEGY PATTERN SOLUTION 
	public Expression getLeft() {
		return left;
	}

	public Expression getRight() {
		return right;
	}

	public int getConstant() {
		return constant;
	}
}

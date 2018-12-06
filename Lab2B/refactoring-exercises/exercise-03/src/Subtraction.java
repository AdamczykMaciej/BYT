
public class Subtraction implements State{

	@Override
	public int handle(Expression e) {
		// TODO Auto-generated method stub
		return e.getLeft().evaluate() - e.getRight().evaluate();
	}
	

}

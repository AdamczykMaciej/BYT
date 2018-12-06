
public class Constant implements State{

	@Override
	public int handle(Expression e) {
		// TODO Auto-generated method stub
		return e.getConstant();
	}

}

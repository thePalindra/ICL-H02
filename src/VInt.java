
public class VInt implements IValue {
	
	int v;

	public VInt(int n) {
		v = n;
	}
	
	
	public int	getval(){	
	    return	v;
	}
	
	public void setVal(int x) {
		v = x;
	}

	
	
	public String toString() {
		return Integer.toString(v);
	}


	@Override
	public IValue eval(Environment e) {
		// TODO Auto-generated method stub
		return null;
	}
}

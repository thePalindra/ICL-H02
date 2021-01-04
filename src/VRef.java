
public class VRef implements IValue{
private int ref;

	public VRef(int ref) {
		this.ref=ref;
	}
	@Override
	public IValue eval(Environment e) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int getRef() {
		return ref;
	}
}


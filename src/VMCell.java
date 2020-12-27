
public class VMCell implements IValue {

	IValue v;
	public VMCell(IValue v0) {
		v = v0;
	}
	
	
	@Override
	public IValue eval(Environment e) {
		// TODO Auto-generated method stub
		return null;
	}
	
	void set(IValue	v0)	{
		v = v0;
	}

}

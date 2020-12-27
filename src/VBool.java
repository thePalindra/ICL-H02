
public class VBool implements IValue {
	boolean bool;
	
	public VBool(boolean t) {
		this.bool = t;
	}
	
	public boolean getBool() {
		return bool;
	}
	
	public IValue eval(Environment e) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

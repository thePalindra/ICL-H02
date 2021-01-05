
public class VMCell implements IValue{
private int ref;

	public VMCell(int ref) {
		this.ref=ref;
	}
	
	public int getRef() {
		return ref;
	}
}


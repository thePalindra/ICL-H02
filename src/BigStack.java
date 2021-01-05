
public class BigStack {
	
	int maxSize;
	int counter;
	IValue[] iv;
	
	public BigStack() {
		this.counter = 0;
		this.maxSize = 10;
		this.iv = new IValue[maxSize];
	}
	
	public IValue inc (IValue iv) {
		if (counter < maxSize ) {
			this.resize();
		}
		this.iv[counter++] = iv;
		return iv;
	}
	
	public void change (int i, IValue iv) {
		if (i < 0 || i >= counter)
			return;
		this.iv [i] = iv;
	}
	
	public IValue getMemoryPos(IValue i) {
		if(i instanceof VRef) {
			return iv[((VRef) i).getRef()];
		}else {
			//return error typeChecking
			return null;
		}
	}

	private void resize() {
		IValue[] temp = new IValue[this.maxSize*2];
		for (int i = 0; i < this.maxSize; i++) {
			temp[i] = this.iv[i];
		}
		this.iv = temp;
		this.maxSize = 2*this.maxSize;
	}
}

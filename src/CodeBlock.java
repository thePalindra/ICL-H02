import java.nio.charset.StandardCharsets;

public class CodeBlock {
	
	private static final int SIZE = 1000;
	String code[];
	int pos;
	
	public CodeBlock() {
		this.code = new String[SIZE];
		this.pos = 0;
	}

	void emit(String bytecode) {
		if (pos >= code.length)
			this.resize();
		this.code[this.pos++] = bytecode;
	}
	
	void resize () {
		String temp[] = new String[this.code.length*2];
		for (int i = 0; i < this.code.length; i++) {
			temp[i] = this.code [i];
		}
		this.code = temp;
	}
}

public class ASTNum implements ASTNode {

	int val;

	public int eval(Environment env) { 
		return val; 
	}

	public ASTNum(int n) {
		this.val = n;
	}

	@Override
	public void compile(CodeBlock c, Environment e) {
		c.emit("sipush " + val);
	}

}


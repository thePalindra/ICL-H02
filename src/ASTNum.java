public class ASTNum implements ASTNode {

	VInt val;

	public IValue eval(Environment env,BigStack b) { 
		return val ; 
	}

	public ASTNum(int n) {
		this.val = new VInt(n);
	}

	@Override
	public void compile(CodeBlock c, Environment e) {
		c.emit("sipush " + val.getval());
	}

}


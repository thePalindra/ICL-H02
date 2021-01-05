import java.io.IOException;

public class ASTUMinus implements ASTNode {

	ASTNode lhs;

	public IValue eval(Environment env,BigStack b) throws UndeclaredIdentifier, IOException { 
		VInt v1 = (VInt) this.lhs.eval(env,b);
		v1.setVal(-v1.getval()); 
		return v1;
	} //maybe not this way

	public ASTUMinus(ASTNode l) {
		this.lhs = l;
	}

	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		//c.emit("sipush " + eval(e));
		
	}
}

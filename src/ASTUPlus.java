import java.io.IOException;

public class ASTUPlus implements ASTNode {

	ASTNode lhs;

	public IValue eval(Environment env,BigStack b) throws UndeclaredIdentifier, IOException,TypeErrorException { 
		VInt v1 = (VInt) this.lhs.eval(env,b);
		v1.setVal(v1.getval()); 
		return v1;
	}

	public ASTUPlus(ASTNode l) {
		this.lhs = l;
	}

	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		//c.emit("sipush " + eval(e));
		
	}
	
	
}

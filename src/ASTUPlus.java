import java.io.IOException;

public class ASTUPlus implements ASTNode {

	ASTNode lhs;

	public int eval(Environment env) throws UndeclaredIdentifier, IOException { 
		int v1 = this.lhs.eval(env);
		return v1; 
	}

	public ASTUPlus(ASTNode l) {
		this.lhs = l;
	}

	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		c.emit("sipush " + eval(e));
		
	}
	
	
}

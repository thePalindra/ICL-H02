import java.io.IOException;

public class ASTDiv implements ASTNode {

	ASTNode lhs, rhs;

	public int eval(Environment env) throws UndeclaredIdentifier, IOException { 
		int v1 = this.lhs.eval(env);
		int v2 = this.rhs.eval(env);
		return v1/v2; 
	}

	public ASTDiv(ASTNode l, ASTNode r) {
		this.lhs = l; 
		this.rhs = r;
	}

	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		this.lhs.compile(c, e);
		this.rhs.compile(c, e);
		c.emit("idiv");
		
	}
}

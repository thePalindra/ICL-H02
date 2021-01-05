import java.io.IOException;

public class ASTNew implements ASTNode {
	ASTNode exp;
	@Override
	public IValue eval(Environment env,BigStack b) throws UndeclaredIdentifier, IOException {
		
		return b.inc(exp.eval(env, b));
	}
	
	public ASTNew(ASTNode exp) {
		this.exp = exp;	
	}

	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		// TODO Auto-generated method stub
		
	}

}

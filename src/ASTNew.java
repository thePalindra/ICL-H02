import java.io.IOException;

public class ASTNew implements ASTNode {
	ASTNode exp;
	@Override
	public IValue eval(Environment env) throws UndeclaredIdentifier, IOException {
		
		//VMCell ref = env.declareNew(exp.eval())
		
		//return ref;
		
		return null;
	}
	
	public ASTNew(ASTNode exp) {
		this.exp = exp;
	}

	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		// TODO Auto-generated method stub
		
	}

}

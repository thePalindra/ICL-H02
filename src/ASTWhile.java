import java.io.IOException;

public class ASTWhile implements ASTNode {
	
	private ASTNode condition;
	private ASTNode operation;
	
	public ASTWhile (ASTNode condition, ASTNode operation) {
		
	}

	@Override
	public IValue eval(Environment env) throws UndeclaredIdentifier, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		// TODO Auto-generated method stub

	}

}

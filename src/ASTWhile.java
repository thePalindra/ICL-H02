import java.io.IOException;

public class ASTWhile implements ASTNode {
	
	private ASTNode condition;
	private ASTNode operation;
	
	public ASTWhile (ASTNode condition, ASTNode operation) {
		this.condition=condition;
		this.operation=operation;
	}

	@Override
	public IValue eval(Environment env,BigStack b) throws UndeclaredIdentifier, IOException {
		IValue test;
		do {
			test = operation.eval(env,b);
		}while(((VBool) condition.eval(env,b)).getBool());
		return test;
	}

	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		// TODO Auto-generated method stub

	}

}

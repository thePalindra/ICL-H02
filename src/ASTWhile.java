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
		//Probably will need many typeChecks
		do {
			operation.eval(env,b);
		}while(((VBool) condition.eval(env,b)).getBool());
		return null;
	}

	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		// TODO Auto-generated method stub

	}

}

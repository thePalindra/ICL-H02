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
		if(condition.eval(env,b) instanceof VBool){
			do {
				test = operation.eval(env,b);
			}while(((VBool) condition.eval(env,b)).getBool());
			return test;
		}else {
			System.out.println("while: condition is not a boolean");
			return null;
		}
	}

	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		// TODO Auto-generated method stub

	}

}

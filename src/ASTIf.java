import java.io.IOException;

public class ASTIf implements ASTNode {
	
	private ASTNode condition;
	private ASTNode thenOperation;
	private ASTNode elseOperation;
	
	public ASTIf (ASTNode condition, ASTNode thenOperation, ASTNode elseOperation) {
		this.condition = condition;
		this.thenOperation = thenOperation;
		this.elseOperation = elseOperation;
	}

	@Override
	public IValue eval(Environment env,BigStack b) throws UndeclaredIdentifier, IOException,TypeErrorException {
		if(condition.eval(env, b) instanceof VBool) {
			
			if(((VBool) condition.eval(env,b)).getBool()) {
				return thenOperation.eval(env,b);
			}else {
				if(elseOperation==null) {
					return null; //print error
				}else {
					return elseOperation.eval(env,b);
				}
				
			}
		}else {
			throw new TypeErrorException("condition: argument is not a boolean");
		}
	}


	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		// TODO Auto-generated method stub
		
	}

}

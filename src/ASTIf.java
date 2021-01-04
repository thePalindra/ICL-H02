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
	public IValue eval(Environment env) throws UndeclaredIdentifier, IOException {
		//Probably will need many typeChecks
		if(((VBool) condition.eval(env)).getBool()) {
			return thenOperation.eval(env);
		}else {
			if(elseOperation==null) {
				return null; //print error
			}else {
				return elseOperation.eval(env);
			}
			
		}
	}


	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		// TODO Auto-generated method stub
		
	}

}

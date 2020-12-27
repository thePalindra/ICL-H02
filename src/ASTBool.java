import java.io.IOException;

public class ASTBool implements ASTNode {
	IValue lhs,rhs;
	String symbol;
	@Override
	public IValue eval(Environment env) throws UndeclaredIdentifier, IOException {
		return null;
	}
	
	public ASTBool() {
		
	}

	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		// TODO Auto-generated method stub

	}

}

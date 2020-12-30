import java.io.IOException;

public class ASTPointer implements ASTNode {
	
	ASTNode t;
	
	public ASTPointer(ASTNode t) {
		this.t = t;
		// TODO Auto-generated constructor stub
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

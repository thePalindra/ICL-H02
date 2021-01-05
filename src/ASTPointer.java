import java.io.IOException;

public class ASTPointer implements ASTNode {
	
	ASTNode t;
	
	public ASTPointer(ASTNode t) {
		this.t = t;
		// TODO Auto-generated constructor stub
	}

	@Override
	public IValue eval(Environment env,BigStack b) throws UndeclaredIdentifier, IOException {
		return b.getMemoryPos(t.eval(env, b));
	}

	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		// TODO Auto-generated method stub

	}

}

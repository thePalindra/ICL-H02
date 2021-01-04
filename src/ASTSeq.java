import java.io.IOException;

public class ASTSeq implements ASTNode {
	
	ASTNode t1,t2;
	
	public ASTSeq(ASTNode t1, ASTNode t2) {
		this.t1 = t1;
		this.t2 = t2;
		
	}

	@Override
	public IValue eval(Environment env) throws UndeclaredIdentifier, IOException {
		t1.eval(env); // is this it?
		return t2.eval(env);
	}

	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		// TODO Auto-generated method stub

	}

}

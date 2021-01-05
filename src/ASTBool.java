import java.io.IOException;

public class ASTBool implements ASTNode {
	VBool exp;
	@Override
	public IValue eval(Environment env,BigStack b) throws UndeclaredIdentifier, IOException {
		return exp;
	}
	
	public ASTBool(boolean exp) {
		this.exp = new VBool(exp);
	}

	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		// TODO Auto-generated method stub

	}

}

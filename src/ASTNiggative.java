import java.io.IOException;

public class ASTNiggative implements ASTNode{
	ASTNode nig;
	
	public ASTNiggative(ASTNode gas) {
		this.nig = gas; 
	}
	@Override
	public IValue eval(Environment env, BigStack b) throws UndeclaredIdentifier, IOException {
		IValue	v1	=	nig.eval(env,b);	
		if	(v1	instanceof	VBool)	{	
			return v1;
		}
		return null;
	}

	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		// TODO Auto-generated method stub
		
	}

}

import java.io.IOException;

public class ASTAnd implements ASTNode {
	ASTNode lhs, rhs;
	
	public ASTAnd(ASTNode left, ASTNode right) {
		lhs = left;
		rhs = right;
	}
	@Override
	public IValue eval(Environment env,BigStack b) throws UndeclaredIdentifier, IOException {
		IValue	v1	=	lhs.eval(env,b);	
		if	(v1	instanceof	VBool)	{	
			IValue	v2	=	rhs.eval(env,b);	
					if	(v2	instanceof	VBool){	
						return	new	VBool(((VBool) v1).getBool() && ((VBool) v2).getBool());
					}	
		}
		//throw TypeError(“+:	argument	is	not	an	integer”);
		return null;
	}
	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		// TODO Auto-generated method stub
		
	}
}
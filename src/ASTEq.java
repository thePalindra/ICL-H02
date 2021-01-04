import java.io.IOException;

public class ASTEq implements ASTNode {
	ASTNode lhs, rhs;
	
	public ASTEq(ASTNode left, ASTNode right) {
		lhs = left;
		rhs = right;
	}
	@Override
	public IValue eval(Environment env) throws UndeclaredIdentifier, IOException {
		IValue	v1	=	lhs.eval(env);	
		if	(v1	instanceof	VInt)	{	
			IValue	v2	=	rhs.eval(env);	
					if	(v2	instanceof	VInt){	
						return	new	VBool(((VBool) v1).getBool() == ((VBool) v2).getBool());
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

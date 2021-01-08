import java.io.IOException;

public class ASTGreaterThan implements ASTNode {
	ASTNode lhs, rhs;
	
	public ASTGreaterThan(ASTNode left, ASTNode right) {
		lhs = left;
		rhs = right;
	}
	@Override
	public IValue eval(Environment env,BigStack b) throws UndeclaredIdentifier, IOException,TypeErrorException {
		IValue	v1	=	lhs.eval(env,b);	
		if	(v1	instanceof	VInt)	{	
			IValue	v2	=	rhs.eval(env,b);	
					if	(v2	instanceof	VInt){	
						return	new	VBool(((VInt) v1).getval() > ((VInt) v2).getval());
					}	
		}
		throw new TypeErrorException(">: argument is not an integer");
	}
	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		// TODO Auto-generated method stub
		
	}
}

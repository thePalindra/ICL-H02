import java.io.IOException;

public class ASTAssign implements ASTNode {
	ASTNode lhs,rhs;
	
	public ASTAssign(ASTNode left, ASTNode right) {
		lhs = left;
		rhs = right;
	}
	@Override
	public IValue eval(Environment env,BigStack b) throws UndeclaredIdentifier, IOException,TypeErrorException{
			IValue	v1	=	lhs.eval(env,b);	
			if	(v1	instanceof	VMCell)	{	
				IValue v2	=	rhs.eval(env,b);	
				b.change(((VMCell) v1).getRef(), v2);	
				return	v2;
			}		
			throw new TypeErrorException("assignment :=:lhs is not a VMCell");
	}

	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		// TODO Auto-generated method stub
		
	}

}

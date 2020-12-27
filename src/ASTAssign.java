import java.io.IOException;

public class ASTAssign implements ASTNode {
	ASTNode lhs,rhs;
	
	public ASTAssign(ASTNode left, ASTNode right) {
		lhs = left;
		rhs = right;
	}
	@Override
	public IValue eval(Environment env) throws UndeclaredIdentifier, IOException{
			IValue	v1	=	lhs.eval(env);	
			if	(v1	instanceof	VMCell)	{	
				IValue v2	=	rhs.eval(env);	
				((VMCell)v1).set(v2);		
				return	v2;	
			}	
			//throw	TypeError(“assignment	:=	:	lhs	is	not	a	reference”);	
			return null; /** CHANGE**/
	}

	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		// TODO Auto-generated method stub
		
	}

}

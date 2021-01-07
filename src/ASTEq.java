import java.io.IOException;

public class ASTEq implements ASTNode {
	ASTNode lhs, rhs;
	
	public ASTEq(ASTNode left, ASTNode right) {
		lhs = left;
		rhs = right;
	}
	@Override
	public IValue eval(Environment env,BigStack b) throws UndeclaredIdentifier, IOException {
		IValue	v1	=	lhs.eval(env,b);	
		if	(v1	instanceof	VBool)	{	
			IValue	v2	=	rhs.eval(env,b);	
					if	(v2	instanceof	VBool){	
						return	new	VBool(((VBool) v1).getBool() == ((VBool) v2).getBool());
					}	
		}else if(v1	instanceof	VInt)	{	
			IValue	v2	=	rhs.eval(env,b);	
					if	(v2	instanceof	VInt){	
						return	new	VBool(((VInt) v1).getval() == ((VInt) v2).getval());
					}	
		}else if(v1 instanceof VMCell ) {
			IValue	v2	=	rhs.eval(env,b);	
			if	(v2	instanceof	VMCell){	
				return	new	VBool(((VMCell) v1).getRef() == ((VMCell) v2).getRef());
			}	
		}
		System.out.println("==:	argument is	not	an integer, boolean or VMCell");
		return null;
	}

	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		// TODO Auto-generated method stub
		
	}

}

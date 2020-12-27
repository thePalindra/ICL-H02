import java.io.IOException;

public class ASTSub implements ASTNode {

	ASTNode lhs, rhs;

	public IValue eval(Environment env) throws UndeclaredIdentifier, IOException{	
		IValue	v1	=	lhs.eval(env);	
		if	(v1	instanceof	VInt)	{	
			IValue	v2	=	rhs.eval(env);	
					if	(v2	instanceof	VInt){	
						return	new	VInt(((VInt) v1).getval() - ((VInt) v2).getval());
					}	
		}
		//throw TypeError(�+:	argument	is	not	an	integer�);
		return null;
	}

	public ASTSub(ASTNode l, ASTNode r) {
		this.lhs = l; 
		this.rhs = r;
	}

	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		this.lhs.compile(c, e);
		this.rhs.compile(c, e);
		c.emit("isub");
		
	}
}

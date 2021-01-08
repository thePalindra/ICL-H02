import java.io.IOException;

public class ASTMult implements ASTNode {

	ASTNode lhs, rhs;

	public IValue eval(Environment env,BigStack b) throws UndeclaredIdentifier, IOException,TypeErrorException{	
		IValue	v1	=	lhs.eval(env,b);	
		if	(v1	instanceof	VInt)	{	
			IValue	v2	=	rhs.eval(env,b);	
					if	(v2	instanceof	VInt){	
						return	new	VInt(((VInt) v1).getval() * ((VInt) v2).getval());
					}	
		}
		throw new TypeErrorException("*: argument is not an integer");
	}

	public ASTMult(ASTNode l, ASTNode r) {
		this.lhs = l; 
		this.rhs = r;
	}

	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		this.lhs.compile(c, e);
		this.rhs.compile(c, e);
		c.emit("imul");
		
	}
}

import java.io.IOException;

public class ASTPrint implements ASTNode {
	private ASTNode expression;
	
	public ASTPrint(ASTNode expression){
		this.expression=expression;
	}

	@Override
	public IValue eval(Environment env,BigStack b) throws UndeclaredIdentifier, IOException {
		IValue balls = this.expression.eval(env, b);
		System.out.println(balls);
		return balls;
	} //this shit probably not needed

	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		// TODO Auto-generated method stub
		
	}

}

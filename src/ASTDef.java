import java.io.IOException;
import java.util.List;

public class ASTDef implements ASTNode{

	List<String> ids;
	List<ASTNode> inits;
	ASTNode body;
	
	public ASTDef (List<String> ids, List<ASTNode> inits, ASTNode body) throws IOException{
		this.body = body;
		this.ids = ids;
		this.inits = inits;

	}

	@Override
	public IValue eval(Environment env) throws UndeclaredIdentifier, IOException {
		env = env.beginEnviroment();
		for (int i = 0; i < this.ids.size(); i++) {
			String id = this.ids.get(i);
			ASTNode init = this.inits.get(i);
			IValue v1 = init.eval(env);
			env.assoc(id, v1);
		}
		IValue v2 = this.body.eval(env);

        env.endEnviroment();
        return v2;
	}

	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException {
		/*e = e.beginEnviroment();
		c.emit("new frame_" + e.id);
        c.emit("dup");
        c.emit("invokespecial frame_" + e.id + "/<init>()V");
        if (e.depth>0) {
        	c.emit("dup");
        	c.emit("aload_3");
        	c.emit("putfield frame_" + e.id + "/sl Lframe_"+ e.parent.id +";");
        }
        c.emit("dup");
        c.emit("astore_3");
        for (int i = 0; i < ids.size(); i++) {
        	c.emit("dup");
        	this.inits.get(i).compile(c, e);
        	String id = this.ids.get(i);
			ASTNode init = this.inits.get(i);
			int v1 = 2;
			e.assoc(id, v1);
        	c.emit("putfield frame_" + e.id + "/" + this.ids.get(i) + " I");
        }
        FileBuilder.writer(e);
        c.emit("pop");
        this.body.compile(c, e);
        if (e.depth>0) {
	        c.emit("aload_3");
	        c.emit("getfield frame_"+e.id+"/sl Lframe_"+e.parent.id+";");
	        c.emit("astore_3");
        }
        
        e.endEnviroment();
	*/
	}

}

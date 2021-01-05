
public class ASTId implements ASTNode{

	String id;

	public ASTId(String id) {
		this.id = id;
	}

	@Override
	public IValue eval(Environment env,BigStack b) throws UndeclaredIdentifier {
		return env.find(id);
	}

	@Override
	public void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier {
		c.emit("aload_3");
		if (e.current.containsKey(id)) {
			c.emit("getfield frame_"+e.id+"/"+id+" I");
			return;
		} else 
			while(e != null) {
				if (!e.current.containsKey(id)) {
					c.emit("getfield frame_"+e.id+"/sl Lframe_"+e.parent.id+";");
				} else {
					c.emit("getfield frame_"+e.id+"/"+id+" I");
					return;
				}
				e = e.parent;
			}throw new UndeclaredIdentifier();
	}

}

import java.io.IOException;
import java.util.TreeMap;

public class Environment {

	public int depth;
	public int id;
	public int maxid;
	public Environment parent;
	private boolean envEnded=false;
	public TreeMap <String, Integer> current;

	
	public Environment () {
		this.maxid = -1;
		this.parent = null;
		this.id = -1;
		this.depth = -1;
		this.current = new TreeMap<String, Integer>();
	}
	
	public Environment (Environment e, int id, int depth) throws IOException {
		this.parent = e;
		this.id = id;
		this.maxid = id;
		this.depth = depth;
		this.current = new TreeMap<String, Integer>();
	}

	public void assoc (String id, int val) {
		this.current.put(id, val);
	}

	public Environment beginEnviroment () throws IOException {
		
		this.maxid ++;
		Environment temp = this;
		while(temp.parent != null && !envEnded) {
			temp.maxid = this.maxid;
			temp = temp.parent;
		}
		temp.maxid = this.maxid;
		return new Environment(this,this.maxid, this.depth+1);
	}

	public Environment endEnviroment () {
		envEnded=true;
		return this.parent;
	}
	
	public int find (String id) throws UndeclaredIdentifier {
		if (this.current.containsKey(id))
			return this.current.get(id);
		Environment temp = parent;
		while (temp != null) {
			TreeMap<String, Integer> aux = temp.current;
			if (aux.containsKey(id))
				return aux.get(id);
			temp = temp.parent;
		}
		throw new UndeclaredIdentifier();
	}
}

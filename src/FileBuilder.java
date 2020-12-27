import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Set;

public class FileBuilder {
	
	public static File file;
	public static String fileName;
	public static String code[];
	public static int pos;
	
	public FileBuilder(String name) {
		this.fileName = name;
		this.file = new File(fileName);	
	}
	
	static void emit(String bytecode) {
		if (pos >= code.length)
			resize();
		code[pos++] = bytecode;
	}
	
	 static void resize () {
		String temp[] = new String[code.length*2];
		for (int i = 0; i < code.length; i++) {
			temp[i] = code [i];
		}
		code = temp;
	}
	
	 static void writer(Environment e) throws IOException {
		
		FileWriter writer = new FileWriter("frame_" + e.id + ".j");
		Set<Entry<String,Integer>> vars = e.current.entrySet();
		String varString="";
		String trollStringV2 = "";
		if(e.id>0 ) 
			trollStringV2= "        .field public sl Lframe_" +e.parent.id +";\n";
		

		for(Entry<String,Integer> entry: vars) {
			varString += "        .field	public	" + entry.getKey() +" I\r\n";
		}
		writer.write(".class	public	frame_"+ e.id+"\r\n" + 
				"       .super	java/lang/Object\r\n" +
					varString +
					trollStringV2
					+
				"		.method	public	<init>()V	\r\n" + 
				"		aload_0	\r\n" + 
				"		invokenonvirtual	java/lang/Object/<init>()V	\r\n" + 
				"		return	\r\n" + 
				".end	method	");
		writer.close();
	}
	 
	static void writerTroll(String[] code) throws IOException {
		FileWriter writerV2 = new FileWriter("Main.j");
		String codeBlockString = "";
		
		for(int i=0; i<code.length&&code[i]!=null;i++) {
			System.out.println(code[i]);
			codeBlockString+="       "+code[i] +"\n";
		}
		writerV2.write(".class public Demo\r\n" + 
				".super java/lang/Object\r\n" + 
				"\r\n" + 
				";\r\n" + 
				"; standard initializer\r\n" + 
				".method public <init>()V\r\n" + 
				"   aload_0\r\n" + 
				"   invokenonvirtual java/lang/Object/<init>()V\r\n" + 
				"   return\r\n" + 
				".end method\r\n" + 
				"\r\n" + 
				".method public static main([Ljava/lang/String;)V\r\n" + 
				"       ; set limits used by this method\r\n" + 
				"       .limit locals  4\r\n" + 
				"       .limit stack 256\r\n" + 
				"\r\n" + 
				"       ; setup local variables:\r\n" + 
				"\r\n" + 
				"       ;    1 - the PrintStream object held in java.lang.System.out\r\n" + 
				"       getstatic java/lang/System/out Ljava/io/PrintStream;\r\n" + 
				"\r\n" + 
				"       ; place your bytecodes here\r\n" + 
				"       ; START\r\n" + 
				"\r\n" +
				codeBlockString +
				"       ; END\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"       ; convert to String;\r\n" + 
				"       invokestatic java/lang/String/valueOf(I)Ljava/lang/String;\r\n" + 
				"       ; call println \r\n" + 
				"       invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\r\n" + 
				"\r\n" + 
				"       return\r\n" + 
				"\r\n" + 
				".end method\r\n" + 
				"");
		
		writerV2.close();
	}
	

}

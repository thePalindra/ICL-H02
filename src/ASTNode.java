import java.io.IOException;

public interface ASTNode {

    IValue eval(Environment env) throws UndeclaredIdentifier, IOException;
    void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException;
    
    
}


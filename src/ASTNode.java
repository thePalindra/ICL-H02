import java.io.IOException;

public interface ASTNode {

    int eval(Environment env) throws UndeclaredIdentifier, IOException;
    void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException;
    
    
}


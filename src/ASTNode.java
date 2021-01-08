import java.io.IOException;

public interface ASTNode {

    IValue eval(Environment env,BigStack b) throws UndeclaredIdentifier, IOException,TypeErrorException;
    void compile(CodeBlock c, Environment e) throws UndeclaredIdentifier, IOException;
    
    
}


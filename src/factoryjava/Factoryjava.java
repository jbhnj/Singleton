package factoryjava;

import java.io.IOException;

import javax.swing.JFrame;

import factorycpp.Factorycpp;
import interfaces.IBuilder;
import interfaces.IFactory;

public class Factoryjava implements IFactory{

	private Factoryjava(){}
	private static Factoryjava instanceJava  = null;
    public static Factoryjava getInstance(){
        if (instanceJava == null){
            instanceJava = new Factoryjava();
        }
        return instanceJava;
    }
	
	@Override
	public JFrame SyntaxHG(String dir) throws IOException {
		// TODO Auto-generated method stub
		return new Syntaxjava(dir);
		
	}

	@Override
	public IBuilder Builder() {
		// TODO Auto-generated method stub
		return new BuilderJava();
	}

}

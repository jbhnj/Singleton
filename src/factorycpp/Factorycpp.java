package factorycpp;

import java.io.IOException;

import javax.swing.JFrame;

import interfaces.IBuilder;
import interfaces.IFactory;

public class Factorycpp implements IFactory{

	private Factorycpp(){}
	private static Factorycpp instanceCpp  = null;
    public static Factorycpp getInstance(){
        if (instanceCpp == null){
            instanceCpp = new Factorycpp();
        }
        return instanceCpp;
    }

	@Override
	public JFrame SyntaxHG(String dir) throws IOException {
		// TODO Auto-generated method stub
		return new Syntaxcpp(dir);
		
	}

	@Override
	public IBuilder Builder() {
		// TODO Auto-generated method stub
		return new Buildercpp();
	}

}


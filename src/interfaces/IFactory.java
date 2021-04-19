package interfaces;

import java.io.IOException;

import javax.swing.JFrame;

public interface IFactory {

	public JFrame SyntaxHG(String dir)throws IOException;
    	public IBuilder Builder();
}

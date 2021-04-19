package factorycpp;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

public class Syntaxcpp extends JFrame {

	public Syntaxcpp(String directory) throws IOException {
		
		JPanel jp = new JPanel(new BorderLayout());
	    	RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
	    	textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS);
        	textArea.setCodeFoldingEnabled(true);
        	RTextScrollPane sp = new RTextScrollPane(textArea);
        	jp.add(sp);
        	setContentPane(jp);
        	setTitle("CPP Editor");
        	setLocationRelativeTo(null);
        	pack();
        	setDefaultCloseOperation(EXIT_ON_CLOSE);
        	FileReader fr = new FileReader(directory);
        	BufferedReader br = new BufferedReader(fr);
        	textArea.read(br, null);
	}
}

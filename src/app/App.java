package app;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

import interfaces.IFactory;
import thread.ThreadA;
import uiFile.FileExplore;

import java.lang.reflect.Method;

public class App {

		public static void main(String []arg) throws IOException, InterruptedException, SecurityException, ReflectiveOperationException {
			
			menu();
			
		}
		
		public static void menu() throws IOException, InterruptedException, SecurityException, ReflectiveOperationException {
			int op;
				System.out.println("Fabrica");
				System.out.println("Pressione 1 para escolher um arquivo");
				System.out.println("Escolha 0 para sair: ");
			      	Scanner sc = new Scanner(System.in);
			      	op = sc.nextInt();
			   
			if (op == 1) {
			    	ThreadA pause = new ThreadA();
			    	FileExplore filefinder = new FileExplore(pause);
			    	synchronized (pause) {
			        	try{
			                	System.out.println("Aguardando definir opcao...");
			                	pause.wait();
			            	}catch(InterruptedException e){
			                	e.printStackTrace();
			            	}
			        }
			    	String directory = filefinder.getAbsoluteDir();
			    	prepareData(directory);
			}
			    			
		}
		
		public static void prepareData(String directory) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, InterruptedException, ReflectiveOperationException, SecurityException {
			
			boolean sucess = false;
			String extension = directory.split("\\.")[1];
			File currentDir = new File ("./src/plugins");
            		String[] pluginsF = currentDir.list();
            		URL[] jars = new URL [pluginsF.length];
            		for (int i = 0 ; i < pluginsF.length; i++) {
                		jars[i] = (new File("./src/plugins/" + pluginsF[i])).toURL();
            		}

            		URLClassLoader urlc = new URLClassLoader(jars);
            		for(int i = 0; i < pluginsF.length; i++) {
                		if (pluginsF[i].toLowerCase().contains(extension.toLowerCase())) {
                			String factoryName = pluginsF[i].split("\\.")[0];
                			Class metaClasse = Class.forName(factoryName.toLowerCase() + "." + factoryName, true, urlc);
                            Method instancedFactory = metaClasse.getDeclaredMethod("getInstance");
                            Object factory = (IFactory) instancedFactory.invoke(metaClasse);
                            createFactory ((IFactory) factory, directory);
                            sucess = true;
                		}
            		}
            		if (!sucess)
            			System.out.println("Não existe plugin que suporte este arquivo");
		}

		private static void createFactory(IFactory factory, String directory) throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			
			factory.Builder().compile(new File(directory));;
			factory.SyntaxHG(directory).setVisible(true);;
		}
}

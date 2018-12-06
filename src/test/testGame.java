package test;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

import controller.AdvancedController;
import controller.Controller;

import model.SimpleGame;

public class testGame {

	/**
	 * @param args
	 */
	public static String trimExtension(String st) {
		int index= st.indexOf(".");
		return st.substring(0,index);
		}
	public static void main(String[] args) {
		SimpleGame game=new SimpleGame(40);
		//Controller controller_game=new AdvancedController(game);
		// recuperer le nom des fichiers dans un menu
			File repertoire = new File("/home/nbedyouch/workspace/projetPacman/layout");
	        String liste[] = repertoire.list();
	        if (liste != null) {
	        	    String nom = (String)JOptionPane.showInputDialog(null, 
	        	      "veuillez indiquer le nom du lybirinthe !",
	        	      "menu",
	        	      JOptionPane.QUESTION_MESSAGE,
	        	      null,
	        	      liste,
	        	      removeExtension(liste[0]));
	        	    JOptionPane.showMessageDialog(null, "le nom du lybirinthe choisi est " + nom, "lybirinthe", JOptionPane.INFORMATION_MESSAGE);
	        	    System.out.println("repertoire non vide");
	        }else {
	        	System.err.println("Nom de repertoire invalide");
	        }
	}
	
	public static String removeExtension(String s) {

	    String separator = System.getProperty("file.separator");
	    String filename;

	    // Remove the path upto the filename.
	    int lastSeparatorIndex = s.lastIndexOf(separator);
	    if (lastSeparatorIndex == -1) {
	        filename = s;
	    } else {
	        filename = s.substring(lastSeparatorIndex + 1);
	    }

	    // Remove the extension.
	    int extensionIndex = filename.lastIndexOf(".");
	    if (extensionIndex == -1)
	        return filename;

	    return filename.substring(0, extensionIndex);
	}
}


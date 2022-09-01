package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student yo = new Student(124099,"Pires","Valentin","valentinpires_55@yahoo.com.ar","https://github.com/ValentinPires","src/images/yo.jpg");
            	SimplePresentationScreen gui = new SimplePresentationScreen(yo);
            	gui.setVisible(true);
            }
        });
    }
}
/**
  COMPILE AND RUN!
  javac *.java && java Stopwatch
 **/
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Stopwatch {
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Stopwatch (seconds only)");
		window.setSize(600,300);

		window.setContentPane(new Stopwatch_driver());
		window.setVisible(true);
	}
}

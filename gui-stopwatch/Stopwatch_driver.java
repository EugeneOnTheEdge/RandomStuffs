import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Stopwatch_driver extends JPanel {

	private final JLabel title;
	private final JButton btnStartStop;
	private final JButton btnReset;
	private final JLabel stopwatchLabel;
	private double stopwatchCounter;

	private final Timer stopwatchTicker;

	public Stopwatch_driver() {
		super.setLayout(new BorderLayout());

		// Initialize widgets
		this.btnStartStop = new JButton("START");
		this.btnReset = new JButton("RESET");
		this.title = new JLabel("STOPWATCH", SwingConstants.CENTER);
		this.stopwatchLabel = new JLabel("00.0 s", SwingConstants.CENTER);
		this.stopwatchCounter = 0.0;

		this.btnReset.setEnabled(false);

		this.btnStartStop.addActionListener((actionEvent) -> this.buttons_onClickListener(actionEvent));
		this.btnReset.addActionListener((actionEvent) -> this.buttons_onClickListener(actionEvent));
		
		this.stopwatchTicker = new Timer(100, (actionEvent) -> this.update(actionEvent));
		
		// Styling
		this.stopwatchLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 100));
		this.btnStartStop.setBackground(Color.GREEN);
		this.btnStartStop.setForeground(Color.BLACK);
		this.btnReset.setBackground(Color.GRAY);
		this.btnReset.setForeground(Color.WHITE);

		// Append widgets to layout
		super.add(this.btnReset, BorderLayout.WEST);
		super.add(this.stopwatchLabel, BorderLayout.CENTER);
		super.add(this.btnStartStop, BorderLayout.EAST);
	}

	private void buttons_onClickListener(ActionEvent ae) {
		if (ae.getActionCommand().equals("START")) {
			this.stopwatchTicker.start();
			this.btnReset.setEnabled(false);
			this.btnReset.setBackground(Color.GRAY);
			this.btnStartStop.setLabel("STOP");
			this.btnStartStop.setBackground(Color.RED);
		}
		else if (ae.getActionCommand().equals("STOP")) {
			this.stopwatchTicker.stop();
			this.btnReset.setEnabled(true);
			this.btnReset.setBackground(Color.BLUE);
			this.btnStartStop.setLabel("START");
			this.btnStartStop.setBackground(Color.GREEN);
		}
		else { // RESET
			this.stopwatchCounter = 0.0;
			stopwatchLabel.setText(String.format("%.1f", stopwatchCounter) + " s");
			this.btnReset.setEnabled(false);
			this.btnReset.setBackground(Color.GRAY);
		}
	}

	private void update(ActionEvent ae) {
		this.stopwatchCounter += 0.1;
		this.stopwatchLabel.setText(String.format("%.1f", stopwatchCounter) + " s");
	}
}
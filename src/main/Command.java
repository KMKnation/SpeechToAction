
package main;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.result.WordResult;
import global.Constants;
import global.Utility;

public class Command extends JFrame {

	private static JLabel label;
	
	public Command() {
		
		label = new JLabel("Commander loading dictionary...");
		// Finish the GUI and make visible
		getContentPane().add(label);
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(label);
		setTitle(Constants.PROJECT_TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 40);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		
		new Command();
		
		Configuration configuration = new Configuration();
		
		// Set path to acoustic model.
		configuration
		.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		// Set path to dictionary.
		configuration.setDictionaryPath("resource:/main/cmudict-en-us.dict");
		// configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
		// Set language model.
//		configuration.setLanguageModelPath("resource:/main/en-us.lm.bin");
		 configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
		
		configuration.setSampleRate(14000);
		
		LiveSpeechRecognizer recognizer;
		try {
			recognizer = new LiveSpeechRecognizer(configuration);
			// Start recognition process pruning previously cached data.
			recognizer.startRecognition(true);
			
			String message = "Say: ( up | down | right | left | close | youtube | google | click | double click)";
			Utility.log(message);
			label.setText(message);
			
			// loop the recognition until the program exits.
			
			while (true) {
				label.setText("Start speaking. Press close to quit.\n");
				
				SpeechResult result = recognizer.getResult();
				Result finalresult = result.getResult();
				
				if (finalresult != null) {
					String resultText = finalresult
							.getBestFinalResultNoFiller();
					
					if (!resultText.trim().isEmpty()) {
						label.setText("You said: " + resultText + '\n');
						Utility.log("You said: " + resultText + '\n');
						performAction(resultText);
					} else {
						label.setText("Emply Word: " + resultText + '\n');
						Utility.log("Emply Word: " + resultText + '\n');
					}
				} else {
					Utility.log("I can't hear what you said.\n");
					label.setText("I can't hear what you said.\n");
				}
				
				// Get individual words and their times.
				// }
				// for (WordResult r : result.getWords()) {
				// System.out.println("Word " +r.toString());
				
			}
			
			// SpeechResult result = recognizer.getResult();
			// // Pause recognition process. It can be resumed then with
			// startRecognition(false).
			// recognizer.stopRecognition();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// function to perform required operation
	private static void performAction(String action) {
		
		if (action.equalsIgnoreCase("up")) {
			Utility.moveUp(Constants.STEPS);
			return;
		}
		
		if (action.equalsIgnoreCase("down")) {
			Utility.moveDown(Constants.STEPS);
			return;
		}
		
		if (action.equalsIgnoreCase("left")) {
			Utility.moveLeft(Constants.STEPS);
			return;
		}
		
		if (action.equalsIgnoreCase("right")) {
			Utility.moveRight(Constants.STEPS);
			return;
		}
		
		if (action.equalsIgnoreCase("click")) {
			Utility.click();
			return;
		}
		
		if (action.equalsIgnoreCase("rightclick")) {
			Utility.rightClick();
			return;
		}
		
		if (action.equalsIgnoreCase("double")) {
			Utility.click();
			Utility.click();
			return;
		}
		
		if (action.contains("scroll")){
			Utility.scroll(Constants.STEPS);
			return;
		}
		
		Desktop desktop = Desktop.getDesktop();
		if (desktop.isDesktopSupported()) {
			
			// browsers related
			if (action.contains("google")) {
				try {
					desktop.browse(new URI("http://google.com"));
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				return;
			}
			
			if (action.contains("youtube")) {
				try {
					desktop.browse(new URI("https://www.youtube.com"));
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				return;
			}
			
		}
		
		if (action.contains("close")) {
			
			try {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_ALT);
				robot.keyPress(KeyEvent.VK_F4);
			} catch (Exception e) {
				e.printStackTrace();
				
				System.exit(-1);
			}
		}
		
	}
}
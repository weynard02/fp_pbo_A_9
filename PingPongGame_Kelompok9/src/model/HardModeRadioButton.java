package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.control.RadioButton;
import javafx.scene.text.Font;

public class HardModeRadioButton extends RadioButton {
	
	private final String FONT_PATH = "src/model/resources/kenvector_future_thin.ttf";
	private boolean isHard;
	public HardModeRadioButton(String text, boolean isHard) {
		super(text);
		this.isHard = isHard;
		setText(text);
		setButtonFont();
	}
	
	private void setButtonFont() {
		try {
	        setFont(Font.loadFont(new FileInputStream(FONT_PATH), 24));
	    } catch (FileNotFoundException e) {
	        setFont(Font.font("Verdana", 24));
	    }
	    
	}

	public boolean isHardMode() {
		return isHard;
	}
}

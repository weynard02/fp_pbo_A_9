package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.control.RadioButton;
import javafx.scene.text.Font;

public class ControllerRadioButton extends RadioButton {
	
	private final String FONT_PATH = "src/model/resources/kenvector_future_thin.ttf";
	private boolean isMouseChosen;
	
	public ControllerRadioButton (String text, boolean isMouseChosen) {
		super(text);
		this.isMouseChosen = isMouseChosen;
		setText(text);
		setButtonFont();
	}
	
	private void setButtonFont() {
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), 15));
		} catch (FileNotFoundException e) {
			setFont(Font.font("Century", 15));
		}		
	}

	public boolean isMouseChosen() {
		return isMouseChosen;
	}
	
	
}

package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Font;

public class PongRadioButton extends RadioButton {
	private final String FONT_PATH = "src/model/resources/kenvector_future_thin.ttf";
	public PongRadioButton (String text) {
		setText(text);
		setButtonFont();
	}
	
	private void setButtonFont() {
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), 22));
		} catch (FileNotFoundException e) {
			setFont(Font.font("Century", 22));
		}		
	}
}

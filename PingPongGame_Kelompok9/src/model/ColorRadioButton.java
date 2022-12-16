package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ColorRadioButton extends RadioButton {
	
	private final String FONT_PATH = "src/model/resources/kenvector_future_thin.ttf";
	private Color backgroundColor;
	private Color fontColor;
	
	public ColorRadioButton(String text, Color backgroundColor) {
		super(text);
		this.backgroundColor = backgroundColor;
		if(backgroundColor == Color.WHITE) fontColor = Color.BLACK;
		else fontColor = Color.WHITE;
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

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public Color getFontColor() {
		return fontColor;
	}
	
	
}
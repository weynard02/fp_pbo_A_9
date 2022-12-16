package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class TitleLabel extends Label {
	
	private final String FONT_PATH = "src/model/resources/kenvector_future_thin.ttf";
	
	public TitleLabel(String text) {
		setText(text);
		setLabelFont();
	}
	
	private void setLabelFont() {
		
		try {
			setFont(Font.loadFont(new FileInputStream(new File(FONT_PATH)), 30));
		} catch (FileNotFoundException e) {
			setFont(Font.font("Century", 15));
		}
		
	}
}

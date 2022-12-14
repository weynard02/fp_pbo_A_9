package model;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;

public class InfoLabel extends Label{
	
	public final static String FONT_PATH = "src/model/resources/ARLRDBD.TTF";
	
	public final static String BACKGROUND_IMAGE = "model/resources/grey_panel.png";
	
	
	public InfoLabel (String text) {
		
		setPrefWidth(400);
		setPrefHeight(500);
		setText(text);
		setWrapText(true);
		setLabelFont();
		setAlignment(Pos.CENTER);
	}
	
	private void setLabelFont() {
		
		try {
			setFont(Font.loadFont(new FileInputStream(new File(FONT_PATH)), 15));
		} catch (FileNotFoundException e) {
			setFont(Font.font("Century", 15));
		}
		
	}
}

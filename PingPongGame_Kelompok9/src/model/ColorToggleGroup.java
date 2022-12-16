package model;

import java.util.ArrayList;

import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class ColorToggleGroup {
	private ColorRadioButton rbBlack;
	private ColorRadioButton rbGreen;
	private ColorRadioButton rbRed;
	private ColorRadioButton rbBlue;
	private ColorRadioButton rbBrown;
	private ColorRadioButton rbDarkBlue;
	private ColorRadioButton rbDarkGreen;
	private ColorRadioButton rbNavy;
	private ColorRadioButton rbViolet;
	private ColorRadioButton rbTeal;
	private ColorRadioButton rbMaroon;
	private ColorRadioButton rbPink;
	private ColorRadioButton rbSalmon;
	private ColorRadioButton rbTomato;
	private ColorRadioButton rbOrange;
	private ColorRadioButton rbWhite;
	private ToggleGroup tgBackgroundColor;
	private ArrayList<ColorRadioButton> listBackgroundColor;
	
	
	public ColorToggleGroup(){
		rbBlack = new ColorRadioButton("BLACK", Color.BLACK);
		rbGreen = new ColorRadioButton("GREEN", Color.GREEN);
		rbRed = new ColorRadioButton("RED", Color.RED);
		rbBlue = new ColorRadioButton("BLUE", Color.BLUE);
		rbBrown = new ColorRadioButton("BROWN", Color.BROWN);
		rbDarkBlue = new ColorRadioButton("DARK BLUE", Color.DARKBLUE);
		rbDarkGreen = new ColorRadioButton("DARK GREEN", Color.DARKGREEN);
		rbNavy = new ColorRadioButton("NAVY", Color.NAVY);
		rbViolet = new ColorRadioButton("VIOLET", Color.VIOLET);
		rbTeal = new ColorRadioButton("TEAL", Color.TEAL);
		rbMaroon = new ColorRadioButton("MAROON", Color.MAROON);
		rbPink = new ColorRadioButton("PINK", Color.PINK);
		rbSalmon = new ColorRadioButton("SALMON", Color.SALMON);
		rbTomato = new ColorRadioButton("TOMATO", Color.TOMATO);
		rbOrange = new ColorRadioButton("ORANGE", Color.ORANGE);
		rbWhite = new ColorRadioButton("WHITE", Color.WHITE);
		tgBackgroundColor = new ToggleGroup();
		listBackgroundColor = new ArrayList<>();
		rbBlack.setToggleGroup(tgBackgroundColor);
		rbGreen.setToggleGroup(tgBackgroundColor);
		rbRed.setToggleGroup(tgBackgroundColor);
		rbBlue.setToggleGroup(tgBackgroundColor);
		rbBrown.setToggleGroup(tgBackgroundColor);
		rbDarkBlue.setToggleGroup(tgBackgroundColor);
		rbDarkGreen.setToggleGroup(tgBackgroundColor);
		rbNavy.setToggleGroup(tgBackgroundColor);
		rbViolet.setToggleGroup(tgBackgroundColor);
		rbTeal.setToggleGroup(tgBackgroundColor);
		rbMaroon.setToggleGroup(tgBackgroundColor);
		rbPink.setToggleGroup(tgBackgroundColor);
		rbSalmon.setToggleGroup(tgBackgroundColor);
		rbTomato.setToggleGroup(tgBackgroundColor);
		rbOrange.setToggleGroup(tgBackgroundColor);
		rbWhite.setToggleGroup(tgBackgroundColor);
		listBackgroundColor.add(rbBlack);
		listBackgroundColor.add(rbGreen);
		listBackgroundColor.add(rbRed);
		listBackgroundColor.add(rbBlue);
		listBackgroundColor.add(rbBrown);
		listBackgroundColor.add(rbDarkBlue);
		listBackgroundColor.add(rbDarkGreen);
		listBackgroundColor.add(rbNavy);
		listBackgroundColor.add(rbViolet);
		listBackgroundColor.add(rbTeal);
		listBackgroundColor.add(rbMaroon);
		listBackgroundColor.add(rbPink);
		listBackgroundColor.add(rbSalmon);
		listBackgroundColor.add(rbTomato);
		listBackgroundColor.add(rbOrange);
		listBackgroundColor.add(rbWhite);
	}
	
	public ArrayList<ColorRadioButton> getListBackgroundColor(){
		return listBackgroundColor;
	}
	

	public ToggleGroup getTgBackgroundColor() {
		return tgBackgroundColor;
	}	
	
}

package model;

import java.util.ArrayList;

import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class PongToggleGroup {
	private PongRadioButton rbBlack;
	private PongRadioButton rbGreen;
	private PongRadioButton rbRed;
	private PongRadioButton rbBlue;
	private PongRadioButton rbBrown;
	private PongRadioButton rbDarkBlue;
	private PongRadioButton rbDarkGreen;
	private PongRadioButton rbNavy;
	private PongRadioButton rbViolet;
	private PongRadioButton rbTeal;
	private PongRadioButton rbMaroon;
	private PongRadioButton rbPink;
	private PongRadioButton rbSalmon;
	private PongRadioButton rbTomato;
	private PongRadioButton rbOrange;
	private PongRadioButton rbWhite;
	private PongRadioButton rbKeyboard;
	private PongRadioButton rbMouse;
	private ToggleGroup tgBackgroundColor;
	private ToggleGroup tgController;
	private ArrayList<PongRadioButton> listBackgroundColor;
	private ArrayList<PongRadioButton> listController;
	
	public PongToggleGroup(){
		rbBlack = new PongRadioButton("BLACK");
		rbGreen = new PongRadioButton("GREEN");
		rbRed = new PongRadioButton("RED");
		rbBlue = new PongRadioButton("BLUE");
		rbBrown = new PongRadioButton("BROWN");
		rbDarkBlue = new PongRadioButton("DARK BLUE");
		rbDarkGreen = new PongRadioButton("DARK GREEN");
		rbNavy = new PongRadioButton("NAVY");
		rbViolet = new PongRadioButton("VIOLET");
		rbTeal = new PongRadioButton("TEAL");
		rbMaroon = new PongRadioButton("MAROON");
		rbPink = new PongRadioButton("PINK");
		rbSalmon = new PongRadioButton("SALMON");
		rbTomato = new PongRadioButton("TOMATO");
		rbOrange = new PongRadioButton("ORANGE");
		rbWhite = new PongRadioButton("WHITE");
		rbKeyboard = new PongRadioButton("KEYBOARD");
		rbMouse = new PongRadioButton("MOUSE");
		rbBlack.setSelected(true);
		rbKeyboard.setSelected(true);
		rbBlack.setUserData(Color.BLACK);
		rbGreen.setUserData(Color.GREEN);
		rbRed.setUserData(Color.RED);
		rbBlue.setUserData(Color.BLUE);
		rbBrown.setUserData(Color.BROWN);
		rbDarkBlue.setUserData(Color.DARKBLUE);
		rbDarkGreen.setUserData(Color.DARKGREEN);
		rbNavy.setUserData(Color.NAVY);
		rbViolet.setUserData(Color.VIOLET);
		rbTeal.setUserData(Color.TEAL);
		rbMaroon.setUserData(Color.MAROON);
		rbPink.setUserData(Color.PINK);
		rbSalmon.setUserData(Color.SALMON);
		rbTomato.setUserData(Color.TOMATO);
		rbOrange.setUserData(Color.ORANGE);
		rbWhite.setUserData(Color.WHITE);
		rbKeyboard.setUserData("Keyboard");
		rbMouse.setUserData("Mouse");
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
		rbKeyboard.setToggleGroup(tgController);
		rbMouse.setToggleGroup(tgController);
		listBackgroundColor = new ArrayList<>();
		listController = new ArrayList<>();
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
		listController.add(rbKeyboard);
		listController.add(rbMouse);		
	}
	
	public ArrayList<PongRadioButton> getListBackroundColor(){
		return listBackgroundColor;
	}
	
	public ArrayList<PongRadioButton> getListController(){
		return listController;
	}

	public ToggleGroup getTgBackgroundColor() {
		return tgBackgroundColor;
	}

	public ToggleGroup getTgController() {
		return tgController;
	}
	
	
}

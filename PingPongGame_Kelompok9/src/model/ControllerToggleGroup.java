package model;

import java.util.ArrayList;

import javafx.scene.control.ToggleGroup;

public class ControllerToggleGroup {
	
	private ControllerRadioButton rbKeyboard;
	private ControllerRadioButton rbMouse;
	private ToggleGroup tgController;
	private ArrayList<ControllerRadioButton> listController;
	
	public ControllerToggleGroup(){
		rbKeyboard = new ControllerRadioButton("KEYBOARD", false);
		rbMouse = new ControllerRadioButton("MOUSE", true);
		tgController = new ToggleGroup();
		listController = new ArrayList<>();
		rbKeyboard.setToggleGroup(tgController);
		rbMouse.setToggleGroup(tgController);
		listController.add(rbKeyboard);
		listController.add(rbMouse);
	}

	public ToggleGroup getTgController() {
		return tgController;
	}

	public ArrayList<ControllerRadioButton> getListController() {
		return listController;
	}
	
	
}

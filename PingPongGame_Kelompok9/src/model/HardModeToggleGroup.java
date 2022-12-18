package model;

import java.util.ArrayList;

import javafx.scene.control.ToggleGroup;

public class HardModeToggleGroup {
	
	private HardModeRadioButton rbNormal;
	private HardModeRadioButton rbHard;
	private ToggleGroup tgHardMode;
	private ArrayList <HardModeRadioButton> listMode;
	
	public HardModeToggleGroup() {
	 	rbNormal = new HardModeRadioButton("NORMAL", false);
	    rbHard = new HardModeRadioButton("HARD", true);
	    tgHardMode = new ToggleGroup();
	    listMode = new ArrayList<>();
	    rbNormal.setToggleGroup(tgHardMode);
	    rbHard.setToggleGroup(tgHardMode);
	    listMode.add(rbNormal);
	    listMode.add(rbHard);
	    rbNormal.setSelected(true);
	}
	public ToggleGroup getTgMode() {
   		return tgHardMode;
   	}
	
	public ArrayList<HardModeRadioButton> getListMode() {
		return listMode;
	}
}

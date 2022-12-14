package view;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;
import model.InfoLabel;
import model.PongButton;
import model.PongSubScene;

public class MenuView {
	private static final int HEIGHT = 600;
	private static final int WIDTH = 800;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	private PongSubScene creditsSubScene;
	
	List <PongButton> menuButtons;
	
	public MenuView() {
		menuButtons = new ArrayList<>();
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		createButtons();
		createBackground();
		createLogo();
		createSubScene();
	}
	
	private void createSubScene() {
		createCreditsSubScene();
	}
	
	private void createCreditsSubScene() {
		creditsSubScene = new PongSubScene();
		mainPane.getChildren().add(creditsSubScene);
		
		InfoLabel creditsLabel = new InfoLabel("Reference by gaspar coding\nMod by"
				+ "\n5025211014 - Alexander Weynard Samsico"
				+ "\n5025211016 - Thomas Juan Mahardika Suryono"
				+ "\n5025211103 - Muhammad Naufal Baihaqi\n");
		
		creditsLabel.setLayoutX(0);
		creditsLabel.setLayoutY(-80);
		creditsSubScene.getPane().getChildren().add(creditsLabel);
		creditsSubScene.getPane().getChildren().add(createToBackButton());
		
	}
	
	private void moveSubScene(PongSubScene subScene) {
		subScene.moveSubScene();
		
	}
	
	private void closeSubScene(PongSubScene subScene) {
		subScene.moveSubScene();
	}
	
	private void addMenuButton(PongButton button) {
		button.setLayoutX(300);
		button.setLayoutY(200 + menuButtons.size()*80);
		menuButtons.add(button);
		mainPane.getChildren().add(button);
	}
	
	private void createButtons() {
		createVSCPUButton();
		createVS2PButton();
		createCreditsButton();
		createToBackButton();
		createExitButton();
	}
	
	

	private PongButton createToBackButton() {
		PongButton backButton = new PongButton("Back");
		backButton.setLayoutX(100);
		backButton.setLayoutY(300);
		
		backButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				closeSubScene(creditsSubScene);
			}
			
		});
		return backButton;	
	}

	private void createVSCPUButton() {
		PongButton vsCPUButton = new PongButton("VS CPU");
		addMenuButton(vsCPUButton);
		
		vsCPUButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					GameView game = new GameView();
					game.start(mainStage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	
	private void createVS2PButton() {
		PongButton vs2PButton = new PongButton("VS 2P");
		addMenuButton(vs2PButton);
		
		vs2PButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					GameView game = new GameView();
					game.vs2pStart(mainStage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
	}

	private void createCreditsButton() {
		PongButton creditsButton = new PongButton("CREDITS");
		addMenuButton(creditsButton);
		
		creditsButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				moveSubScene(creditsSubScene);
			}
			
		});
		
	}
	
	private void createExitButton() {
		PongButton exitButton = new PongButton("EXIT");
		addMenuButton(exitButton);
		
		exitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				mainStage.close();
			}
		});
	}

	
	

	
	private void createBackground() {
		Image backgroundImage = new Image("model/resources/blackBackground.png", 256, 256, false, true);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}
	
	private void createLogo() {
		ImageView logo = new ImageView("\\model\\resources\\PONGLogo.png");
		logo.setLayoutX(230);
		logo.setLayoutY(60);
		mainPane.getChildren().add(logo);
	}

	public Stage getMainStage() {
		return mainStage;
	}
	
}

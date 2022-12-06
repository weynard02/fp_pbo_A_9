package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import view.GameView;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			GameView game = new GameView();
			game.start(primaryStage);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

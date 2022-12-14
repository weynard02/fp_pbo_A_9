package view;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.ControlChooser;

public class GameView extends Application {
	private static final int width = 800;
	private static final int height = 600;
	private static final int PLAYER_HEIGHT = 100;
	private static final int PLAYER_WIDTH = 15;
	private static final double BALL_R = 15;
	private int ballYSpeed = 1;
	private int ballXSpeed = 1;
	private double playerOneYPos = height / 2;
	private double playerTwoYPos = height / 2;
	private double ballXPos = width / 2;
	private double ballYPos = height / 2;
	private int scoreP1 = 0;
	private int scoreP2 = 0;
	private boolean gameStarted;
	private int playerOneXPos = 0;
	private double playerTwoXPos = width - PLAYER_WIDTH;
	private StackPane gamePane;
	private Scene gameScene;
	private Canvas canvas;
	
	private boolean isUpPressed;
	private boolean isDownPressed;
	private boolean isWPressed;
	private boolean isSPressed;
	
	ControlChooser mouse = new ControlChooser();
	
	@Override
	public void start(Stage gameStage) throws Exception {
		gameStage.setTitle("Ping Pong");
		canvas = new Canvas(width, height);
		initialize();
		gamePane = new StackPane(canvas);
		gameScene = new Scene(gamePane);
		gameStage.setScene(gameScene);
		gameStage.show();
	}
	
	public void vs2pStart(Stage gameStage) throws Exception {

		gameStage.setTitle("Ping Pong");
		canvas = new Canvas(width, height);
		vs2pInitialize();
		gamePane = new StackPane(canvas);
		gameScene = new Scene(gamePane);
		gameStage.setScene(gameScene);
		gameStage.show();
	}
	
	private void initialize(){
		//background size
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		//JavaFX Timeline = free form animation defined by KeyFrames and their duration 
		Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc)));
		//number of cycles in animation INDEFINITE = repeat indefinitely
		tl.setCycleCount(Timeline.INDEFINITE);
		
		
		if (mouse.isMouseChosen()) //now in false
			mouseControl();
		else
			keyboardControl();
		
		tl.play();
	}
	
	private void vs2pInitialize(){
		//background size
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		//JavaFX Timeline = free form animation defined by KeyFrames and their duration 
		Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> vs2pRun(gc)));
		//number of cycles in animation INDEFINITE = repeat indefinitely
		tl.setCycleCount(Timeline.INDEFINITE);
		vs2pKeyboardControl();
		tl.play();
	}
	
	private void keyboardControl() {
		
		//keyboard control
		canvas.setFocusTraversable(true);
		canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.UP) {
					isUpPressed = true;
					setYDirection();
				}
				else if (event.getCode() == KeyCode.DOWN) {
					isDownPressed = true;
					setYDirection();
				}
				else if (event.getCode() == KeyCode.ENTER) {
					gameStarted = true;
					playerOneYPos = height / 2;
				}
			}
			
		});
		
		canvas.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.UP) {
					isUpPressed = false;
					setYDirection();
				}
				else if (event.getCode() == KeyCode.DOWN) {
					isDownPressed = false;
					setYDirection();
				}
				
			}
		
		});
		
		
	}
	
	private void vs2pKeyboardControl() {
		
		//keyboard control
		canvas.setFocusTraversable(true);
		canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.UP) {
					isUpPressed = true;
					setP2YDirection();
				}
				else if (event.getCode() == KeyCode.DOWN) {
					isDownPressed = true;
					setP2YDirection();
				}
				else if (event.getCode() == KeyCode.ENTER) {
					gameStarted = true;
					playerOneYPos = height / 2;
					playerTwoYPos = height / 2;
				}
				else if (event.getCode() == KeyCode.W) {
					isWPressed = true;
					setP1YDirection();
				}
				else if (event.getCode() == KeyCode.S) {
					isSPressed = true;
					setP1YDirection();
				}
			}
			
		});
		
		canvas.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.UP) {
					isUpPressed = false;
					setP2YDirection();
				}
				else if (event.getCode() == KeyCode.DOWN) {
					isDownPressed = false;
					setP2YDirection();
				}
				else if (event.getCode() == KeyCode.W) {
					isWPressed = false;
					setP1YDirection();
				}
				else if (event.getCode() == KeyCode.S) {
					isSPressed = false;
					setP1YDirection();
				}
				
			}
		
		});
		
		
	}
	
	private void setYDirection() {
		
		int speed = 20;
		if (gameStarted && isUpPressed && !isDownPressed) {
			if (playerOneYPos > 15) {
				playerOneYPos -= speed;
			}
		}
		
		if (gameStarted && !isUpPressed && isDownPressed) {
			if (playerOneYPos < 575) {
				playerOneYPos += speed;
			}
		}
	}
	
	private void setP1YDirection() {
		
		int speed = 20;
		if (gameStarted && isWPressed && !isSPressed) {
			if (playerOneYPos > 15) {
				playerOneYPos -= speed;
			}
		}
		
		if (gameStarted && !isWPressed && isSPressed) {
			if (playerOneYPos < 575) {
				playerOneYPos += speed;
			}
		}
	}
	
	private void setP2YDirection() {
		
		int speed = 20;
		if (gameStarted && isUpPressed && !isDownPressed) {
			if (playerTwoYPos > 15) {
				playerTwoYPos -= speed;
			}
		}
		
		if (gameStarted && !isUpPressed && isDownPressed) {
			if (playerTwoYPos < 575) {
				playerTwoYPos += speed;
			}
		}
	}

	private void mouseControl() {
		//mouse control (move and click)
		canvas.setOnMouseClicked(e ->  gameStarted = true);
		canvas.setOnMouseMoved(e ->  playerOneYPos  = e.getY());
		
	}

	private void run(GraphicsContext gc) {
		//set graphics
		//set background color
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, width, height);
		
		//set text
		gc.setFill(Color.WHITE);
		gc.setFont(Font.font(25));
		
		if(gameStarted) {
			//set ball movement
			ballXPos+=ballXSpeed;
			ballYPos+=ballYSpeed;
			
			//simple computer opponent who is following the ball
			if(ballXPos < width - width  / 4) {
				playerTwoYPos = ballYPos - PLAYER_HEIGHT / 2;
			}  else {
				playerTwoYPos =  ballYPos > playerTwoYPos + PLAYER_HEIGHT / 2 ?playerTwoYPos += 1: playerTwoYPos - 1;
			}
			//draw the ball
			gc.fillOval(ballXPos, ballYPos, BALL_R, BALL_R);
			
		} else {
			//set the start text
			gc.setStroke(Color.WHITE);
			gc.setTextAlign(TextAlignment.CENTER);
			//set the text
			String fillText;
			if (mouse.isMouseChosen()) fillText = "CLICK";
			else fillText = "Press Enter";
			gc.strokeText(fillText, width / 2, height / 2);
			
			//reset the ball start position 
			ballXPos = width / 2;
			ballYPos = height / 2;
			
			//reset the ball speed and the direction
			ballXSpeed = new Random().nextInt(2) == 0 ? 1: -1;
			ballYSpeed = new Random().nextInt(2) == 0 ? 1: -1;
		}
		
		//makes sure the ball stays in the canvas
		if(ballYPos > height || ballYPos < 0) ballYSpeed *=-1;
		
		//if you miss the ball, computer gets a point
		if(ballXPos < playerOneXPos - PLAYER_WIDTH) {
			scoreP2++;
			gameStarted = false;
		}
		
		//if the computer misses the ball, you get a point
		if(ballXPos > playerTwoXPos + PLAYER_WIDTH) {  
			scoreP1++;
			gameStarted = false;
		}
	
		//increase the speed after the ball hits the player
		if( ((ballXPos + BALL_R > playerTwoXPos) && ballYPos >= playerTwoYPos && ballYPos <= playerTwoYPos + PLAYER_HEIGHT) || 
			((ballXPos < playerOneXPos + PLAYER_WIDTH) && ballYPos >= playerOneYPos && ballYPos <= playerOneYPos + PLAYER_HEIGHT)) {
			ballYSpeed += 1 * Math.signum(ballYSpeed);
			ballXSpeed += 1 * Math.signum(ballXSpeed);
			ballXSpeed *= -1;
			ballYSpeed *= -1;
		}
		
		//draw score
		gc.fillText(scoreP1 + "\t\t\t\t\t\t\t\t" + scoreP2, width / 2, 100);
		//draw player 1 & 2
		gc.fillRect(playerTwoXPos, playerTwoYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
		gc.fillRect(playerOneXPos, playerOneYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
	}
	
	private void vs2pRun(GraphicsContext gc) {
		//set graphics
		//set background color
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, width, height);
		
		//set text
		gc.setFill(Color.WHITE);
		gc.setFont(Font.font(25));
		
		if(gameStarted) {
			//set ball movement
			ballXPos+=ballXSpeed;
			ballYPos+=ballYSpeed;
			
			//draw the ball
			gc.fillOval(ballXPos, ballYPos, BALL_R, BALL_R);
			
		} else {
			//set the start text
			gc.setStroke(Color.WHITE);
			gc.setTextAlign(TextAlignment.CENTER);
			//set the text
			String fillText = "Press Enter";
			gc.strokeText(fillText, width / 2, height / 2);
			
			//reset the ball start position 
			ballXPos = width / 2;
			ballYPos = height / 2;
			
			//reset the ball speed and the direction
			ballXSpeed = new Random().nextInt(2) == 0 ? 1: -1;
			ballYSpeed = new Random().nextInt(2) == 0 ? 1: -1;
		}
		
		//makes sure the ball stays in the canvas
		if(ballYPos > height || ballYPos < 0) ballYSpeed *=-1;
		
		//if p1 miss the ball, p2  gets a point
		if(ballXPos < playerOneXPos - PLAYER_WIDTH) {
			scoreP2++;
			gameStarted = false;
		}
		
		//if p2 misses the ball, p1 get a point
		if(ballXPos > playerTwoXPos + PLAYER_WIDTH) {  
			scoreP1++;
			gameStarted = false;
		}
	
		//increase the speed after the ball hits the player
		if( ((ballXPos + BALL_R > playerTwoXPos) && ballYPos >= playerTwoYPos && ballYPos <= playerTwoYPos + PLAYER_HEIGHT) || 
			((ballXPos < playerOneXPos + PLAYER_WIDTH) && ballYPos >= playerOneYPos && ballYPos <= playerOneYPos + PLAYER_HEIGHT)) {
			ballYSpeed += 1 * Math.signum(ballYSpeed);
			ballXSpeed += 1 * Math.signum(ballXSpeed);
			ballXSpeed *= -1;
			ballYSpeed *= -1;
		}
		
		//draw score
		gc.fillText(scoreP1 + "\t\t\t\t\t\t\t\t" + scoreP2, width / 2, 100);
		//draw player 1 & 2
		gc.fillRect(playerTwoXPos, playerTwoYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
		gc.fillRect(playerOneXPos, playerOneYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
	}
		
}
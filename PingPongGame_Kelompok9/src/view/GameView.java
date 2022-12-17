package view;


import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

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
	private AnchorPane gamePane;
	private Scene gameScene;
	private Canvas canvas;
	private Rectangle obstacleTop;
	private Rectangle obstacleBottom;
	private Rectangle obstacleMiddle;
	private AnimationTimer gameTimer;
	private Color backgroundColor;
	private Color fontColor;

	
	private boolean isUpPressed;
	private boolean isDownPressed;
	private boolean isWPressed;
	private boolean isSPressed;
	private boolean isMouseChosen;	
	
	@Override
	public void start(Stage gameStage) throws Exception {
		gameStage.setTitle("Ping Pong");
		canvas = new Canvas(width, height);
		initialize();
		
		gamePane = new AnchorPane(canvas);
		obstacleHandler();
		createGameLoop();
		gameScene = new Scene(gamePane);
		gameStage.setScene(gameScene);
		
		gameStage.show();
	}
	
	public void vs2pStart(Stage gameStage) throws Exception {

		gameStage.setTitle("Ping Pong");
		canvas = new Canvas(width, height);
		vs2pInitialize();
		
		gamePane = new AnchorPane(canvas);
		obstacleHandler();
		createGameLoop();
		gameScene = new Scene(gamePane);
		gameStage.setScene(gameScene);
		gameStage.show();
	}
	
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}
	
	
	public void setMouseChosen(boolean isMouseChosen) {
		this.isMouseChosen = isMouseChosen;
	}

	private void initialize(){
		//background size
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		//JavaFX Timeline = free form animation defined by KeyFrames and their duration 
		Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc)));
		//number of cycles in animation INDEFINITE = repeat indefinitely
		tl.setCycleCount(Timeline.INDEFINITE);
		
		if (isMouseChosen)
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
				else if (event.getCode() == KeyCode.SPACE) {
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
				else if (event.getCode() == KeyCode.SPACE) {
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
		gc.setFill(backgroundColor);
		gc.fillRect(0, 0, width, height);
		
		//set text
		gc.setFill(fontColor);
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
			gc.setStroke(fontColor);
			gc.setTextAlign(TextAlignment.CENTER);
			//set the text
			String fillText;
			if (isMouseChosen) fillText = "CLICK";
			else fillText = "Press Space";
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
		collisionObstacle();
		
		
		
		//draw score
		gc.fillText(scoreP1 + "\t\t\t\t\t\t\t\t" + scoreP2, width / 2, 100);
		//draw player 1 & 2
		gc.fillRect(playerTwoXPos, playerTwoYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
		gc.fillRect(playerOneXPos, playerOneYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
	}
	
	private void vs2pRun(GraphicsContext gc) {
		//set graphics
		//set background color
		gc.setFill(backgroundColor);
		gc.fillRect(0, 0, width, height);
		
		//set text
		gc.setFill(fontColor);
		gc.setFont(Font.font(25));
		
		if(gameStarted) {
			//set ball movement
			ballXPos+=ballXSpeed;
			ballYPos+=ballYSpeed;
			
			//draw the ball
			gc.fillOval(ballXPos, ballYPos, BALL_R, BALL_R);
			
		} else {
			//set the start text
			gc.setStroke(fontColor);
			gc.setTextAlign(TextAlignment.CENTER);
			//set the text
			String fillText = "Press Space";
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
		
		collisionObstacle();
		
		//draw score
		gc.fillText(scoreP1 + "\t\t\t\t\t\t\t\t" + scoreP2, width / 2, 100);
		//draw player 1 & 2
		gc.fillRect(playerTwoXPos, playerTwoYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
		gc.fillRect(playerOneXPos, playerOneYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
	}
	
	private void obstacleHandler() {
	    int ObstacleWidth = 20;
	    double xPosition = width/2;
	    double yPosition = 0;
	    double obstacleHeight = 100;
	    
	    
	    obstacleTop = new Rectangle(xPosition, yPosition ,ObstacleWidth ,obstacleHeight);
	    obstacleMiddle = new Rectangle(xPosition, yPosition + 230, ObstacleWidth, obstacleHeight -60);
	    obstacleBottom = new Rectangle(xPosition,yPosition + 400,  ObstacleWidth,obstacleHeight );
	    
	    obstacleTop.setFill(javafx.scene.paint.Color.WHITE);
	    obstacleBottom.setFill(javafx.scene.paint.Color.WHITE);
	    obstacleMiddle.setFill(javafx.scene.paint.Color.WHITE);
	    gamePane.getChildren().addAll(obstacleTop, obstacleBottom, obstacleMiddle);
}
	    
	    
	
	private void collisionObstacle() {
		double obstacleHeight = 100;
		int ObstacleWidth = 20;
		System.out.println("ini Y bola : " + ballYPos);
		
		
		
		double topKiri = 400;
		double topKanan = 400 + ObstacleWidth;
		double topAtas = obstacleTop.getY();
		double topBawah = obstacleTop.getY() + obstacleHeight  ;
		
		double bottomKiri = 400;
		double bottomKanan = 400 + ObstacleWidth;
		double bottomAtas = obstacleBottom.getY();
		double bottomBawah = obstacleBottom.getY() + obstacleHeight;
		
		double MiddleKiri = 400;
		double MiddleKanan = 400 + ObstacleWidth;
		double MiddleAtas = obstacleMiddle.getY();
		double MiddleBawah = obstacleMiddle.getY() + obstacleHeight - 60;
		
		boolean intersectTopObstacle = (ballXPos >= topKiri && ballXPos <=topKanan) && (ballYPos >= topAtas && ballYPos <=topBawah);
		boolean intersectBottomObstacle = ballXPos >= bottomKiri && ballXPos <= bottomKanan && ballYPos >= bottomAtas && ballYPos <= bottomBawah;
		boolean intersectMiddleObstacle = (ballXPos >= MiddleKiri && ballXPos <=MiddleKanan) && (ballYPos >= MiddleAtas && ballYPos <=MiddleBawah);
		
		
		if(intersectTopObstacle || intersectBottomObstacle || intersectMiddleObstacle) {
			ballYSpeed += 1 * Math.signum(ballYSpeed);
			ballXSpeed += 1 * Math.signum(ballXSpeed);
			ballXSpeed *= -1;
			ballYSpeed *= -1;
		}
	}
	
	private void createGameLoop(){
		
        gameTimer = new AnimationTimer() {

            @Override
            public void handle(long arg0) {
                moveObstacle();
            } 
            
        };

        gameTimer.start();
    }
	boolean flagTop = false;
	boolean flagBottom = false;
	boolean flagMiddle = false;
	
	private void moveObstacle() {
//		System.out.println("ini Y Top : " + obstacleTop.getY());
//		System.out.println("ini Y Bottom : " + obstacleBottom.getY());
//		System.out.println("ini Y Middle : " + obstacleMiddle.getY());
		
		if(obstacleTop.getY() < 100 && !flagTop) {
			obstacleTop.setY(obstacleTop.getY() + 10 );
		}else if(obstacleTop.getY()==100 && !flagTop) {
			flagTop = true;
		}else if(obstacleTop.getY() == 0 && flagTop) {
			flagTop = false;
		}else if(flagTop) {
			obstacleTop.setY(obstacleTop.getY() - 10 );
		}
		
		//****************************************************************
		
		if(obstacleMiddle.getY() < 300 && !flagMiddle) {
			obstacleMiddle.setY(obstacleMiddle.getY() + 7 );
		}else if(obstacleMiddle.getY()==300 && !flagMiddle) {
			flagMiddle = true;
		}else if(obstacleMiddle.getY() == 230 && flagMiddle) {
			flagMiddle = false;
		}else if(flagMiddle) {
			obstacleMiddle.setY(obstacleMiddle.getY() - 7 );
		}
		
		
		//****************************************************************
		
		if(obstacleBottom.getY() < 500 && !flagBottom) {
			obstacleBottom.setY(obstacleBottom.getY() + 10 );
		}else if(obstacleBottom.getY()== 500 && !flagBottom) {
			flagBottom = true;
		}else if(obstacleBottom.getY() == 400 && flagBottom) {
			flagBottom = false;
		}else if(flagBottom) {
			obstacleBottom.setY(obstacleBottom.getY() - 10 );
		}
		
	}


		
}
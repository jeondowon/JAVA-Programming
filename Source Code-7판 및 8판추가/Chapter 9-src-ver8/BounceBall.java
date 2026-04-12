import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.event.EventHandler;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.event.ActionEvent;

/**
This program animates a red ball within
The window.
*/
public class BounceBall extends Application
{
   public static void main(String[] args)
   {
      Application.launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception
   {
	Pane root = new Pane();
	root.setPrefSize(400,400);

	Ball ball = new Ball();

	// Timeline to call the event handler every 10ms
	// to update a bouncing ball
	Timeline timeline = new Timeline(
        new KeyFrame(Duration.millis(10),
               new EventHandler()
			   {
			   	@Override
			   	public void handle(ActionEvent event)
			   	{
			   		ball.updateLocation();
			   		if ((ball.getX() < 0) ||
			   		    (ball.getX() > root.getWidth()))
			   			ball.reverseX();
			   		if ((ball.getY() < 0) ||
			   		    (ball.getY() > root.getHeight()))
			   			ball.reverseY();
			   	}
			   }
        )
	);
	timeline.setCycleCount(Timeline.INDEFINITE);
	timeline.setAutoReverse(true);
	timeline.play();

	root.getChildren().add(ball);
	primaryStage.setScene(new Scene(root));
	primaryStage.setTitle("Bouncing Ball");
	primaryStage.show();
   }
}
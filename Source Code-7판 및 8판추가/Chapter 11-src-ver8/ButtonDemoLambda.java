import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

/**
Event handling with lambda functions. This program implements
Listing 8.23 using lambda functions.
*/
public class ButtonDemoLambda extends Application
{
   public static void main(String[] args)
   {
      launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception
   {
	VBox root = new VBox();
	Button btnSunny;
	Button btnCloudy;
	Label lblMessage;
	btnSunny = new Button("Sunny");
	btnCloudy = new Button("Cloudy");
	lblMessage = new Label("Click a button.");

	btnSunny.setOnAction(kttt ->
	{
	   	lblMessage.setText("It is sunny!");
	    }
	);
	btnCloudy.setOnAction(kttt ->
	{
	     	 lblMessage.setText("It is cloudy!");
	     }
	);

	root.getChildren().add(btnSunny);
	root.getChildren().add(btnCloudy);
	root.getChildren().add(lblMessage);

	Scene scene = new Scene(root, 300, 100);
	primaryStage.setTitle("Lambda Button Demo");
	primaryStage.setScene(scene);
	primaryStage.show();
   }
}
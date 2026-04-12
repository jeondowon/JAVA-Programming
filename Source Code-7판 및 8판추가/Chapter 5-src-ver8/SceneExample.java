import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import java.lang.Math;
import javafx.stage.Stage;

public class SceneExample extends Application
{
   public static void main(String[] args)
   {
      launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception
   {
    Group root = new Group();
    Scene s = new Scene(root, 300, 300, Color.BLACK);

    Rectangle r = new Rectangle(25,25,250,250);
    r.setFill(Color.BLUE);
    root.getChildren().add(r);

	primaryStage.setTitle("Scene Test  in JavaFX");
	primaryStage.setScene(s);
	primaryStage.show();

   }
}
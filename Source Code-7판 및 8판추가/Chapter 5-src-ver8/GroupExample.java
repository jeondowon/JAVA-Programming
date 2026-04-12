import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import java.lang.Math;
import javafx.stage.Stage;

public class GroupExample extends Application
{
   public static void main(String[] args)
   {
      launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception
   {
    Group g = new Group();
    Scene s = new Scene(g, 300, 300, Color.BLACK);

    for (int i = 0; i < 5; i++) {
         Rectangle r = new Rectangle();
         r.setY(i * 20);
         r.setWidth(100);
         r.setHeight(10);
         r.setFill(Color.RED);
         g.getChildren().add(r);
     }

     	primaryStage.setTitle("Group Test  in JavaFX");
	 	primaryStage.setScene(s);
	 	primaryStage.show();

   }
}
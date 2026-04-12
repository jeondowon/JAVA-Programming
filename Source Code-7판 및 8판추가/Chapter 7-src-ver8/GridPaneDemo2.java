import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
/**
Simple demonstration of adding buttons and labels
to the GridPane layout.
*/
public class GridPaneDemo2 extends Application
{
   public static void main(String[] args)
   {
      launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception
   {
	GridPane root = new GridPane();

	// Set a gap of 5 pixels vertically and horizontally
	// between elements
	root.setVgap(5);
	root.setHgap(5);
	// Margins around the top, right, bottom, and left
	root.setPadding(new Insets(10,10,10,10));

	// Add three nodes, by default horizontally left-aligned
    for (int i = 0; i<10; i++) {
		for (int j = 0; j<10; j++) {
	root.add(new Button(i+" Button "+j),j,i);
    }
    }

	Scene scene = new Scene(root, 900, 500);
	primaryStage.setTitle("GridPane Demo");
	primaryStage.setScene(scene);
	primaryStage.show();
   }
}
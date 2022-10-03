/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package pathtransition;


import javafx.animation.Timeline;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Ivan
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        //Setting title
        primaryStage.setTitle("PathTransitionDemo");
        
        //Circle
        Circle circle = new Circle(125, 100, 50);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        
        //Rectangle
        Rectangle rectangle = new Rectangle(20,50);
        rectangle.setFill(Color.ORANGE);
        
        // Create a path transition
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(circle);
        pt.setNode(rectangle);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        
        //Start animation
        pt.play();
        
        //Mouse Event
        circle.setOnMousePressed(e->pt.pause());
        circle.setOnMouseReleased(e->pt.play());
        
        //Pane and Scene
        Pane root = new Pane();
        root.getChildren().add(circle);
        root.getChildren().add(rectangle);
        Scene scene = new Scene(root, 250, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
    
}

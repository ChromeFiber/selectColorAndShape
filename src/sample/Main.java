package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        HBox shapeBox = new HBox();
        VBox fill = new VBox();
        ToggleGroup filling = new ToggleGroup();
        ToggleGroup shapes = new ToggleGroup();
        Slider shapeResizer = new Slider();
        CheckBox filled = new CheckBox("Fill shape");
        RadioButton isCircle = new RadioButton("Circle");
        isCircle.setPadding(new Insets(3));
        RadioButton isRectangle = new RadioButton("Rectangle");
        isRectangle.setPadding(new Insets(3));
        RadioButton isEllipse = new RadioButton("Ellipse");
        isEllipse.setPadding(new Insets(3));

        isCircle.setToggleGroup(shapes);
        isRectangle.setToggleGroup(shapes);
        isEllipse.setToggleGroup(shapes);
        HBox shaperu = new HBox();
        shaperu.getChildren().addAll(isCircle, isRectangle, isEllipse);
        Circle circle = new Circle(34);
        circle.setFill(null);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(3);
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(50);
        rectangle.setHeight(50);
        rectangle.setFill(null);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(3);
        Ellipse ellipse = new Ellipse(34, 34);
        circle.setOpacity(0);
        rectangle.setOpacity(0);
        ellipse.setOpacity(0);
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(null);
        ellipse.setStrokeWidth(3);
      shapes.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
          if(isCircle.isSelected()){
              circle.setOpacity(1);
          }
          else {
              circle.setOpacity(0);
          }
          if(isRectangle.isSelected()){
              rectangle.setOpacity(1);
          }
          else {
              rectangle.setOpacity(0);
          }
          if(isEllipse.isSelected())
          {
              ellipse.setOpacity(1);
          }
          else {
              ellipse.setOpacity(0);
          }
      });

        filled.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(filled.isSelected()){
                filled.setOnAction( event ->{
                    circle.setFill(Color.BLACK);
                    rectangle.setFill(Color.BLACK);
                    ellipse.setFill(Color.BLACK);
                });
            }
            else{
                filled.setOnAction( e ->{
                    circle.setFill(null);
                    rectangle.setFill(null);
                    ellipse.setFill(null);
                } );

            }
        });



        fill.getChildren().addAll(filled);
        shapeBox.getChildren().addAll(circle, rectangle, ellipse);
        GridPane.setConstraints(shapeBox, 1, 1);
        GridPane.setConstraints(fill,2, 2);
        GridPane.setConstraints(shaperu, 1, 0);
        root.getChildren().addAll(shapeBox, fill,shaperu);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 320));
        primaryStage.show();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw14;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class HW14_17 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Arc mound = new Arc(40, 275, 50, 50, 40, 100);
        //center is (40, 250)
        //radius is 50 for both x and y
        mound.setFill(Color.TRANSPARENT);
        mound.setType(ArcType.OPEN);
        mound.setStroke(Color.BLACK);
        Line bPost = new Line(40, 225, 40, 20);
        Line hPost = new Line(40, 20, 140, 20);
        Line rope = new Line(140, 20, 140, 50);
        Circle head = new Circle();
        head.setFill(Color.TRANSPARENT);
        head.setStroke(Color.BLACK);
        head.setRadius(20);
        head.setCenterX(140);
        head.setCenterY(70);
        Line arm1 = new Line((140 + (20 * Math.cos(Math.toRadians(45)))), (70 + (20 * Math.sin(Math.toRadians(45)))), 200, 120);
        Line arm2 = new Line((140 + (20 * Math.cos(Math.toRadians(135)))), 
                (70 + (20 * Math.sin(Math.toRadians(135)))), 
                (140 + (20 * Math.cos(Math.toRadians(135)))) - 47,
                (70 + (20 * Math.sin(Math.toRadians(135)))) + 37);
        Line body = new Line ((140 + (20 * Math.cos(Math.toRadians(90)))), (70 + (20 * Math.sin(Math.toRadians(90)))), 
                (140 + (20 * Math.cos(Math.toRadians(90)))), 150);
        double lowerBody = (140 + (20 * Math.cos(Math.toRadians(90))));
        Line leg1 = new Line(lowerBody, 150, lowerBody + 30, 190 );
        Line leg2 = new Line(lowerBody, 150, lowerBody - 30, 190 );
        double distanceX = arm1.getStartX();
        double distanceY = arm1.getStartY();
        System.out.println("(" + distanceX + ", " + distanceY + ")");
        pane.getChildren().add(mound);
        pane.getChildren().addAll(bPost, hPost, rope, head, arm1, arm2, body, leg1, leg2);
        

        
        Scene scene = new Scene(pane, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

class CircleImp extends Circle{
    public double[] angleToPoint(double a){
        double x = (getCenterX() + (getRadius() * Math.cos(Math.toRadians(a))));
        double y = (getCenterY() + (getRadius() * Math.sin(Math.toRadians(a))));
        double[] points = {x, y};
        return points;
        
        
    }
}


package triangleoncircle;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class TriangleOnCircle extends Application {
    
    
    Circle circle;  //circle
    Circle point1, point2, point3; //points/nodes
    Line line1, line2, line3; //lines to connect points
    Text angleText1, angleText2, angleText3; //angle text
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        circle = new Circle(250, 250, 200);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        
        
        points();
        lines();
        angles();
        drag();
        Group gp = new Group(circle, line1, line2, line3, point1, point2, point3, angleText1, angleText2, angleText3);
        Scene sn = new Scene(gp, 500, 500, Color.WHITE);
        stage.setScene(sn);
        stage.setTitle("TriangleOnCircle");
        stage.show();
       
    }
    
    //initializes points/nodes and lines
    public void points(){
        double x, y;
        
        x = circle.getCenterX() + circle.getRadius() * Math.cos(45);
        y = circle.getCenterY() + circle.getRadius() * Math.sin(45);
        
        point1 = new Circle(x, y, 10);
        point1.setFill(Color.RED);
        point1.setStroke(Color.BLACK);

        
        x = circle.getCenterX() + circle.getRadius() * Math.cos(275);
        y = circle.getCenterY() + circle.getRadius() * Math.sin(275);
        
        point2 = new Circle(x, y, 10);
        point2.setFill(Color.RED);
        point2.setStroke(Color.BLACK);
        
        x = circle.getCenterX() + circle.getRadius() * Math.cos(185);
        y = circle.getCenterY() + circle.getRadius() * Math.sin(185);
        
        point3 = new Circle(x, y, 10);
        point3.setFill(Color.RED);
        point3.setStroke(Color.BLACK);
      
    }
   
      
    //initializes lines conneting points
    public void lines(){
        
        line1 = new Line(point1.getCenterX(), point1.getCenterY(), point2.getCenterX(), point2.getCenterY());
        line2 = new Line(point2.getCenterX(), point2.getCenterY(), point3.getCenterX(), point3.getCenterY());
        line3 = new Line(point3.getCenterX(), point3.getCenterY(), point1.getCenterX(), point1.getCenterY());
        
    }
    
    //initializes text angle
    public void angles(){
        double x, y; //
        double d1, d2, d3;
        double a1, a2, a3;
        
        d1 = distance(point1.getCenterX(), point1.getCenterY(), point2.getCenterX(), point2.getCenterY());
        d2 = distance(point2.getCenterX(), point2.getCenterY(), point3.getCenterX(), point3.getCenterY());
        d3 = distance(point3.getCenterX(), point3.getCenterY(), point1.getCenterX(), point1.getCenterY());


        x = circle.getCenterX() + (circle.getRadius() - 50) * Math.cos(45);
        y = circle.getCenterY() + (circle.getRadius() - 50) * Math.sin(45);
        
        a1 = Math.acos(((d1 * d1) - (d2 * d2) - (d3 * d3)) / (-2 * d2 * d3));
        
        angleText1 = new Text();
        angleText1.setX(x);
        angleText1.setY(y);
        angleText1.setText(String.format("%.0f", Math.toDegrees(a1)));  
        
        
        x = circle.getCenterX() + (circle.getRadius() - 50) * Math.cos(275);
        y = circle.getCenterY() + (circle.getRadius() - 50) * Math.sin(275);
        
        a2 = Math.acos(((d1 * d1) - (d2 * d2) - (d3 * d3)) / (-2 * d2 * d3));
        
        angleText2 = new Text();
        angleText2.setX(x);
        angleText2.setY(y);
        angleText2.setText(String.format("%.0f", Math.toDegrees(a2)));
        
        x = circle.getCenterX() + (circle.getRadius() - 50) * Math.cos(185);
        y = circle.getCenterY() + (circle.getRadius() - 50) * Math.sin(185);
        
        a3 = Math.acos(((d1 * d1) - (d2 * d2) - (d3 * d3)) / (-2 * d2 * d3));
        
        angleText3 = new Text();
        angleText3.setX(x);
        angleText3.setY(y);
        angleText3.setText(String.format("%.0f", Math.toDegrees(a3)));
        
        
    }
    
    public void test(){
        
        double d1 = distance(point1.getCenterX(), point1.getCenterY(), point2.getCenterX(), point2.getCenterY());
        double d2 = distance(point2.getCenterX(), point2.getCenterY(), point3.getCenterX(), point3.getCenterY());
        double d3 = distance(point3.getCenterX(), point3.getCenterY(), point1.getCenterX(), point1.getCenterY());
        
        double a1 = Math.acos(((d1 * d1) - (d2 * d2) - (d3 * d3)) / (-2 * d2 * d3));
        double a2 = Math.acos(((d1 * d1) - (d2 * d2) - (d3 * d3)) / (-2 * d2 * d3));
        double a3 = Math.acos(((d1 * d1) - (d2 * d2) - (d3 * d3)) / (-2 * d2 * d3));
        
        angleText1.setText(String.format("%.0f", Math.toDegrees(a1)));
        angleText2.setText(String.format("%.0f", Math.toDegrees(a2)));
        angleText3.setText(String.format("%.0f", Math.toDegrees(a3)));
    }
    
    public double distance(double x1, double y1, double x2, double y2) {

        double distance = Math.sqrt((x1 - x2) * (x1 - x2) + (y2 - y1) * (y2 - y1));
        
        return distance;
    }
    
    
    
    public void drag(){
        point1.setOnMouseDragged( e -> {
           
            double x = e.getX();
            double y = e.getY();
            
            point1.setCenterX(x);
            point1.setCenterY(y);
            
            line1.setStartX(point1.getCenterX());
            line1.setStartY(point1.getCenterY());
            line3.setEndX(point1.getCenterX());
            line3.setEndY(point1.getCenterY());
            
            double newX = point1.getCenterX() + (point1.getRadius() - 50) * Math.cos(45);
            double newY = point1.getCenterY() + (point1.getRadius() - 50) * Math.sin(45);
            
            angleText1.setX(newX);
            angleText1.setY(newY);
            test();
        });
        
        point2.setOnMouseDragged( e -> {
            
            double x = e.getX();
            double y = e.getY();
            
            point2.setCenterX(x);
            point2.setCenterY(y);
            
            line2.setStartX(point2.getCenterX());
            line2.setStartY(point2.getCenterY());
            line1.setEndX(point2.getCenterX());
            line1.setEndY(point2.getCenterY());

            double newX = point2.getCenterX() + (point2.getRadius() - 50) * Math.cos(275);
            double newY = point2.getCenterY() + (point2.getRadius() - 50) * Math.sin(275);
                        
            angleText2.setX(newX);
            angleText2.setY(newY);
            test();            
        });

        point3.setOnMouseDragged( e -> {
            
            double x = e.getX();
            double y = e.getY();
            
            point3.setCenterX(x);
            point3.setCenterY(y);
            
            line3.setStartX(point3.getCenterX());
            line3.setStartY(point3.getCenterY());
            line2.setEndX(point3.getCenterX());
            line2.setEndY(point3.getCenterY());

            double newX = point3.getCenterX() + (point3.getRadius() - 50) * Math.cos(185);
            double newY = point3.getCenterY() + (point3.getRadius() - 50) * Math.sin(185);
                        
            angleText3.setX(newX);
            angleText3.setY(newY); 
            test();
        });
        
    }
    
    
}

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
public class JavaFXMainFrame extends Stage {
    public void initialize(User user) {
        AnchorPane anchor1 = new AnchorPane();
        //Attendence Of
        Label label2=new Label("ATTENDANCE OF "+user.regis);
        label2.setFont(Font.font("OCR A Extended", FontWeight.BOLD,30));
        label2.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(label2, 50.0);
        AnchorPane.setRightAnchor(label2, 0.0);
        AnchorPane.setTopAnchor(label2, 20.0);
        label2.setAlignment(Pos.CENTER);
        anchor1.getChildren().add(label2);
        //Exit
        Image exit=new Image("/icons/exit1.png");
        ImageView exit1=new ImageView(exit);
        anchor1.getChildren().add(exit1);
        exit1.setX(850); 
        exit1.setY(20); 
        exit1.setFitHeight(15); 
        exit1.setFitWidth(15); 
        exit1.setOnMouseClicked(e-> close());
        //Name
        Label name = new Label("Name:");
        name.setFont(Font.font("OCR A Extended", FontWeight.BOLD,20));
        name.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(name, 50.0);
        AnchorPane.setTopAnchor(name, 85.0);
        anchor1.getChildren().add(name);
        Label name1 = new Label(user.name);
        name1.setFont(Font.font("OCR A Extended", FontWeight.BOLD,20));
        name1.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(name1, 120.0);
        AnchorPane.setTopAnchor(name1, 85.0);
        anchor1.getChildren().add(name1);
        //RegisNo
        Label regisno = new Label("Registration Number:");
        regisno.setFont(Font.font("OCR A Extended", FontWeight.BOLD,20));
        regisno.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(regisno, 50.0);
        AnchorPane.setTopAnchor(regisno, 115.0);
        anchor1.getChildren().add(regisno);
        Label regisno1 = new Label(user.regis);
        regisno1.setFont(Font.font("OCR A Extended", FontWeight.BOLD,20));
        regisno1.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(regisno1, 300.0);
        AnchorPane.setTopAnchor(regisno1, 115.0);
        anchor1.getChildren().add(regisno1);
        //Dept
        Label dept = new Label("Department:");
        dept.setFont(Font.font("OCR A Extended", FontWeight.BOLD,20));
        dept.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(dept, 50.0);
        AnchorPane.setTopAnchor(dept, 145.0);
        anchor1.getChildren().add(dept);
        Label dept1 = new Label(user.dept);
        dept1.setFont(Font.font("OCR A Extended", FontWeight.BOLD,20));
        dept1.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(dept1, 190.0);
        AnchorPane.setTopAnchor(dept1, 145.0);
        anchor1.getChildren().add(dept1);
        //Year
        Label year = new Label("Year:");
        year.setFont(Font.font("OCR A Extended", FontWeight.BOLD,20));
        year.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(year, 50.0);
        AnchorPane.setTopAnchor(year, 175.0);
        anchor1.getChildren().add(year);
        Label year1 = new Label(user.year);
        year1.setFont(Font.font("OCR A Extended", FontWeight.BOLD,20));
        year1.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(year1, 120.0);
        AnchorPane.setTopAnchor(year1, 175.0);
        anchor1.getChildren().add(year1);
        //CGPA
        Label cgpa = new Label("CGPA:");
        cgpa.setFont(Font.font("OCR A Extended", FontWeight.BOLD,20));
        cgpa.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(cgpa, 50.0);
        AnchorPane.setTopAnchor(cgpa, 205.0);
        anchor1.getChildren().add(cgpa);
        Label cgpa1 = new Label(user.cgpa);
        cgpa1.setFont(Font.font("OCR A Extended", FontWeight.BOLD,20));
        cgpa1.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(cgpa1, 120.0);
        AnchorPane.setTopAnchor(cgpa1, 205.0);
        anchor1.getChildren().add(cgpa1);
        //Gender
        Label genderr = new Label("Gender:");
        genderr.setFont(Font.font("OCR A Extended", FontWeight.BOLD,20));
        genderr.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(genderr, 50.0);
        AnchorPane.setTopAnchor(genderr, 235.0);
        anchor1.getChildren().add(genderr);
        Label genderr1 = new Label(user.gender);
        genderr1.setFont(Font.font("OCR A Extended", FontWeight.BOLD,20));
        genderr1.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(genderr1, 145.0);
        AnchorPane.setTopAnchor(genderr1, 235.0);
        anchor1.getChildren().add(genderr1);
        //Mobile
        Label mobile = new Label("Mobile Number:");
        mobile.setFont(Font.font("OCR A Extended", FontWeight.BOLD,20));
        mobile.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(mobile, 50.0);
        AnchorPane.setTopAnchor(mobile, 270.0);
        anchor1.getChildren().add(mobile);
        Label mobile1 = new Label(user.phone);
        mobile1.setFont(Font.font("OCR A Extended", FontWeight.BOLD,20));
        mobile1.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(mobile1, 230.0);
        AnchorPane.setTopAnchor(mobile1, 270.0);
        anchor1.getChildren().add(mobile1);
        //Ring
        ProgressIndicator ringProgressIndicator=new ProgressIndicator();
        ringProgressIndicator.setMinSize(190, 190);
        ringProgressIndicator.setStyle("-fx-accent: #90EE90;");
        AnchorPane.setLeftAnchor(ringProgressIndicator, 600.0);
        AnchorPane.setTopAnchor(ringProgressIndicator, 95.0);  
        double progressValue = user.percent / 100.0;
        ringProgressIndicator.setProgress(progressValue);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(ringProgressIndicator.progressProperty(), 0.0)),
                new KeyFrame(Duration.seconds(2),
                        new KeyValue(ringProgressIndicator.progressProperty(), progressValue)
                )
        );
        timeline.setCycleCount(1);
        timeline.play();
        anchor1.getChildren().add(ringProgressIndicator);
        Scene scene = new Scene(anchor1, 900, 350);
        setScene(scene);
        getIcons().add(new Image("/icons/logo.png")); 
        getStyle();
        initStyle(StageStyle.UNDECORATED);
        show();
    }
}


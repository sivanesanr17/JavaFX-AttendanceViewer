import java.time.format.DateTimeFormatter;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class PasswordScene {
    public void display() {
        Stage primaryStage=new Stage();
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color: #b3e6ff;");
        // DatePicker
        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Date Of Birth");
        AnchorPane.setLeftAnchor(datePicker, 155.0);
        AnchorPane.setTopAnchor(datePicker, 120.0);
        anchorPane.getChildren().add(datePicker);
        // Label to display generated date
        Label resultLabel = new Label();
        resultLabel.setFont(Font.font("OCR A Extended", FontWeight.BOLD, 14));
        resultLabel.setStyle("-fx-text-fill: #000000;");
        AnchorPane.setLeftAnchor(resultLabel, 145.0);
        AnchorPane.setTopAnchor(resultLabel, 230.0);
        anchorPane.getChildren().add(resultLabel);
        //Know Your Password
        Label label2=new Label("Know Your Password?");
        label2.setFont(Font.font("OCR A Extended", FontWeight.BOLD,20));
        label2.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(label2, 60.0);
        AnchorPane.setRightAnchor(label2, 30.0);
        AnchorPane.setTopAnchor(label2,60.0);
        label2.setAlignment(Pos.CENTER);
        anchorPane.getChildren().add(label2);
        //Date Of Birth
        Label label3=new Label("Date Of Birth");
        label3.setFont(Font.font("OCR A Extended", FontWeight.BOLD,10));
        label3.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(label3, 40.0);
        AnchorPane.setRightAnchor(label3, 30.0);
        AnchorPane.setTopAnchor(label3, 100.0);
        label3.setAlignment(Pos.CENTER);
        anchorPane.getChildren().add(label3);
        // Generate Button
        JFXButton generateButton = new JFXButton("Generate");
        generateButton.setPrefSize(80, 25);
        generateButton.setStyle("-fx-background-color:   #000000");
        generateButton.setFont(Font.font("OCR A Extended", FontWeight.BOLD, 10));
        generateButton.setTextFill(Color.WHITE);
        AnchorPane.setLeftAnchor(generateButton, 195.0);
        AnchorPane.setTopAnchor(generateButton, 170.0);
        anchorPane.getChildren().add(generateButton);
        //Icon
        Image user=new Image("/icons/exit1.png");
        ImageView user1=new ImageView(user);
        anchorPane.getChildren().add(user1);
        user1.setX(420); 
        user1.setY(20); 
        user1.setFitHeight(15); 
        user1.setFitWidth(15); 
        user1.setOnMouseClicked(e->primaryStage.close());
        // Set actions
        generateButton.setOnAction(e -> {
            if (datePicker.getValue() == null) {
                CustomAlert csal=new CustomAlert();
                csal.start(primaryStage);
            } else {
                String selectedDate = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
                resultLabel.setText("Your Password: " + selectedDate);
            }
        });
        Scene scene = new Scene(anchorPane, 465,300 );
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

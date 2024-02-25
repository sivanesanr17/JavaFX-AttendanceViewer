import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class CustomAlert extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        Font ocrFont = Font.font("OCR A Extended", 14);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Incorrect Entries");
        alert.initStyle(StageStyle.UNDECORATED);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle("-fx-background-color: #404040;");
        dialogPane.setHeader(new Label(""));
        Label contentText = (Label) dialogPane.lookup(".content.label");
        contentText.setTextFill(Color.WHITE);
        contentText.setFont(ocrFont);      
        for (ButtonType buttonType : alert.getButtonTypes()) {
            Button button = (Button) dialogPane.lookupButton(buttonType);
            if (button != null) {
                button.setFont(ocrFont);
                button.setStyle("-fx-text-fill: white; -fx-background-color: #ff0000;"); 
            }
        }
        alert.showAndWait()
                .filter(response -> response == ButtonType.OK)
                .ifPresent(response -> {
                    System.out.println("Incorrect Entries");
                });
    }
}

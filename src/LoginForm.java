import java.io.FileNotFoundException;
import java.sql.*;
import com.jfoenix.controls.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class LoginForm extends Application {
    private JFXTextField tfRegis;
    private JFXPasswordField pfPassword;
    private double xOffset = 0;
    private double yOffset = 0;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
         AnchorPane anchor1=new AnchorPane();
        //PSNACET
        Label label1=new Label("PSNACET");
        label1.setFont(Font.font("OCR A Extended", FontWeight.BOLD,40));
        label1.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(label1, 50.0);
        AnchorPane.setRightAnchor(label1, 0.0);
        AnchorPane.setTopAnchor(label1, 20.0);
        label1.setAlignment(Pos.CENTER);
        anchor1.getChildren().add(label1);
        //Attendence Viewer
        Label label2=new Label("ATTENDANCE VIEWER");
        label2.setFont(Font.font("OCR A Extended", FontWeight.BOLD,15));
        label2.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(label2, 70.0);
        AnchorPane.setRightAnchor(label2, 30.0);
        AnchorPane.setTopAnchor(label2,60.0);
        label2.setAlignment(Pos.CENTER);
        anchor1.getChildren().add(label2);
        //PasswordLabel
        Label label4=new Label("Password?");
        label4.setFont(Font.font("OCR A Extended", FontWeight.LIGHT,10));
        label4.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(label4, 165.0);
        AnchorPane.setTopAnchor(label4,225.0);
        label4.setAlignment(Pos.TOP_LEFT);
        anchor1.getChildren().add(label4);
        label4.setOnMouseClicked(e->{
            PasswordScene pscene=new PasswordScene();
            pscene.display();
        });
        //TextField
        tfRegis=new JFXTextField();
        tfRegis.setPrefWidth(230);
        tfRegis.setFont(Font.font("OCR A Extended", FontWeight.BOLD,15));
        tfRegis.setFocusColor(Color.GRAY);
        AnchorPane.setLeftAnchor(tfRegis, 165.0);
        AnchorPane.setTopAnchor(tfRegis, 130.0);
        anchor1.getChildren().add(tfRegis);
        //PasswordField
        pfPassword=new JFXPasswordField();
        pfPassword.setPrefWidth(230);
        pfPassword.setFocusColor(Color.GRAY);
        AnchorPane.setLeftAnchor(pfPassword, 165.0);
        AnchorPane.setTopAnchor(pfPassword, 180.0);
        anchor1.getChildren().add(pfPassword);
        //Button
        Button button=new JFXButton("Login");
        button.setPrefSize(70,35);
        button.setStyle("-fx-background-color: #000000 ");
        button.setFont(Font.font("OCR A Extended",10));
        button.setTextFill(Color.WHITE);
        AnchorPane.setLeftAnchor(button, 230.0);
        AnchorPane.setTopAnchor(button, 260.0);
        anchor1.getChildren().add(button);
        button.setOnAction(e->handleLogin(primaryStage));
        //User
        Image user=new Image("/icons/user.png");
        ImageView user1=new ImageView(user);
        anchor1.getChildren().add(user1);
        user1.setX(140); 
        user1.setY(140); 
        user1.setFitHeight(15); 
        user1.setFitWidth(15); 
        //Lock
        Image lock=new Image("/icons/lock.png");
        ImageView lock1=new ImageView(lock);
        anchor1.getChildren().add(lock1);
        lock1.setX(140); 
        lock1.setY(190); 
        lock1.setFitHeight(15); 
        lock1.setFitWidth(15); 
        //Logo
        Image clglogo=new Image("/icons/logo.png");
        ImageView logo1=new ImageView(clglogo);
        anchor1.getChildren().add(logo1);
        logo1.setX(145); 
        logo1.setY(25); 
        logo1.setFitHeight(60); 
        logo1.setFitWidth(60); 
        //Exit
        Image exit=new Image("/icons/exit1.png");
        ImageView exit1=new ImageView(exit);
        anchor1.getChildren().add(exit1);
        exit1.setX(480); 
        exit1.setY(25); 
        exit1.setFitHeight(12); 
        exit1.setFitWidth(12); 
        exit1.setOnMouseClicked(e->primaryStage.close());
        Scene scene1=new Scene(anchor1,525,350);
        primaryStage.getIcons().add(new Image("/icons/logo.png"));     
        primaryStage.setScene(scene1);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        //Dragabble
        anchor1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        anchor1.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });
    }
    private void handleLogin(Stage primaryStage) {
        String regis = tfRegis.getText();
        String password = pfPassword.getText();
        User user = getAuthenticatedUser(regis, password);
        if (user != null) {
            JavaFXMainFrame mainFrame = new JavaFXMainFrame();
            mainFrame.initialize(user);
            primaryStage.close();
        } else {
            CustomAlert csal=new CustomAlert();
            csal.start(primaryStage);
        }
    }
    private User getAuthenticatedUser(String regis, String password) {
        User user = null;
        final String DB_URL = "jdbc:mysql://localhost/MyStore?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "SELECT * FROM users WHERE regis=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, regis);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.name = resultSet.getString("name");
                user.regis = resultSet.getString("regis");
                user.phone = resultSet.getString("phone");
                user.password = resultSet.getString("password");
                user.dept=resultSet.getString("dept");
                user.year=resultSet.getString("year");
                user.cgpa=resultSet.getString("cgpa");
                user.gender=resultSet.getString("gender");
                user.percent=resultSet.getInt("percent");
            }
            preparedStatement.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Database connection failed!");
        }
        return user;
    }
}

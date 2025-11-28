package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class SceneController
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML private Label loginLabel;
    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    @FXML private TextField nameField;
    @FXML private Button submitButton;


    @FXML
    private Label baseLabel;

    @FXML
    private Label showNameLabel;

    @FXML
    private Label showPasswordLabel;

    @FXML
    private Label showUsernameLabel;


    @FXML
    public void HomePage(ActionEvent event) throws Exception
    {
        root = FXMLLoader.load(getClass().getResource("/gui/Home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void showLoginPage(ActionEvent event) throws Exception
    {
        root = FXMLLoader.load(getClass().getResource("/gui/Login.fxml"));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    public void showInformation(ActionEvent event) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Bye.fxml"));
        Parent root = loader.load();

        // Get the controller of Bye.fxml
        SceneController controller = loader.getController();

        // Pass data to the new scene
        controller.showNameLabel.setText(usernameField.getText());
        controller.showPasswordLabel.setText(passwordField.getText());
        controller.showUsernameLabel.setText(nameField.getText());

        // Switch scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }



}

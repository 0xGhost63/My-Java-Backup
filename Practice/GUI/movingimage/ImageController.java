package movingimage;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class ImageController
{
    @FXML
    private AnchorPane root;

    @FXML
    private ImageView playerImage;

    private double x;
    private double y;
    private final double speed = 5;

    @FXML
    public void initialize()
    {
        x = playerImage.getLayoutX();
        y = playerImage.getLayoutY();

        // VERY IMPORTANT → so root receives key events
        root.setFocusTraversable(true);
        root.requestFocus();

        root.setOnKeyPressed(this::handleKeyPressed);
    }

    private void handleKeyPressed(KeyEvent event)
    {
        switch (event.getCode())
        {
            case W -> y -= speed;
            case S -> y += speed;
            case A -> x -= speed;
            case D -> x += speed;
            default -> {}
        }

        playerImage.setLayoutX(x);
        playerImage.setLayoutY(y);
    }
}

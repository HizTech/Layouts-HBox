package layouts.hbox;

import java.io.InputStream;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author JorgeLPR
 */
public class LayoutsHBox extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        VBox containerLeft = new VBox();

        //AGREGAMOS NODOS HIJOS (containerLeft)
        
        Label labelTitle = new Label("Iniciar Sesión");
        labelTitle.setFont(new Font(40));
        
        VBox containerLogin = new VBox();

        //AGREGAMOS NODOS HIJOS(containerLogin)
        
        Label labelUser = new Label("Usuario");
        //Cambiamos tamaño de fuente
        labelUser.setFont(new Font(20));
        
        Label labelPassword = new Label("Contraseña");
        labelPassword.setFont(new Font(20));

        TextField textUser = new TextField();
        textUser.setFont(new Font(18));
        //Agregamos texto informativo al textField
        textUser.setPromptText("Ingrese su usuario");
        //asignamos dimensiones predefinidas
        textUser.setPrefWidth(341);
        textUser.setPrefHeight(44);
        
        PasswordField textPass = new PasswordField();
        textPass.setFont(new Font(18));
        textPass.setPromptText("Ingrese su contraseña");        
        textPass.setPrefWidth(341);
        textPass.setPrefHeight(44);        
        
        Button btnLogin = new Button("Entrar");
        btnLogin.setFont(new Font(20));
        btnLogin.setPrefWidth(370);
        btnLogin.setPrefHeight(44);                
        btnLogin.setMaxWidth(Double.MAX_VALUE);
        btnLogin.setCursor(Cursor.HAND);

        //agregamos nodos hijos al containerLogin
        containerLogin.getChildren().addAll(labelUser, textUser, labelPassword, textPass, btnLogin);
        containerLogin.setAlignment(Pos.TOP_LEFT);

        //Agregamos margenes a los nodos que corresponden
        VBox.setMargin(labelUser, new Insets(10, 0, 0, 0));
        VBox.setMargin(labelPassword, new Insets(10, 0, 0, 0));
        VBox.setMargin(btnLogin, new Insets(20, 0, 0, 0));
        
        containerLeft.getChildren().addAll(labelTitle, containerLogin);
        containerLeft.setPrefWidth(422);
        containerLeft.setAlignment(Pos.CENTER);
        VBox.setMargin(containerLogin, new Insets(0, 30, 0, 30));        
        
        VBox containerRight = new VBox();        
        
        //AGREGAMOS NODOS containerRight        
        ImageView imageLogo;

        //Agregamos una imaagen
        InputStream inputStream;
        inputStream =  getClass().getResourceAsStream("/images/logo.png");
        Image image = new Image(inputStream);

        imageLogo = new ImageView(image);
        containerRight.getChildren().add(imageLogo);
        
        containerRight.setPrefWidth(422);
        containerRight.setAlignment(Pos.CENTER);
        containerRight.setBackground(new Background(new BackgroundFill(Color.web("#30373e"), CornerRadii.EMPTY, Insets.EMPTY)));
               
        HBox root = new HBox();
        root.getChildren().addAll(containerLeft, containerRight);
        HBox.setHgrow(containerLeft, Priority.ALWAYS);
        HBox.setHgrow(containerRight, Priority.ALWAYS);
        
        Scene scene = new Scene(root, 854, 503);
        
        primaryStage.setTitle("HBox Layout");
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

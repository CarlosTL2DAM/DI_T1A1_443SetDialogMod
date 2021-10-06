/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_t1a1_443setdialogmod;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * 2ºDAM DI
 * @author Carlos Torres Liñán
 * 06/10/21
 */
public class DI_SetDialogModality extends Application {

    @Override
    public void start(final Stage primaryStage) {
        //Introducimos el titulo de la ventana principal
        primaryStage.setTitle("Dialog");
        //Añadimos un layout principal del que partirá el resto
        Group root = new Group();
        //Creamos una escena donde añadimos el root
        Scene scene = new Scene(root, 400, 300, Color.WHITE);

        //Seleccionamos la escena creada para que aparezca en la Ventana principal
        primaryStage.setScene(scene);
        //Mostramos la ventana principal
        primaryStage.show();

        //Creamos una nueva Stage con la clase MyDialog(definida luego)
        Stage myDialog = new MyDialog(primaryStage);
        //Ajustamos el tamaño de ventana en función del de la escena
        myDialog.sizeToScene();
        //Mostramos la ventana myDialog
        myDialog.show();

    }
}

//Creamos la clase MyDialog
class MyDialog extends Stage {
    //Constructor
    public MyDialog(Stage owner) {
        //Con super decimos que tenga las propiedades del padre, en este caso Stage
        super();
        //Decimos que esta ventana pertenece a owner (parámetro añadido)
        initOwner(owner);
        //Damos un titulo a la ventana
        setTitle("title");
        //Asignamos el tipo de Modalidad que tiene esta ventana, 
        //en este caso MODAL respecto a la aplicación
        initModality(Modality.APPLICATION_MODAL);
        
        //Creamos nodo root 
        Group root = new Group();
        //Creamos una escena
        Scene scene = new Scene(root, 250, 150, Color.WHITE);
        //Establecemos la escena como escena de la ventana
        setScene(scene);

        //Definimos un gridPane donde añadiremos los componentes, con paddin, HGap y VGap 5
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(5);
        gridpane.setVgap(5);

        //Creamos etiqueta y la añadimos al gridPane
        Label userNameLbl = new Label("User Name: ");
        gridpane.add(userNameLbl, 0, 1);

        //Creamos etiqueta y la añadimos al gridPane
        Label passwordLbl = new Label("Password: ");
        gridpane.add(passwordLbl, 0, 2);
        
        //Añadimos campo de texto y lo añadimos al gridPane
        final TextField userNameFld = new TextField("Admin");
        gridpane.add(userNameFld, 1, 1);

        //Añadimos campo de contraseña y lo añadimos al gridPane
        final PasswordField passwordFld = new PasswordField();
        passwordFld.setText("password");
        gridpane.add(passwordFld, 1, 2);

        //Añadimos botón con evento para cerrar la ventana y la añadimos al gridPane
        Button login = new Button("Change");
        login.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                close();
            }
        });
        gridpane.add(login, 1, 3);
        //Aisgnamos que la alineación horizontal del botón sea derecha
        GridPane.setHalignment(login, HPos.RIGHT);
        //Incluimos el gridPane en el root(group)
        root.getChildren().add(gridpane);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

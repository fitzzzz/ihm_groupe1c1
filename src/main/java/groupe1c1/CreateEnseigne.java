package groupe1c1;/**
 * @author Hasaghi
 * @date 06/03/2017
 */

import groupe1c1.controller.form.CreationEnseigne;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jdk.internal.util.xml.impl.Input;

import java.io.IOException;
import java.io.InputStream;

public class CreateEnseigne extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception{

		String fxmlFile = "/fxml/creerEnseigne.fxml";
		FXMLLoader loader = new FXMLLoader();
		CreationEnseigne enseigne = new CreationEnseigne();
		loader.setController(enseigne);
		VBox parent = loader.load(getClass().getResourceAsStream(fxmlFile));
		TabPane tabPane = (TabPane) parent.getChildren().get(2);
		tabPane.getTabs().get(1).setContent(loadGestionMagasin());

		Scene scene = new Scene(parent, 1210, 720);
		scene.getStylesheets().add("/styles/styles.css");
		primaryStage.setTitle("Création d'une enseigne");
		primaryStage.setScene(scene);
		primaryStage.show();
		enseigne.setStage(primaryStage);
	}

	private Node loadGestionMagasin() throws IOException {
		String fxmlFile = "/fxml/gestion-magasins.fxml";
		FXMLLoader loader = new FXMLLoader();
		return loader.load(getClass().getResourceAsStream(fxmlFile));
	}
}

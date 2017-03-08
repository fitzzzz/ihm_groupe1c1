package groupe1c1.controller.form;

import groupe1c1.model.data.Affiche;
import groupe1c1.model.data.ItemPhare;
import groupe1c1.model.data.LocatedImage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Hasaghi
 * @date 08/03/2017
 */
public class ModifyItem {

	private final Stage subStage;
	private ItemPhare item;
	@FXML
	private ImageView image;
	@FXML
	private Button modifyImage;
	@FXML
	private TextField price;
	@FXML
	private TextField name;
	@FXML
	void modifyImage(MouseEvent event) {
		System.out.println("modifie le path de l'image");
	}

	@FXML
	void save(MouseEvent event) {
		double prix = Double.parseDouble(price.getText());
		String itemName = name.getText();
		String path = ((LocatedImage) image.getImage()).getUrl();
		ItemPhare newItem = new ItemPhare(itemName,prix,path);
		subStage.close();
		enseigne.updateItem(item,newItem);

	}
	private CreationEnseigne enseigne;

	public ModifyItem(CreationEnseigne enseigne, ItemPhare item) throws IOException {
		subStage = new Stage();
		subStage.setTitle("Modifier un item");
		String fxmlFile = "/fxml/modifyItem.fxml";
		FXMLLoader loader = new FXMLLoader();
		loader.setController(this);
		VBox parent = loader.load(getClass().getResourceAsStream(fxmlFile));
		FlowPane root = new FlowPane();
		root.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root, 330, 400);
		root.getChildren().add(parent);
		subStage.setScene(scene);
		subStage.show();
		this.enseigne = enseigne;
		this.item = item;
		updateView(item);

	}
	public void updateView(ItemPhare item){
		LocatedImage img = LocatedImage.create(item.getUrl());
		image.setImage(img);
		name.setText(item.getName());
		price.setText(String.valueOf(item.getCost()));

	}
}

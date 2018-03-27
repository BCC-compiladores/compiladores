package application;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.TelaController;

@SuppressWarnings("restriction")
public class MainApplication extends Application{


	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		URL urlTela = this.getClass().getClassLoader().getResource("TelaPrincipal.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(urlTela);
		Parent mainParent = fxmlLoader.load();
		
		Scene scene = new Scene(mainParent);
		
		TelaController telaController = fxmlLoader.getController();
		telaController.setScene(scene);
		telaController.bindKeys();
		
		Stage stage = new Stage();
		stage.setHeight(620);
		stage.setWidth(900);
		stage.sizeToScene();
		stage.setMinHeight(620);
		stage.setMinWidth(900);
		stage.setScene(scene);
		stage.setResizable(true);
		stage.setTitle("Compilador");
		
		telaController.setStage(stage);

		stage.show();

		
	}
}


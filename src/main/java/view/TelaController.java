package view;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.stage.Stage;

import utils.FileUtils;
import utils.Messages;

@SuppressWarnings("restriction")
public class TelaController implements Initializable {

	@FXML private Button btnNew;
	@FXML private Button btnOpen;
	@FXML private Button btnSave;
	@FXML private Button btnCopy;
	@FXML private Button btnPaste;
	@FXML private Button btnCut;
	@FXML private Button btnCompile;
	@FXML private Button btnAbout;
	@FXML private TextArea txtArea;
	@FXML private TextArea txtStatusBar;
	@FXML private Label lblBarraStatus;
	
	private Scene scene;
	private Stage stage;
	private File currentFile;

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		styleButtons();
	}

	@FXML
	public void btnNewOnClick() {
		txtArea.clear();
		txtStatusBar.clear();
		lblBarraStatus.setText("");
	}

	@FXML
	public void btnOpenOnClick() throws IOException {

		File selectedFile = FileUtils.getFileChooser().showOpenDialog(stage);

		if(Objects.isNull(selectedFile)){
			return;
		}

		this.currentFile = selectedFile;
		txtStatusBar.clear();
		txtArea.setText(FileUtils.readFile(currentFile));
		lblBarraStatus.setText(currentFile.getPath() + " | " + currentFile.getName());
	}
	
	@FXML
	public void btnSaveOnClick() {
		
	}
	@FXML
	public void btnCopyOnClick() {
		txtArea.copy();
	}
	@FXML
	public void btnPasteOnClick() {
		txtArea.paste();
	}

	@FXML
	public void btnCutOnClick() {
        txtArea.cut();
	}

    @FXML
	public void btnCompileOnClick(ActionEvent e) {
		txtStatusBar.setText(Messages.NOT_YET_IMPLEMENTED.get());
	}
	
	@FXML
	public void btnAboutOnClick() {
		txtStatusBar.setText(Messages.MEMBERS.get());
	}
	
	private void styleButtons() {

		btnNew.setContentDisplay(ContentDisplay.TOP);
		btnNew.setGraphic(getImageFromResources("new"));
		
		btnOpen.setContentDisplay(ContentDisplay.TOP);
		btnOpen.setGraphic(getImageFromResources("open"));
		
		btnSave.setContentDisplay(ContentDisplay.TOP);
		btnSave.setGraphic(getImageFromResources("save"));
		
		btnCopy.setContentDisplay(ContentDisplay.TOP);
		btnCopy.setGraphic(getImageFromResources("copy"));
		
		btnPaste.setContentDisplay(ContentDisplay.TOP);
		btnPaste.setGraphic(getImageFromResources("paste"));
		
		btnCut.setContentDisplay(ContentDisplay.TOP);
		btnCut.setGraphic(getImageFromResources("cut"));
		
		btnCompile.setContentDisplay(ContentDisplay.TOP);
		btnCompile.setGraphic(getImageFromResources("compile"));
		
		btnAbout.setContentDisplay(ContentDisplay.TOP);
		btnAbout.setGraphic(getImageFromResources("about"));
	}

	public void bindKeys() {
		
		setKeyCombinationListener(btnNew, KeyCode.N);
		setKeyCombinationListener(btnOpen, KeyCode.O);
		setKeyCombinationListener(btnSave, KeyCode.S);
		setKeyCombinationListener(btnCopy, KeyCode.C);
		setKeyCombinationListener(btnPaste, KeyCode.V);
		setKeyCombinationListener(btnCut, KeyCode.X);

		setKeyListener(btnAbout, KeyCode.F1);
		setKeyListener(btnCompile, KeyCode.F9);
	}

	/**
	 * Bind into scene when the event is a single key press
	 */
	private void setKeyListener(Button b, KeyCode k) {
		scene.addEventFilter(KeyEvent.KEY_PRESSED, ke -> {
			if (ke.getCode() == k) {
				b.fire();
			}
		});
	}

	private void setKeyCombinationListener(Button btn, KeyCode key) {
		btn.getScene().getAccelerators().put(new KeyCodeCombination(key, KeyCombination.CONTROL_DOWN),
				() -> btn.fire());
	}

	private ImageView getImageFromResources(String imgName){
		return new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("imagens/" + imgName + ".png")));
	}
}

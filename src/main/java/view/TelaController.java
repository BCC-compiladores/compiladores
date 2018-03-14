package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.*;

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
	
	private Scene scene;
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		styleButtons();
	}

	
	public ImageView getImageFromResources(String imgName){
		return new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("imagens/" + imgName + ".png")));
	}
	
	@FXML
	public void btnNewOnClick() {
		
	}
	@FXML
	public void btnOpenOnClick() {
		
	}
	@FXML
	public void btnSaveOnClick() {
		
	}
	@FXML
	public void btnCopyOnClick() {
        copyTextToClipboard();
	}
	@FXML
	public void btnPasteOnClick() {
	    txtArea.appendText(Clipboard.getSystemClipboard().getString());
	}

	@FXML
	public void btnCutOnClick() {
        copyTextToClipboard();
        txtArea.clear();
	}

    /**
     * Copies the content of {@code txtArea} to the clipboard
     */
    private void copyTextToClipboard() {
        final ClipboardContent content = new ClipboardContent();
        content.putString(txtArea.getText());
        Clipboard.getSystemClipboard().setContent(content);
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

		//Bind directly into the button when there is a key combination

		btnNew.getScene().getAccelerators().put(
				new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN),
				() -> btnNew.fire()
		);

		btnOpen.getScene().getAccelerators().put(
				new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN),
				() -> btnOpen.fire()
		);

		btnSave.getScene().getAccelerators().put(
				new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN),
				() -> btnSave.fire()
		);

		btnCopy.getScene().getAccelerators().put(
				new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN),
				() -> btnCopy.fire()
		);

		btnPaste.getScene().getAccelerators().put(
				new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN),
				() -> btnPaste.fire()
		);

		btnCut.getScene().getAccelerators().put(
				new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN),
				() -> btnCut.fire()
		);


		//Bind into scene when the event is a single key press
		scene.addEventFilter(KeyEvent.KEY_PRESSED, ke -> {
            if (ke.getCode() == KeyCode.F1) {
                btnAbout.fire();
            }
        });
		
		scene.addEventFilter(KeyEvent.KEY_PRESSED, ke -> {
            if (ke.getCode() == KeyCode.F9) {
                btnCompile.fire();
            }
        });
	}
}

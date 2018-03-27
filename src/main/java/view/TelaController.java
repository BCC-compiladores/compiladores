package view;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.control.*;

import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.GenericStyledArea;
import org.fxmisc.richtext.LineNumberFactory;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;

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
	@FXML private CodeArea txtArea;
	@FXML private TextArea txtMessageArea;
	@FXML private Label lblBarraStatus;
	@FXML private VirtualizedScrollPane<CodeArea> txtAreaPane;
	@FXML private ScrollPane scrollPaneText;
	
	private Scene scene;
	private Stage stage;
	private File currentFile;

	public void setScene(Scene scene) {
		this.scene = scene;
		
	}

	public void setStage(Stage stage) {
		this.stage = stage;
		bindResize();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		styleButtons();
		txtMessageArea.setEditable(false);
		txtArea.setParagraphGraphicFactory(LineNumberFactory.get(txtArea));
		txtAreaPane.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		txtAreaPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);

	}
	public void bindResize() {
		
		stage.widthProperty().addListener((obs, oldV, newV) -> {
			txtAreaPane.setMinWidth(newV.doubleValue() - 160);
			scrollPaneText.setMinWidth(newV.doubleValue() - 160);
			lblBarraStatus.setMinWidth(newV.doubleValue() - 160);
		});

		stage.heightProperty().addListener((obs, oldV, newV) -> {
			txtAreaPane.setMinHeight(newV.doubleValue() - 180);
			scrollPaneText.setLayoutY(newV.doubleValue() - (scrollPaneText.heightProperty().doubleValue() + lblBarraStatus.heightProperty().doubleValue() + 42));
			lblBarraStatus.setLayoutY(newV.doubleValue() - (lblBarraStatus.heightProperty().doubleValue() + 35));
		});
	}
	@FXML
	public void btnNewOnClick() {
	    currentFile = null;
		txtArea.clear();
		txtMessageArea.clear();
		lblBarraStatus.setText("");
		
	}

	@FXML
	public void btnOpenOnClick() throws IOException {

		File selectedFile = FileUtils.getFileChooser().showOpenDialog(stage);

		if(Objects.isNull(selectedFile)){
			return;
		}

		this.currentFile = selectedFile;
		txtMessageArea.clear();
		txtArea.clear();
		txtArea.appendText(FileUtils.readFile(currentFile));
        updateFileLabel();
    }

    private void updateFileLabel() {
	    if(Objects.isNull(currentFile)){
            lblBarraStatus.setText("");
        }else{
            lblBarraStatus.setText(currentFile.getPath() + " | " + currentFile.getName());
        }
    }

    @FXML
	public void btnSaveOnClick() throws IOException {

	    if(Objects.isNull(currentFile)){
            File selectedFile = FileUtils.getFileChooser().showSaveDialog(stage);

            if(Objects.isNull(selectedFile)){
                return;
            }

            currentFile = selectedFile;
        }

        FileUtils.writeToFile(txtArea.getText(), currentFile);

        updateFileLabel();
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
	public void btnCompileOnClick() {
    	txtMessageArea.setText(Messages.NOT_YET_IMPLEMENTED.get());
	}
	
	@FXML
	public void btnAboutOnClick() {
		txtMessageArea.setText(Messages.MEMBERS.get());
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
				btn::fire);
	}

	private ImageView getImageFromResources(String imgName){
		return new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("imagens/" + imgName + ".png")));
	}
}

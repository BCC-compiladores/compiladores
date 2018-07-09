package view;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;
import org.reactfx.Subscription;

import gals.ConvertIdToClass;
import gals.LexicalError;
import gals.Lexico;
import gals.SemanticError;
import gals.Semantico;
import gals.Sintatico;
import gals.SyntaticError;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
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
	@FXML private CodeArea codeArea;
	@FXML private TextArea txtMessageArea;
	@FXML private Label lblBarraStatus;
	@FXML private VirtualizedScrollPane<CodeArea> txtAreaPane;
	@FXML private ScrollPane scrollPaneText;
	
	private Scene scene;
	private Stage stage;
	private File currentFile;

	private static final String[] KEYWORDS = {
			"bool", "consts", "def", "end", "execute", "false", "float", "get", "ifFalse", "ifTrue", "input", "int", "print", "println", "set", "str", "true", "types", "var", "whileFalse", "whileTrue"	
	};
	
    private static final String KEYWORD_PATTERN = "\\b(" + String.join("|", KEYWORDS) + ")\\b";
    private static final String PAREN_PATTERN = "\\(|\\)";
    private static final String BRACE_PATTERN = "\\{|\\}";
    private static final String BRACKET_PATTERN = "\\[|\\]";
    private static final String SEMICOLON_PATTERN = "\\;";
    private static final String STRING_PATTERN = "\"([^\"\\\\]|\\\\.)*\"";
    private static final String COMMENT_PATTERN = "//[^\n]*" + "|" + "/\\*(.|\\R)*?\\*/";
    
    private static final Pattern PATTERN = Pattern.compile(
            "(?<KEYWORD>" + KEYWORD_PATTERN + ")"
            + "|(?<PAREN>" + PAREN_PATTERN + ")"
            + "|(?<BRACE>" + BRACE_PATTERN + ")"
            + "|(?<BRACKET>" + BRACKET_PATTERN + ")"
            + "|(?<SEMICOLON>" + SEMICOLON_PATTERN + ")"
            + "|(?<STRING>" + STRING_PATTERN + ")"
            + "|(?<COMMENT>" + COMMENT_PATTERN + ")"
    );
	
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
		codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
		txtAreaPane.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		txtAreaPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		
		
	  Subscription cleanupWhenNoLongerNeedIt = codeArea

	                // plain changes = ignore style changes that are emitted when syntax highlighting is reapplied
	                // multi plain changes = save computation by not rerunning the code multiple times
	                //   when making multiple changes (e.g. renaming a method at multiple parts in file)
	                .multiPlainChanges()

	                // do not emit an event until 500 ms have passed since the last emission of previous stream
	                .successionEnds(Duration.ofMillis(500))

	                // run the following code block when previous stream emits an event
	                .subscribe(ignore -> codeArea.setStyleSpans(0, computeHighlighting(codeArea.getText())));

	        // when no longer need syntax highlighting and wish to clean up memory leaks
	        // run: `cleanupWhenNoLongerNeedIt.unsubscribe();`
		

	}
	private void bindResize() {
		
		stage.widthProperty().addListener((obs, oldV, newV) -> {
			txtAreaPane.setMinWidth(newV.doubleValue() - 160);
			scrollPaneText.setMinWidth(newV.doubleValue() - 160);
			txtMessageArea.setMinWidth(newV.doubleValue() - 160);
			lblBarraStatus.setMinWidth(newV.doubleValue() - 160);
		});

		stage.heightProperty().addListener((obs, oldV, newV) -> {
			txtAreaPane.setMinHeight(newV.doubleValue() - 180);
			scrollPaneText.setLayoutY(newV.doubleValue() - (scrollPaneText.heightProperty().doubleValue() + lblBarraStatus.heightProperty().doubleValue() + 42));
			txtMessageArea.setLayoutY(newV.doubleValue() - (txtMessageArea.heightProperty().doubleValue() + txtMessageArea.heightProperty().doubleValue() + 42));
			lblBarraStatus.setLayoutY(newV.doubleValue() - (lblBarraStatus.heightProperty().doubleValue() + 35));
		});
	}
	@FXML
	public void btnNewOnClick() {
	    currentFile = null;
		codeArea.clear();
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
		codeArea.clear();
		codeArea.appendText(FileUtils.readFile(currentFile));
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

        FileUtils.writeToFile(codeArea.getText(), currentFile);
        txtMessageArea.clear();
        updateFileLabel();
    }
	@FXML
	public void btnCopyOnClick() {
		codeArea.copy();
	}
	@FXML
	public void btnPasteOnClick() {
		codeArea.paste();
	}

	@FXML
	public void btnCutOnClick() {
        codeArea.cut();
	}

    @FXML
	public void btnCompileOnClick() {

        txtMessageArea.clear();

        if(codeArea.getText().trim().isEmpty()){
            txtMessageArea.appendText(Messages.EMPTY_PROGRAM.get());
        } else {

            Lexico lexico = new Lexico();
            lexico.setInput(codeArea.getText());

            Sintatico sintatico = new Sintatico();
            Semantico semantico = new Semantico();

            try {
				if(currentFile == null) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Compilador");
					alert.setContentText("É necessário salvar o arquivo antes de compilar!");
					alert.showAndWait();
					return;
				}

            	sintatico.parse(lexico, semantico);
            	txtMessageArea.setText("Programa compilado com sucesso");
				Path generatedCodePath = Paths.get(currentFile.getPath().replace(".txt", ".il"));
				Files.write(generatedCodePath, semantico.getCodigo().getBytes());

            }
            catch (SyntaticError e) {
            	String errorMessage = "Erro na linha %s - encontrado %s %s";
            	if (Arrays.asList(1, 3, 4, 5).contains(e.getToken().getId())) {
            		txtMessageArea.appendText(String.format(errorMessage, getLineByPosition(e.getPosition()), ConvertIdToClass.getClassFromID(e.getToken().getId()), e.getMessage()));
            	}	
            	else {
            		txtMessageArea.appendText(String.format(errorMessage, getLineByPosition(e.getPosition()), e.getToken().getLexeme(), e.getMessage()));
            	}
            }
            catch (LexicalError e) {
            	String errorMessage = "Erro na linha %s - %s %s";
                if (e.getMessage().contains("simbolo inválido")) {
                    errorMessage = String.format(errorMessage, getLineByPosition(e.getPosition()), e.getWord(), e.getMessage());
                }
                txtMessageArea.appendText(String.format(errorMessage, getLineByPosition(e.getPosition()), "", e.getMessage()));
            }
            catch (SemanticError err ) {
                txtMessageArea.appendText(err.getMessage());
            } catch (IOException e) {
				System.out.println(e);
			}
		}
	}

	private String getLineByPosition(int position) {
		String content = codeArea.getText();
		int newLineQty = 0;
		for (int i = 0; i < content.length(); i++) {
			if (i == position) {
				break;
			}
			if(content.charAt(i) == '\n'){
				newLineQty++;
			}
		}

		return String.valueOf(newLineQty+1);
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

    public static String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s);
    }
    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }
    
    
    private static StyleSpans<Collection<String>> computeHighlighting(String text) {
        Matcher matcher = PATTERN.matcher(text);
        int lastKwEnd = 0;
        StyleSpansBuilder<Collection<String>> spansBuilder
                = new StyleSpansBuilder<>();
        while(matcher.find()) {
            String styleClass =
                    matcher.group("KEYWORD") != null ? "keyword" :
                    matcher.group("PAREN") != null ? "paren" :
                    matcher.group("BRACE") != null ? "brace" :
                    matcher.group("BRACKET") != null ? "bracket" :
                    matcher.group("SEMICOLON") != null ? "semicolon" :
                    matcher.group("STRING") != null ? "string" :
                    matcher.group("COMMENT") != null ? "comment" :
                    null; /* never happens */ assert styleClass != null;
            spansBuilder.add(Collections.emptyList(), matcher.start() - lastKwEnd);
            spansBuilder.add(Collections.singleton(styleClass), matcher.end() - matcher.start());
            lastKwEnd = matcher.end();
        }
        spansBuilder.add(Collections.emptyList(), text.length() - lastKwEnd);
        return spansBuilder.create();
    }
}

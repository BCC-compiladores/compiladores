package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

@SuppressWarnings("restriction")
public class FileUtils {

    public static FileChooser getFileChooser() {
        FileChooser f = new FileChooser();
        f.getExtensionFilters().addAll(new ExtensionFilter("Arquivos de texto", "*.txt"));
        f.setTitle("Selecione um arquivo");
        return f;
    }

	public static String readFile(File selectedFile) throws IOException {
        StringBuilder sb = new StringBuilder();
        for(String s : Files.readAllLines(Paths.get(selectedFile.toString()))){
            sb.append(s).append(System.getProperty("line.separator"));
        }
        return sb.toString();
	}

    public static void writeToFile(String string, File file) throws IOException {
        try (
                BufferedReader reader = new BufferedReader(new StringReader(string));
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
        ) {
            reader.lines().forEach(writer::println);
        }
    }
}
package test;

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class OPEN_DIR extends Application {

	@Override
	public void start(final Stage primaryStage) {
		Button btn = new Button();
		btn.setText("ディレクトリ選択");

		final DirectoryChooser fc = new DirectoryChooser();
		fc.setTitle("ディレクトリ選択");

		final Label label = new Label();

		// ボタンを押した時、ラベルにパスを保持する。
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				File importFile = fc.showDialog(primaryStage);

				if (importFile != null) {
					label.setText(importFile.getPath().toString());
				}
			}
		});

		VBox vbox = new VBox();
		vbox.getChildren().addAll(btn, label);

		StackPane root = new StackPane();
		root.getChildren().addAll(vbox);

		Scene scene = new Scene(root, 300, 250);

		primaryStage.setTitle("フォルダ選択ダイアログ"); // タイトル
		primaryStage.setScene(scene); // ルートフォルダ
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

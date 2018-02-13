package test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OPEN_DIALOG extends JFrame implements ActionListener {

	JLabel label;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OPEN_DIALOG frame = new OPEN_DIALOG();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(10, 10, 300, 200);
		frame.setTitle("指定フォルダからフォルダを選択していくよ");
		frame.setVisible(true);
	}

	OPEN_DIALOG() {
		JButton button = new JButton("ファイル選択");
		button.addActionListener(this);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(button);

		label = new JLabel();

		JPanel labelPanel = new JPanel();
		labelPanel.add(label);

		getContentPane().add(labelPanel, BorderLayout.CENTER);
		getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
	}

	public void actionPerformed(ActionEvent e) {
		JFileChooser filechooser = new JFileChooser();
		
		int selected = filechooser.showOpenDialog(this);
		if (selected == JFileChooser.APPROVE_OPTION) {
			File file = filechooser.getSelectedFile();
			label.setText(file.getName());
		} else if (selected == JFileChooser.CANCEL_OPTION) {
			label.setText("キャンセルされました");
		} else if (selected == JFileChooser.ERROR_OPTION) {
			label.setText("エラー又は取消しがありました");
		}
	}
}

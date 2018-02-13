package swing.sample;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * ToDoリスト
 */
public class TodoListPane extends JPanel {

	private JList toDoList;
	private DefaultListModel toDoListModel;
	private JTextField toDoInputField;
	private JButton addButton;
	private JButton modifyButton;
	private JButton removeButton;

	public TodoListPane() {
		super(new BorderLayout());
		// 一覧を生成
		toDoListModel = new DefaultListModel();
		toDoList = new JList(toDoListModel);
		JScrollPane listScrollPane = new JScrollPane(toDoList);
		// TODOリストにリスナを設定
		toDoList.addListSelectionListener(new ToDoListSelectionHandler());
		// ToDo追加用テキストフィールドの生成
		toDoInputField = new JTextField();
		// 各ボタンの生成
		JPanel buttonPanel = new JPanel();
		addButton = new JButton("追加");
		modifyButton = new JButton("編集");
		removeButton = new JButton("削除");
		// ボタンにリスナを設定
		addButton.addActionListener(new AddActionHandler());
		modifyButton.addActionListener(new ModifyActionHandler());
		removeButton.addActionListener(new RemoveActionHandler());
		buttonPanel.add(addButton);
		buttonPanel.add(modifyButton);
		buttonPanel.add(removeButton);
		add(listScrollPane, BorderLayout.NORTH);
		add(toDoInputField, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	/**
	 * TODOリスト選択アクションのハンドラ
	 */
	private class ToDoListSelectionHandler implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			// TODOリストのどの行も選択されていない場合や、
			// 複数行が選択されている場合は、
			// 何もしません
			if (toDoList.getSelectedIndices().length != 1) {
				return;
			}
			toDoInputField.setText((String) toDoList.getSelectedValue());
		}
	}

	/**
	 * 追加ボタンアクションのハンドラ
	 */
	private class AddActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// テキストフィールドの内容をリストモデルに追加
			toDoListModel.addElement(toDoInputField.getText());
		}
	}

	/**
	 * 編集ボタンアクションのハンドラ
	 */
	private class ModifyActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// テキストフィールドの内容でリストモデルを編集
			// TODOリストのどの行も選択されていない場合や、
			// 複数行が選択されている場合は、
			// 何もしません
			if (toDoList.getSelectedIndices().length != 1) {
				return;
			}
			toDoListModel.set(toDoList.getSelectedIndex(), toDoInputField.getText());
		}
	}

	/**
	 * 削除ボタンアクションのハンドラ
	 */
	private class RemoveActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// テキストフィールドの内容をリストモデルに追加
			// TODOリストのどの行も選択されていない場合や、
			// 複数行が選択されている場合は、
			// 何もしません
			if (toDoList.getSelectedIndices().length != 1) {
				return;
			}
			setButtonsEnabled(false);
			Thread removeThread = new RemoveThread(toDoList.getSelectedIndex());
			removeThread.start();
		}
	}

	/**
	 * ボタンの状態を更新します
	 */
	private void setButtonsEnabled(boolean enabled) {
		addButton.setEnabled(enabled);
		modifyButton.setEnabled(enabled);
		removeButton.setEnabled(enabled);
	}

	/**
	 * 削除処理を行うクラス
	 */
	class RemoveThread extends Thread {
		int index;

		RemoveThread(int index) {
			this.index = index;
		}

		public void run() {
			// 時間のかかる処理を実行
			doLongTask();
			// イベントディスパッチスレッドで
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					toDoListModel.remove(index);
					setButtonsEnabled(true);
				}
			});
		}
	}

	/**
	 * 時間のかかる処理
	 */
	private void doLongTask() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException ex) {
		}
	}
}
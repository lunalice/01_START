package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateUserLogic {
	public boolean doCheck(String name, String pass) {
		// ユーザー確認の実行
		String sql = "SELECT * FROM USERS WHERE NAME = '" + name + "' AND PASS = '" + pass + "'";
		System.out.println(sql);
		// ユーザー登録画面
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.37.133:1521:XE", "TUBU", "TUBU");
			// ステートメントを作成
			Statement stmt = conn.createStatement();
			// 結果確保
			ResultSet result = stmt.executeQuery(sql);
			while (result.next()) {
				// ユニーク確認
				if (result.getString(1).equals(name) && result.getString(2).equals(pass)) {
					// ステートメントをクローズ
					stmt.close();
					// 接続をクローズ
					conn.close();
					// ダメニャー
					return false;
				}
			}
			// ステートメントをクローズ
			stmt.close();
			// 接続をクローズ
			conn.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return true;
	}
}

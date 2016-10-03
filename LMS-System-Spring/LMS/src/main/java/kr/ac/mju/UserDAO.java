package kr.ac.mju;

import java.sql.SQLException;

public class UserDAO extends DAO {
	// 회원가입함
	public void insert(CUser user) {
		String query = "INSERT INTO user "
				+ "(id, pw, name, type) VALUES (?, ?, ?, ?)";
		connection = null;

		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, user.getID());
			statement.setString(2, user.getPw());
			statement.setString(3, user.getName());
			statement.setString(4, user.getType());
			statement.executeUpdate();
			statement.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			disconnect();
		}
	}
	// 로그인 아이디 입력창에 입력한 아이디에 대한 정보를 가져옴
	public CUser search(VLogin vLogin) {
		String query = "SELECT * FROM user WHERE id=?";
		CUser user = new CUser("","","","");

		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, vLogin.getID());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String pw = resultSet.getString("pw");
				String name = resultSet.getString("name");
				String type = resultSet.getString("type");
				user = new CUser(id, pw, name, type);
			}
			return user;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			disconnect();
		}
	}
}

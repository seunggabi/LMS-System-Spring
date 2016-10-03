package kr.ac.mju;

import java.sql.SQLException;
import java.util.Vector;

public class CourseDAO extends DAO {
	public void make(CCourse course) {
		String query = "INSERT INTO course "
				+ "(id, name, professor_id) VALUES (?, ?, ?)";
		connection = null;
		resultSet = null;

		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, course.getID());
			statement.setString(2, course.getName());
			statement.setString(3, course.getProfessorID());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			disconnect();
		}
	}
	public void delete(CCourse course) {
		String query = "DELETE FROM course "
				+ "WHERE id=? AND NAME=? AND professor_id=?;";
		connection = null;
		resultSet = null;

		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, course.getID());
			statement.setString(2, course.getName());
			statement.setString(3, course.getProfessorID());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			disconnect();
		}
	}
	public Vector<CCourse> list(String professorID) {
		String query = null;
		if(!professorID.equals(""))
			query = "SELECT * FROM course c JOIN user u ON c.professor_id=u.id WHERE professor_id=?";
		else
			query = "SELECT * FROM course c JOIN user u ON c.professor_id=u.id ";
		connection = null;
		resultSet = null;
		Vector<CCourse> courseVt = new Vector<CCourse>();

		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(query);
			if(!professorID.equals(""))
				statement.setString(1, professorID);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String ID = resultSet.getString("c.id");
				String name = resultSet.getString("c.name");
				String professorName = resultSet.getString("u.name");
				courseVt.add(new CCourse(ID, name, professorID, professorName));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			disconnect();
		}
		return courseVt;
	}
}

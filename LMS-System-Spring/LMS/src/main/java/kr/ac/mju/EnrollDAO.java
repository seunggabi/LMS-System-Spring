package kr.ac.mju;

import java.sql.SQLException;
import java.util.Vector;

public class EnrollDAO extends DAO {

	public void register(CEnroll enroll) {
		String query = "INSERT INTO enroll (id, course_id) VALUES (?, ?)";
		connection = null;
		resultSet = null;

		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, enroll.getID());
			statement.setString(2, enroll.getCourseID());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			disconnect();
		}
	}

	public void cancel(CEnroll enroll) {
		String query = "DELETE FROM enroll WHERE id=? AND course_id=?";
		connection = null;
		resultSet = null;

		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, enroll.getID());
			statement.setString(2, enroll.getCourseID());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			disconnect();
		}
	}

	public boolean isRegister(String studentID, String courseID) {
		int count = 0;
		String query = "SELECT * FROM enroll WHERE id=? AND course_id=?";

		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, studentID);
			statement.setString(2, courseID);
			resultSet = statement.executeQuery();
			while (resultSet.next())
				count++;
			if (count > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			disconnect();
		}
	}

	public Vector<CEnroll> viewGradeStudent(String studentID) {
		String query = "SELECT * FROM enroll e JOIN course c ON e.course_id=c.id WHERE e.id=?";
		Vector<CEnroll> enrollList = new Vector<CEnroll>();
		
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, studentID);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String courseID = resultSet.getString("e.course_id");
				String courseName = resultSet.getString("c.name");
				String grade = resultSet.getString("e.grade");
				enrollList.add(new CEnroll(studentID, courseID, courseName, grade));
			}
			return enrollList;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			disconnect();
		}
	}
	
	public Vector<CEnroll> viewGradeProfessor(String courseID) {
		String query = "SELECT * FROM (enroll e JOIN course c ON e.course_id=c.id ) JOIN user u ON e.id=u.id WHERE e.course_id=?";
		Vector<CEnroll> enrollList = new Vector<CEnroll>();
		
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, courseID);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String studentID = resultSet.getString("e.id");
				String courseName = resultSet.getString("c.name");
				String grade = resultSet.getString("e.grade");
				String studentName = resultSet.getString("u.name");
				enrollList.add(new CEnroll(studentID, studentName, courseID, courseName, grade));
			}
			return enrollList;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			disconnect();
		}
	}

	public void updateGrade(CEnroll enroll) {
		String query = "UPDATE enroll SET grade=? WHERE id=? AND course_id=?;";
	
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, enroll.getGrade());
			statement.setString(2, enroll.getID());
			statement.setString(3, enroll.getCourseID());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			disconnect();
		}
	}
}

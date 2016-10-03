package kr.ac.mju;

import java.util.Vector;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class EnrollService {
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"Spring-Module.xml");
	EnrollDAO enrollDAO = (EnrollDAO) context.getBean("EnrollDAO");

	public void register(CEnroll enroll) {
		enrollDAO.register(enroll);
	}

	public void cancel(CEnroll enroll) {
		enrollDAO.cancel(enroll);
	}

	public boolean isRegister(String studentID, String courseID) {
		return enrollDAO.isRegister(studentID, courseID);
	}

	public Vector<CEnroll> viewGradeStudent(String studentID) {
		return enrollDAO.viewGradeStudent(studentID);
	}

	public Vector<CEnroll> viewGradeProfessor(String studentID) {
		return enrollDAO.viewGradeProfessor(studentID);
	}

	public void updateGrade(CEnroll enroll) {
		enrollDAO.updateGrade(enroll);
	}
}

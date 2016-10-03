package kr.ac.mju;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EnrollController {
	@Autowired
	private EnrollService enrollService;

	private static final Logger logger = LoggerFactory
			.getLogger(EnrollController.class);

	@RequestMapping(value = "/EnrollController/register.do", method = RequestMethod.GET)
	public String register(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		String ID = ((VUser) request.getSession().getAttribute("userSession"))
				.getID();
		String courseID = request.getParameter("courseID");
		CEnroll enroll = new CEnroll(ID, courseID);

		enrollService.register(enroll);
		return "redirect:/CourseController/viewStudent.do";
	}

	@RequestMapping(value = "/EnrollController/delete.do", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		String studentID = ((VUser) request.getSession().getAttribute(
				"userSession")).getID();
		String courseID = request.getParameter("courseID");
		CEnroll enroll = new CEnroll(studentID, courseID);

		enrollService.cancel(enroll);
		return "redirect:/CourseController/viewStudent.do";
	}

	@RequestMapping(value = "/EnrollController/viewGradeStudent.do", method = RequestMethod.GET)
	public String viewGradeStudent(HttpServletRequest request)
			throws IOException {
		request.setCharacterEncoding("utf-8");
		String studentID = ((VUser) request.getSession().getAttribute(
				"userSession")).getID();
		Vector<CEnroll> enrollList = enrollService.viewGradeStudent(studentID);

		request.getSession().setAttribute("enrollList", enrollList);
		return "student/viewGrade";
	}

	@RequestMapping(value = "/EnrollController/viewGradeProfessor.do", method = RequestMethod.GET)
	public String viewGradeProfessor(HttpServletRequest request)
			throws IOException {
		request.setCharacterEncoding("utf-8");
		String courseID = request.getParameter("courseID");
		Vector<CEnroll> enrollList = enrollService.viewGradeProfessor(courseID);

		request.getSession().setAttribute("enrollList", enrollList);
		return "professor/viewGrade";
	}

	@RequestMapping(value = "/EnrollController/updateGrade.do", method = RequestMethod.GET)
	public String updateGradeGET(HttpServletRequest request)
			throws IOException {
		request.setCharacterEncoding("utf-8");
		String courseID = request.getParameter("courseID");
		String studentID = request.getParameter("studentID");
		String studentName = request.getParameter("studentName");

		request.getSession().setAttribute("courseID", courseID);
		request.getSession().setAttribute("studentID", studentID);
		request.getSession().setAttribute("studentName", studentName);
		return "professor/updateGrade";
	}

	@RequestMapping(value = "/EnrollController/updateGrade.do", method = RequestMethod.POST)
	public String updateGradePOST(HttpServletRequest request)
			throws IOException {
		request.setCharacterEncoding("utf-8");
		String courseID = request.getParameter("courseID");
		String studentID = request.getParameter("studentID");
		String studentName = request.getParameter("studentName");
		String grade = request.getParameter("grade");
		CEnroll enroll = new CEnroll(studentID, studentName, courseID, "",
				grade);

		enrollService.updateGrade(enroll);
		return "redirect:/EnrollController/viewGradeProfessor.do?courseID="+courseID;
	}
}

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
public class CourseController 
{
	@Autowired
	private CourseService courseService;
	@Autowired
	private EnrollService enrollService;
	
	private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

	@RequestMapping(value = "/CourseController/make.do", method = RequestMethod.GET)
	public String makeCourse(HttpServletRequest request) throws IOException 
	{
		return "professor/makeCourse";
	}
	@RequestMapping(value = "/CourseController/make.do", method = RequestMethod.POST)
	public String makeCourseDo(HttpServletRequest request) throws IOException 
	{
		request.setCharacterEncoding("utf-8");
		String ID = request.getParameter("ID");
		String name = request.getParameter("name");
		String userID = ((VUser)request.getSession().getAttribute("userSession")).getID();
		CCourse course = new CCourse(ID, name, userID);
		courseService.make(course);
		return "professor/menu";
	}
	@RequestMapping(value = "/CourseController/viewProfessor.do", method = RequestMethod.GET)
	public String viewCourseProfessor(HttpServletRequest request) throws IOException 
	{
		request.setCharacterEncoding("utf-8");
		String userID = ((VUser)request.getSession().getAttribute("userSession")).getID();
		request.getSession().setAttribute("courseList", courseService.list(userID));
		return "professor/viewCourse";
	}
	@RequestMapping(value = "/CourseController/viewStudent.do", method = RequestMethod.GET)
	public String viewCourseStudent(HttpServletRequest request) throws IOException 
	{
		Vector<CCourse> courseList = courseService.list("");
		for (CCourse course : courseList) {
			boolean isRegister = enrollService.isRegister(((VUser)request.getSession().getAttribute("userSession")).getID(), course.getID());
			course.setRegister(isRegister);
		}
		request.setCharacterEncoding("utf-8");
		request.getSession().setAttribute("courseList", courseList);
		return "student/viewCourse";
	}
	@RequestMapping(value = "/CourseController/delete.do", method = RequestMethod.GET)
	public String deleteCourse(HttpServletRequest request) throws IOException 
	{
		request.setCharacterEncoding("utf-8");
		String ID = request.getParameter("ID");
		String name = request.getParameter("name");
		String userID = ((VUser)request.getSession().getAttribute("userSession")).getID();
		CCourse course = new CCourse(ID, name, userID);
		courseService.delete(course);
		return "redirect:/CourseController/viewProfessor.do";
	}
	@RequestMapping(value = "/CourseController/viewGradeCourse.do", method = RequestMethod.GET)
	public String viewGradeCourse(HttpServletRequest request) throws IOException 
	{
		request.setCharacterEncoding("utf-8");
		String userID = ((VUser)request.getSession().getAttribute("userSession")).getID();
		request.getSession().setAttribute("courseList", courseService.list(userID));
		return "professor/viewGradeCourse";
	}
}

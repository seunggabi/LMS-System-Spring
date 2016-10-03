package kr.ac.mju;

import java.util.Vector;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CourseService 
{
	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	CourseDAO courseDAO = (CourseDAO) context.getBean("CourseDAO");

	public void make(CCourse course)
	{
		courseDAO.make(course);
	}
	public Vector<CCourse> list(String professorID)
	{
		return courseDAO.list(professorID);
	}
	public void delete(CCourse course)
	{
		courseDAO.delete(course);
	}
}


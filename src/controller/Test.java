package controller;

import org.hibernate.Session;

import orm.Course;
import orm.CourseDAO;
import orm.Student;
import orm.StudentDAO;

import com.opensymphony.xwork2.ActionSupport;

public class Test extends ActionSupport{
	
	@Override
	public String execute() throws Exception {
		Student stu1 = new Student("liuchuang", "Male");
		Student stu2 = new Student("hongyan", "Female");
		Course c1 = new Course(stu1,"C++","C++ Primer");
		Course c2 = new Course(stu1,"Java SE","Java SE Core");
		Course c3 = new Course(stu1,"MongoDB","DataBase");
		Course c4 = new Course(stu2,"Java EE","Java Web");
		stu1.getCourses().add(c1);
		stu1.getCourses().add(c2);
		stu1.getCourses().add(c3);
		stu2.getCourses().add(c4);
		StudentDAO dao = new StudentDAO();
		Session stuSession = dao.getSession();
		stuSession.beginTransaction();
		dao.attachDirty(stu1);
		dao.attachDirty(stu2);
		stuSession.getTransaction().commit();
		stuSession.close();
		
//		CourseDAO courseDAO = new CourseDAO();
//		courseDAO.getSession().beginTransaction();
//		courseDAO.attachDirty(c1);
//		courseDAO.attachDirty(c2);
//		courseDAO.attachDirty(c3);
//		courseDAO.attachDirty(c4);
//		courseDAO.getSession().getTransaction().commit();
//		courseDAO.getSession().close();
		return SUCCESS;
	}
}

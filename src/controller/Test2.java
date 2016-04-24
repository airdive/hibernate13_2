package controller;

import java.util.List;

import orm.Student;
import orm.StudentDAO;

import com.opensymphony.xwork2.ActionSupport;

public class Test2 extends ActionSupport {
	
	
	public String execute(){
		StudentDAO stuDao = new StudentDAO();
		stuDao.getSession().beginTransaction();
		@SuppressWarnings("unchecked")
		List<Student> list = stuDao.getSession().createQuery("from Student as s where s.stuname='liuchuang' order by s.id desc")
				.list();
		for (Student student : list) {
			System.out.println(student.getStuname()+","+student.getId());
		}
		stuDao.getSession().getTransaction().commit();
		stuDao.getSession().close();
		return SUCCESS;
	}
}

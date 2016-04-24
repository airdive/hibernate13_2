package controller;

import java.util.List;

import org.hibernate.Query;

import orm.Student;
import orm.StudentDAO;

import com.opensymphony.xwork2.ActionSupport;

public class Test5 extends ActionSupport {
	
	
	public String execute(){
		StudentDAO stuDao = new StudentDAO();
		stuDao.getSession().beginTransaction();
		Query query = stuDao.getSession().createQuery("from Student as s where s.stuname=:stuname order by s.id desc");
		query.setString("stuname", "liuchuang");
		@SuppressWarnings("unchecked")
		List<Student> list = query.list();
		for (Student student : list) {
			System.out.println(student.getId()+","+student.getStuname());
		}
		stuDao.getSession().getTransaction().commit();
		stuDao.getSession().close();
		return SUCCESS;
	}
}

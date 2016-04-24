package controller;

import java.util.List;

import org.hibernate.Query;

import orm.Student;
import orm.StudentDAO;

import com.opensymphony.xwork2.ActionSupport;

public class Test6 extends ActionSupport {
	
	
	public String execute(){
		UserinfoParam param = new UserinfoParam();
		param.setUsernameValue("liuchuang");
		param.setAgeValue(25);
		StudentDAO stuDao = new StudentDAO();
		stuDao.getSession().beginTransaction();
		Query query = stuDao.getSession().createQuery("from Userinfo as u where u.username like :usernameValue and u.age=:ageValue order by u.id desc");
		query.setProperties(param);
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

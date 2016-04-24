package controller;

import java.util.Iterator;
import java.util.List;

import orm.Student;
import orm.StudentDAO;

import com.opensymphony.xwork2.ActionSupport;

public class Test3 extends ActionSupport {
	
	
	public String execute(){
		StudentDAO stuDao = new StudentDAO();
		stuDao.getSession().beginTransaction();
		@SuppressWarnings("unchecked")
		Iterator<Student> it = stuDao.getSession().createQuery("from Student as s where s.stuname='liuchuang' order by s.id desc")
				.iterate();
		while(it.hasNext()){
			Student stu = it.next();
			System.out.println(stu.getId()+","+stu.getStuname());
		}
		stuDao.getSession().getTransaction().commit();
		stuDao.getSession().close();
		return SUCCESS;
	}
}

package cgginterns.hibernate.map2;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory fact=new Configuration().configure().buildSessionFactory();
		Session s=fact.openSession();
		Project  p1 = new Project();
		p1.setProjectId(11);
		p1.setProjectName("Library Management");
		Project  p2 = new Project();
		p2.setProjectId(22);
		p2.setProjectName("ChatBot");
		
		Employee  e1 = new Employee();
		e1.seteId(1);
		e1.seteName("abc");
		Employee  e2 = new Employee();
		e2.seteId(2);
		e2.seteName("def");
		
		ArrayList<Employee> emplist = new ArrayList<>();
		emplist.add(e1);
		emplist.add(e2);
		
		ArrayList<Project> prolist = new ArrayList<>();
		prolist.add(p1);
		prolist.add(p2);
		
		e1.setProjects(prolist);
		p2.setEmployees(emplist);
		
		
		Transaction transaction = s.beginTransaction();
		
		s.save(e1);
		s.save(e2);
		s.save(p1);
		s.save(p2);
		
		transaction.commit();
		Employee  emp = s.get(Employee.class,1);
		System.out.println(emp.geteName());
		for (Project project : emp.getProjects()) {
			System.out.println(project.getProjectName());
		}
		System.out.println("------------------------------");
		Project  pro = s.get(Project.class,22);
		System.out.println(pro.getProjectName());
		for (Employee employe : pro.getEmployees()) {
			System.out.println(employe.geteName());
		}
		s.close();
		fact.close();

	}

}

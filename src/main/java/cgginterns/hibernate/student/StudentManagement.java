package cgginterns.hibernate.student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import cgginterns.hibernate.Student;

public class StudentManagement {
    private static SessionFactory sessionFactory;

    public StudentManagement() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static void saveStudent(StudentManage student) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static StudentManage getStudentById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(StudentManage.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void updateStudent(StudentManage student) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public void updateCity(int studentId, String newCity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            StudentManage student = session.get(StudentManage.class, studentId);
            if (student != null) {
                student.setScity(newCity);
                session.update(student);
                transaction.commit();
            } else {
                System.out.println("Student not found with ID: " + studentId);
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateName(int studentId, String newName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            StudentManage student = session.get(StudentManage.class, studentId);
            if (student != null) {
                student.setSname(newName);
                session.update(student);
                transaction.commit();
            } else {
                System.out.println("Student not found with ID: " + studentId);
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updatePhoneNo(int studentId, String newPhoneNo) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            StudentManage student = session.get(StudentManage.class, studentId);
            if (student != null) {
                student.setSphoneno(newPhoneNo);
                session.update(student);
                transaction.commit();
            } else {
                System.out.println("Student not found with ID: " + studentId);
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public static void deleteStudent(StudentManage student) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public static void closeSessionFactory() {
        sessionFactory.close();
    }

	public static void displayAll() {
		// TODO Auto-generated method stub
		
		SessionFactory fact=new Configuration().configure().buildSessionFactory();
		 Session ses=fact.openSession();
		 
		 //HQL Syntax
		 
		 //String query="from Student where city='hyd'";
		 String query="from StudentManage";
		 Query q=ses.createQuery(query);
		 List<StudentManage> list=q.list();
		 for (StudentManage student : list) {
			System.out.println(student.getStudentid()+":"+student.getSname()+":"+student.getScity()+":"+student.getSphoneno());
		}
		 
		 ses.close();
		 fact.close();
		
	}
}


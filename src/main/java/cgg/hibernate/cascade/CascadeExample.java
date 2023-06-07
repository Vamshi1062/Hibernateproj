package cgg.hibernate.cascade;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import cgginterns.hibernate.map1.Brand;
import cgginterns.hibernate.map1.Product;

public class CascadeExample {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		 
		 Session session = factory.openSession();
		 Brand b = new Brand();
		 b.setBrandId(105);
		 b.setBrandName("Sumsung");
		 
		 Product p = new Product();
		 p.setProductId(7);
		 p.setProductName("Samsung Phone");
		 Product p1 = new Product();
		 p1.setProductId(8);
		 p1.setProductName("Samsung laptop");
		 Product p2= new Product();
		 p2.setProductId(9);
		 p2.setProductName("Samsung TV");
		 
		 ArrayList<Product> list = new ArrayList<Product>();
		 list.add(p);
		 list.add(p1);
		 list.add(p2);
		 
		 b.setProducts(list);
		 
		 Transaction  tx = session.beginTransaction();
		 
		 Query q1=session.createQuery("delete from Brand b where b.brandName=:x");
		 q1.setParameter("x","Apple");
		 int r=q1.executeUpdate();
		 System.out.println("deleted:"+r);
		 
		 session.save(b);
 		 
		 tx.commit();
		 
		 session.close();
		 factory.close();

	}

}

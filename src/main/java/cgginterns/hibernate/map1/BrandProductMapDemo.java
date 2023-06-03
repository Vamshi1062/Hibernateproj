package cgginterns.hibernate.map1;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BrandProductMapDemo {

	public static void main(String[] args) {
		 SessionFactory fact=new Configuration().configure().buildSessionFactory();
		 //creating brand objects
		 Brand b=new Brand();
		 b.setBrandId(1);
		 b.setBrandName("Tata");
		 //creating products
		 Product p=new Product();
		 p.setProductId(11);
		 p.setProductName("TataCar");
		 p.setBrand(b);
		 Product p1=new Product();
		 p1.setProductId(12);
		 p1.setProductName("Tata salt");
		 p1.setBrand(b);
		 Product p2=new Product();
		 p2.setProductId(13);
		 p2.setProductName("Tata clothes");
		 p2.setBrand(b);
		 
		 ArrayList<Product> prod=new ArrayList<>();
		 prod.add(p);
		 prod.add(p1);
		 prod.add(p2);
		 
		 b.setProducts(prod);
		 
		 Session s=fact.openSession();
		 
		 s.beginTransaction();
		 s.save(b);
		 s.save(p);
		 s.save(p1);
		 s.save(p2);
		 
		 
		 
		 
		 
		 s.getTransaction().commit();
		 //Fetching
		 Brand br=(Brand)s.get(Brand.class,1);
		System.out.println(br.getBrandId());
		System.out.println(br.getBrandName());
		for(Product prd:br.getProducts()) {
			System.out.println(prd.getProductName());
		}
		 
		 s.close();
		 fact.close();

	}

}
 
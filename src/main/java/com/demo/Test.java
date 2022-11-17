package com.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("Hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Customer customer = new Customer();
		customer.setId(101);
		customer.setName("swati");
		customer.setCity("pune");
		customer.setPincode(416101);

		
		Customer customer2 = new Customer();
		customer2.setId(102);
		customer2.setName("navita");
		customer2.setCity("kolhapur");
		customer2.setPincode(416102);
		
		OrderDetail o = new OrderDetail(101, "cloths", customer);
		OrderDetail o2 = new OrderDetail(102, "shoose", customer);
		OrderDetail o3 = new OrderDetail(103, "Acceseries", customer2);

		
		
		Set<OrderDetail> order = new HashSet<OrderDetail>();
		order.add(o);
		order.add(o2);
		order.add(o3);

		session.save(customer);
		session.save(customer2);
		session.save(o);
		session.save(o2);
		session.save(o3);

		t.commit();
		session.close();

	}

}

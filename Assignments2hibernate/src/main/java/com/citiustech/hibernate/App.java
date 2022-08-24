package com.citiustech.hibernate;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.citiustech.model.Customer;
import com.citiustech.model.Locker;
import com.citiustech.util.HibernateUtil;


public class App 
{
	public static void main(String[] args) {
	SessionFactory sf = HibernateUtil.getSessionFactory();

	Session session = sf.openSession();
	Transaction t = session.beginTransaction();
	Customer c = new Customer();
	c.setCustomerId(100);
//	c.setCustomerId(199);
	c.setCustomerName("ash");
	c.setCustomerDOB(new Date(2008, 1, 9));
	c.setCustomerAdd("hyderabad");
	c.setCustomerPhone("8776786763");
	Locker l = new Locker();
	l.setLockerId("lo105");
	l.setLockerType("large");
	l.setRent(1500);
	c.setLocker(l);

	System.out.println("Record inserted in Locker successfully");
	session.save(c); 
	System.out.println("Record inserted in Customer successfully");
	System.out.println("----------------------");
	Customer customer = session.get(Customer.class, 7003);
	
	System.out.println(customer);
	t.commit();
    session.close();

}
}

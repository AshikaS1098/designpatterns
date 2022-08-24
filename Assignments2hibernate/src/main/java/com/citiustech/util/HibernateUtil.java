package com.citiustech.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.citiustech.model.Customer;
import com.citiustech.model.Locker;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
	            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
                settings.put(Environment.URL, "jdbc:sqlserver://IMC5BCP175-MSL2;databaseName=onlineshopping;");
                 settings.put(Environment.USER, "sa");			
                settings.put(Environment.PASS, "password_123");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.SQLServer2008Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.FORMAT_SQL,"true");
                settings.put(Environment.HBM2DDL_AUTO, "update");
	                configuration.setProperties(settings);
	                configuration.addAnnotatedClass(Customer.class);
	                configuration.addAnnotatedClass(Locker.class);
	                
	                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                   .applySettings(configuration.getProperties()).build();
              sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {

            }

        }

        return sessionFactory;

    }


}

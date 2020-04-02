package com.hibernate.com.hibernate;

//import java.util.ArrayList;
//import java.util.List;
import java.util.HashMap;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class App 
{
    public static void main( String[] args )
    {
       Configuration cfg=new Configuration();
       cfg.configure("Emp-cfg.xml");
       System.out.println("Configuration Object Created Successfully");
       SessionFactory sf=cfg.buildSessionFactory();
       System.out.println("Session Factory Object is Created");
       Session s=sf.openSession();
       Transaction tx=s.beginTransaction();
       Emp e=new Emp();
       e.setId("201");
       e.setName("Haochen Liu");
       HashMap<Integer, PhoneNumber> l=new HashMap<Integer, PhoneNumber>();
       PhoneNumber ph=new PhoneNumber();
       ph.setPid("301");
       ph.setNetwork("IDEA");
       ph.setPhonenumber("9900443322");
       l.put(111, ph);
       e.setPhoneno(l);
       s.persist(e);
       tx.commit();
       s.close();
       sf.close();
    }
}

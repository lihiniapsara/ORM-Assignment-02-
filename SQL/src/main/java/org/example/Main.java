package org.example;

import Config.FactoryConfiguration;
import Entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        NativeQuery query=session.createNativeQuery("select * from customer");
        //insert,update,delete,SearchBy
        query.addEntity(Customer.class);
        List<Customer> customerList=query.list();
        for (Customer customer:customerList){
            System.out.println(customer);
        }

        //  Join Query (between Address and Customer)
        Query query1 = session.createQuery(
                "SELECT a.id, a.no, a.street, a.city, c.name FROM Address a INNER JOIN a.customer c"
        );
        List<Object[]> resultList = query1.list();
        for (Object[] row : resultList) {
            System.out.println("Address ID: " + row[0] + ", Street: " + row[2] + ", City: " + row[3] + ", Customer Name: " + row[4]);
        }

        transaction.commit();
        session.close();
    }
}
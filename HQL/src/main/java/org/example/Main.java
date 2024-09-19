package org.example;

import Config.FactoryConfiguration;
import Entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        //all data from customer

        /*Query query = session.createQuery("from  Customer");
        List<Customer> customerList=query.list();
        for (Customer customer:customerList){
            System.out.println(customer.getId());
        }*/

        //unique one data from customer
       /* Query query1 = session.createQuery("from Customer where id = ?1");
        query1.setParameter(1,"1");
        Customer customer= (Customer) query1.uniqueResult();
            System.out.println(customer.getId());*/


        //load only one column
       /* Query query = session.createQuery("select id from Customer where id = ?1");
        query.setParameter(1,"1");
        Customer customer= (Customer) query.uniqueResult();
        System.out.println(customer.getId());*/


        // Fetching Data Using IN Clause
       /* Query query = session.createQuery("from Customer where id in (1,2)");
        List<Customer> customerList = query.list();
        for (Customer customer:customerList){
            System.out.println(customer.getName());
        }*/



        //Fetch specific columns from Customer
       /* Query query3 = session.createQuery("select id,name from Customer where id = ?1");
        query3.setParameter(1, "1");
        Object[] result = (Object[]) query3.uniqueResult();
        System.out.println("Customer ID: " + result[0] + ", Name: " + result[1]);
*/
        //Fetching Multiple Columns Using HQL

       /* Query query4 = session.createQuery("select id,name from Customer");
        List<Object[]> resultList = query4.list();
        for (Object[] row : resultList) {
            Integer id = (Integer) row[0];
            String name = (String) row[1];
            System.out.println("Customer ID: " + id + ", Name: " + name);
        }*/

        //Perform join query between Customer and Address
       /* Query query5 = session.createQuery("select a.id,a.no,a.street,a.city from Address a inner join Customer c on a.id=c.id");
        List<Object[]> resultList = query5.list();
        for (Object[] row : resultList) {
            System.out.println("Address ID: " + row[0] + ", No: " + row[1] + ", Street: " + row[2] + ", City: " + row[3]);
        }*/


        transaction.commit();
        session.close();
    }
}
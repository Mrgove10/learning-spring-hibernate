package org.epsi.b3.simplewebapp;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SessionFactory {
     private  void newsessionfactory(){
         org.hibernate.SessionFactory currentSession = new Configuration().configure().buildSessionFactory();

         final Transaction transaction = currentSession.beginTransaction(); try {    currentSession.save(myEntity);    transaction.commit(); } catch (RuntimeException e) {    transaction.rollback(); }


     }
}

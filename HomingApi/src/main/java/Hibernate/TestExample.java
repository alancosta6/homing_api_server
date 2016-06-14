package Hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import HomingDTO.Honey;
import Utils.SessionFactoryUtil;

public class TestExample {

  final static Logger logger = LoggerFactory.getLogger(TestExample.class);


  public static void listHoney() {
    Transaction tx = null;
    Session session = SessionFactoryUtil.getSessionFactory().openSession();
    try {
      tx = session.beginTransaction();
      List honeys = session.createQuery("select h from Honey as h")
              .list();
      for (Iterator iter = honeys.iterator(); iter.hasNext();) {
        Honey element = (Honey) iter.next();
        logger.debug("{}", element);
      }
      tx.commit();
    } catch (RuntimeException e) {
      if (tx != null && tx.isActive()) {
        try {
// Second try catch as the rollback could fail as well
          tx.rollback();
        } catch (HibernateException e1) {
          logger.debug("Error rolling back transaction");
        }
// throw again the first exception
        throw e;
      }


    }
  }

  public static void deleteHoney(Honey honey) {
    Transaction tx = null;
    Session session = SessionFactoryUtil.getSessionFactory().openSession();
    try {
      tx = session.beginTransaction();
      session.delete(honey);
      tx.commit();
    } catch (RuntimeException e) {
      if (tx != null && tx.isActive()) {
        try {
// Second try catch as the rollback could fail as well
          tx.rollback();
        } catch (HibernateException e1) {
          logger.debug("Error rolling back transaction");
        }
// throw again the first exception
        throw e;
      }
    }
  }

  public static void createHoney(Honey honey) {
    Transaction tx = null;

    logger.debug("Error rolling back transaction");
    
	Session session = SessionFactoryUtil.getSessionFactory().openSession();
    try {
      tx = session.beginTransaction();
      session.save(honey);
      tx.commit();
    } catch (RuntimeException e) {
      if (tx != null && tx.isActive()) {
        try {
// Second try catch as the rollback could fail as well
          tx.rollback();
        } catch (HibernateException e1) {
          logger.error("Error rolling back transaction");
        }
// throw again the first exception
        logger.error("Error" + e.toString());
        e.printStackTrace();
        throw e;
      }
    }
  }

  public static void updateHoney(Honey honey) {
    Transaction tx = null;
    Session session = SessionFactoryUtil.getSessionFactory().openSession();
    try {
      tx = session.beginTransaction();
      session.update(honey);
      tx.commit();
    } catch (RuntimeException e) {
      if (tx != null && tx.isActive()) {
        try {
// Second try catch as the rollback could fail as well
          tx.rollback();
        } catch (HibernateException e1) {
          logger.debug("Error rolling back transaction");
        }
// throw again the first exception
        throw e;
      }
    }
  }
}

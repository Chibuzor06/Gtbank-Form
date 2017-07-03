package accountFormHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtilities {
	
	private Session session = null;
	private SessionFactory sessionFactory;
	private Transaction tx;
	
	public HibernateUtilities(){
		Configuration config = new Configuration().configure("accountFormHibernate/hibernate.cfg.xml");
		sessionFactory = config.buildSessionFactory();
		//session = sessionFactory.openSession();
		
	}
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public void startNewSession(){
		session = sessionFactory.openSession();
	}
	public Session getSession(){
		if(session == null){
			startNewSession();
		}
		return session;
	}
	public void beginTransaction(){
		tx = session.beginTransaction();
	}
	public Transaction getTransaction(){
		//return session.getTransaction();
		return tx;
	}

	/*
	public static void main(String[] args){
		HibernateUtilities util = new HibernateUtilities();
		util.startNewSession();
		util.getSession().close();
		util.getSessionFactory().close();
	}*/
}

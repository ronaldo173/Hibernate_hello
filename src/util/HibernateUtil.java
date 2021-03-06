package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import entity.PublisherEntity;

/**
 * It's write to db test.
 * 
 * @author Santer
 *
 */
public class HibernateUtil {

	/**
	 * In point to class.
	 * 
	 * @param args
	 *            not expect.
	 */
	public static void main(final String[] args) {

		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
		srb.applySettings(cf.getProperties());

		Session session = null;
		SessionFactory sf = null;

		try {
			sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			// cf.buildSessionFactory(sr);
			session = sf.openSession();
			PublisherEntity publisherEntity = new PublisherEntity();

			publisherEntity.setId(16); // Primary Key
			publisherEntity.setName("hibernate");

			Transaction tx = session.beginTransaction();
			session.save(publisherEntity);
			tx.commit();
			System.out.println("Object saved successfully.....!!");
		} finally {
			session.close();
			sf.close();
		}
	}
}

package util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import entity.PublisherEntity;

/**
 * It's test reading class.
 * 
 * @author Santer
 *
 */
public class HibernateReadUtil {

	/**
	 * It's in point to class.
	 * 
	 * @param args
	 *            not expected.
	 */
	public static void main(final String[] args) {
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		StandardServiceRegistryBuilder srb;
		srb = new StandardServiceRegistryBuilder();
		srb.applySettings(cf.getProperties());

		SessionFactory sf = null;
		Session session = null;
		try {
			sf = cf.buildSessionFactory();
			session = sf.openSession();

			PublisherEntity publisherEntity = (PublisherEntity) session.
					load(PublisherEntity.class, new Integer(10));

			System.out.println("Object get successfully.....!!");
			System.out.println(publisherEntity);

			List<PublisherEntity> list;
			list = session.createCriteria(PublisherEntity.class).list();
			System.out.println("list");
			System.out.println(list.size());
			for (PublisherEntity entity : list) {
				System.out.println(entity);
			}
		} finally {

			session.close();
			sf.close();
		}

	}

	/**
	 * Not for creating.
	 */
	private HibernateReadUtil() {
	}

}

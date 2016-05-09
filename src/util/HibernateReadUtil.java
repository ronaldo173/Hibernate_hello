package util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import entity.PublisherEntity;

public class HibernateReadUtil {

	public static void main(String[] args) {
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
		srb.applySettings(cf.getProperties());

		SessionFactory sf = null;
		Session session = null;
		try {

			// cf.buildSessionFactory(sr);
			sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

			session = sf.openSession();

			PublisherEntity publisherEntity = (PublisherEntity) session.load(PublisherEntity.class, new Integer(10));

			System.out.println("Object get successfully.....!!");
			System.out.println(publisherEntity);

			List<PublisherEntity> list = session.createCriteria(PublisherEntity.class).list();
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

}

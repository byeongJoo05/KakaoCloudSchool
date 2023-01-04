
import org.springframework.context.support.GenericXmlApplicationContext;

import di.domain.Good;
import di.persistence.HibernateRepository;

public class DiMain {
	public static void main(String[] args) {
		try (GenericXmlApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml")) {
			HibernateRepository repository = context.getBean(HibernateRepository.class);
			System.out.println(repository.listGood());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}
}

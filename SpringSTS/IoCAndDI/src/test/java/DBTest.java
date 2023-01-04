import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DBTest {
	@Autowired
	private DataSource dataSource;

	@Test
	public void testConnection() {
		try {
			/*
			 * // 여기서 예외가 발생하면 이름을 틀렸거나 의존성 설정 잘못됨 Class.forName("org.mariadb.jdbc.Driver");
			 * // 연결 Connection con =
			 * DriverManager.getConnection("jdbc:mariadb://localhost:3306/adam", "root",
			 * "s3938815"); System.out.println(con); con.close();
			 */
			
			System.out.println(dataSource);
			Connection con = dataSource.getConnection();
			System.out.println(con);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}

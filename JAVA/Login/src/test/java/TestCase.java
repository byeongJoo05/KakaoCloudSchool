import org.junit.jupiter.api.Test;
import persistence.MemberDAO;
import service.MemberService;
import service.MemberServiceImpl;

public class TestCase {
    @Test
    public void daoTest() {
        MemberDAO dao = MemberDAO.getInstance();
        System.out.println(dao.login("user", "1111"));
        System.out.println(dao.login("user", "1234"));
        System.out.println(dao.login("1234", "1111"));
    }

    @Test
    public void serviceTest() {
        MemberService service = MemberServiceImpl.getInstance();
//        System.out.println(service.login("user","1111"));
//        System.out.println(service.login("user","1234"));
//        System.out.println(service.login("1234","1111"));
    }
}

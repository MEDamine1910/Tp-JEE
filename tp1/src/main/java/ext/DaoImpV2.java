package ext;

import dao.IDao;
import org.springframework.stereotype.Component;

@Component("dao2")
public class DaoImpV2 implements IDao {

    @Override
    public double getdata() {
        System.out.println("Version web service");
        double t = 77;
        return t;
    }
}

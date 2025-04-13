package dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class DaoImpl implements IDao {
    @Override
    public double getdata() {
        System.out.println("Version bese de données");
        double temp = 25;
        return 0;
    }
}

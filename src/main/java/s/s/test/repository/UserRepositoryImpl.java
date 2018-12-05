package s.s.test.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import s.s.test.domain.model.User;

public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getByName(String name) {
        return sessionFactory.getCurrentSession().get(User.class, name);
    }
}

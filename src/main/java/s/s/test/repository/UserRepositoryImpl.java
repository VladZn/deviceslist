package s.s.test.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import s.s.test.domain.model.User;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User get(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User getByName(String name) {
        List<User> users = sessionFactory.getCurrentSession()
                .createNamedQuery(User.BY_NAME, User.class)
                .setParameter(1, name)
                .getResultList();
        return DataAccessUtils.singleResult(users);
    }
}

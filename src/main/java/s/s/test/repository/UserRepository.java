package s.s.test.repository;

import s.s.test.domain.model.User;

public interface UserRepository {

    User get(int id);

    User getByName(String name);

}

package s.s.test.service;

import s.s.test.domain.model.User;

public interface UserService {

    User get(int id);

    User getByName(String name);

}

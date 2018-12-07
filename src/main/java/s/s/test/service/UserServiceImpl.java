package s.s.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import s.s.test.domain.model.User;
import s.s.test.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User get(int id) {
        return repository.get(id);
    }

    @Override
    public User getByName(String name) {
        return repository.getByName(name);
    }
}

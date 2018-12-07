package s.s.test.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import s.s.test.domain.model.Device;
import s.s.test.domain.model.User;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional(readOnly = true)
public class DeviceRepositoryImpl implements DeviceRepository {

    //    @PersistenceContext
//    private EntityManager entityManager;
    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public Device save(Device device, int userId) {
        if (!device.isNew() && get(device.getId(), userId) == null) {
            return null;
        }

        Session currentSession = openSession();
        //device.setOwner(entityManager.getReference(User.class, userId));
        device.setOwner(currentSession.getReference(User.class, userId));

        if (device.isNew()) {
            //entityManager.persist(device);
            currentSession.persist(device);
            return device;
        } else {
            //return entityManager.merge(device);
            return (Device) currentSession.merge(device);
        }
    }

    @Override
    public Device get(UUID id, int userId) {
        Device device = openSession().find(Device.class, id);
        return device != null && device.getOwner().getId() == userId ? device : null;
    }

    @Override
    public List<Device> getAll(int userId) {
        return openSession().createNamedQuery(Device.GET_ALL, Device.class)
                .setParameter("userId", userId)
                .getResultList();
    }
}

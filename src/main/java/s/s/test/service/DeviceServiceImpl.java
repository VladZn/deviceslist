package s.s.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import s.s.test.domain.model.Device;
import s.s.test.repository.DeviceRepository;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional(readOnly = true)
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public Device get(UUID id, int userId) {
        return deviceRepository.get(id, userId);
    }

    @Override
    public List<Device> getAll(int userId) {
        return deviceRepository.getAll(userId);
    }

    @Override
    public Device add(Device device, int userId) {
        return deviceRepository.save(device, userId);
    }
}

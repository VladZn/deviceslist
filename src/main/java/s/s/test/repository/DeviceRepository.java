package s.s.test.repository;

import s.s.test.domain.model.Device;

import java.util.List;
import java.util.UUID;

public interface DeviceRepository {

    Device save(Device device, int userId);

    Device get(UUID id, int userId);

    List<Device> getAll(int userId);
}

package s.s.test.service;

import s.s.test.domain.model.Device;

import java.util.List;
import java.util.UUID;

public interface DeviceService {

    Device get(UUID id, int userId); //TODO NotFoundException

    List<Device> getAll(int userId);

    Device add(Device device, int userId);
}

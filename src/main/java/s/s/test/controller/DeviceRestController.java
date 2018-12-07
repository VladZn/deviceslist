package s.s.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import s.s.test.domain.model.Device;
import s.s.test.service.DeviceService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeviceRestController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "/devices", method = RequestMethod.GET)
    @ResponseBody
    public List<Device> getAll(){
        return deviceService.getAll(10001);
    }
}

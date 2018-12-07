package s.s.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import s.s.test.domain.model.Device;
import s.s.test.domain.model.User;
import s.s.test.service.DeviceService;
import s.s.test.service.UserService;
import s.s.test.util.SecurityUtil;

import java.util.List;

@Controller
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private UserService service;

    @GetMapping("/list")
//    public ModelAndView list(){
//        return new ModelAndView("list", "devices", deviceService.getAll(10001));
//    }
    public String listDevices(ModelMap model){
        //TODO userId
        User authUser = service.getByName(SecurityUtil.getAuthUserName());
        List<Device> list = deviceService.getAll(authUser.getId());
        model.addAttribute("devices", list);
        return "list";
    }
}

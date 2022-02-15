package main.demo.mvc.controller;

import main.demo.domain.dto.request.Param_User;
import main.demo.domain.dto.response.Response_User;
import main.demo.domain.dto.response.basement.ObjectMessage;
import main.demo.mvc.controller.basement.BaseController;
import main.demo.mvc.service.Service_Login;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class UserController extends BaseController<Service_Login> {

    protected UserController(Service_Login service) {
        super(service);
    }

    @RequestMapping(value="/check", method = RequestMethod.GET)
    public @ResponseBody ObjectMessage<Response_User.User> getUser(@ModelAttribute Param_User.Add param) {
        try {
            System.out.println(param);
            return service.getUser(param.getUuid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}



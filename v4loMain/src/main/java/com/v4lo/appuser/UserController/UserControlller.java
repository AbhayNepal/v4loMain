package com.v4lo.appuser.UserController;
import com.v4lo.appuser.Entity.Users;
import com.v4lo.appuser.service.AppUserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControlller {
    @Autowired
    AppUserService appUserService;
    @RequestMapping(method = RequestMethod.POST,value = "/register")
    public ResponseEntity<JSONObject> registerNewUser(@RequestBody Users users){
        return  appUserService.registerUser(users);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/user")
    public String user(){
        return "Hello User";
    }
    @RequestMapping(method = RequestMethod.GET,value = "/admin")
    public String admin(){
        return "Hello Admin";
    }
}

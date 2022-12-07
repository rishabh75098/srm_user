package com.srm.user.controller;

import com.srm.user.Exception.UserException;
import com.srm.user.model.UpdateUser;
import com.srm.user.model.UserClass;
import com.srm.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class controllerClass {

    @Autowired
    LoginService loginService;

    @GetMapping(value = "/get")
    public UserClass getMapping(@RequestBody UserClass userReq){

        return  loginService.getUser(userReq);
    }

    @PostMapping(value = "/create")
    public String postMapping(@RequestBody UserClass userRequest) {
         return loginService.createUser(userRequest);
    }

    @PutMapping(value = "/update")
    public UserClass update(@RequestBody UpdateUser userReq) throws UserException {
        return loginService.updateUser(userReq);
    }


}

package com.neonatal.backend.controllers;

import com.neonatal.backend.services.UserService;
import com.neonatal.backend.services.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import java.util.ArrayList;

/*
 * Class that defines GET, POST calls related to user table
 * may need additional securuty integration
 */


@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtils;

    /*
     * get the roleid for a given username
     */

    @RequestMapping("/getUserRole")
    @GetMapping
    public String getUserRole(String username){
        return userService.getUserRole(username);}

}

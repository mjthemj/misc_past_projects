package com.neonatal.backend.services;

import com.neonatal.backend.entities.*;
//import com.neonatal.backend.models.*;
import com.neonatal.backend.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import java.util.ArrayList;
import java.util.List;

/*
 * Class that defines service operations for the getUserRole endpoint
 */
@Service
@Transactional
public class UserService {
    
    @Autowired
    private UserRepository userRepository;


    /*
     * Gets a roleid from a username
     */
    public String getUserRole(String username){

        String role = ""; //default return

        try {

            List<User> userList = userRepository.getByUsername(username);
            role = userList.get(0).getRoleid();

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return role;
    }

}

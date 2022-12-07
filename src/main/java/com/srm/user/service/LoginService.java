package com.srm.user.service;

import com.srm.user.Exception.UserException;
import com.srm.user.model.UpdateUser;
import com.srm.user.model.UserClass;
import com.srm.user.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@Slf4j
public class LoginService {

    @Autowired
    UserRepo userRepo;

//    private static final Logger logger = (Logger) LoggerFactory.getLogger(LoginService.class);

    public UserClass getUser(UserClass userRequest){
        String email = userRequest.getEmail();
        String pwd = userRequest.getPassword();

        if(email== null ){

            return null;
        }
        else {
            UserClass user = userRepo.findByEmail(email);
            return user;
        }
    }
    public String createUser(UserClass userRequest){
        try{
            String email = userRequest.getEmail();
            String name = userRequest.getName();
            if(email == null || name== null){
                return "bad reqiest";
            }
            else{
                userRepo.save(userRequest);
            }
        } catch (Exception e){
            e.printStackTrace();

        }
        return "success created";


    }

    public UserClass updateUser(UpdateUser userRequest) throws UserException {

        try{
            String email = userRequest.getEmail();
            UserClass user = userRepo.findByEmail(email);
            if(user==null){
                throw new UserException("user not found");
            }
            else{

            }
            return null;

        }
        catch (Exception e){
            throw new UserException("user not found");
        }

    }
}

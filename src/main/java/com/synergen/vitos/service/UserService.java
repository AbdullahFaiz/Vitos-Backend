package com.synergen.vitos.service;

import com.synergen.vitos.dto.LoginDTO;
import com.synergen.vitos.dto.LoginResponse;
import com.synergen.vitos.dto.UserResponse;
import com.synergen.vitos.dto.ValidationError;
import com.synergen.vitos.enums.RecordStatusEnum;
import com.synergen.vitos.enums.ResponseEnum;
import com.synergen.vitos.enums.ValidationErrorEnum;
import com.synergen.vitos.model.User;
import com.synergen.vitos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserResponse createUser(User user) {

        UserResponse response = new UserResponse();
        List<ValidationError> validationErrors = new ArrayList<ValidationError>();

        try{

            PasswordService ps = new PasswordService();
            User userObj = userRepository.findByContactNo(user.getContactNo());

            if(userObj == null){
                user.setPassword(ps.encrypt(user.getPassword()));
                user.setStatus(RecordStatusEnum.ACTIVE.getCode());
                User resigteredUser = userRepository.save(user);


                response.setCode(ResponseEnum.SUCCESS.getCode());
                response.setMessage(ResponseEnum.SUCCESS.getMessage());
                response.setRegUser(resigteredUser);

            }else{
                response.setCode(ResponseEnum.VALIDATION_ERROR.getCode());
                response.setMessage(ResponseEnum.VALIDATION_ERROR.getMessage());

                ValidationError error = new ValidationError();
                error.setKey("code");
                error.setMessage(ValidationErrorEnum.ALREADY_EXISTS.getMessage());

                validationErrors.add(error);
            }

        }catch(Exception e){
            response.setCode(ResponseEnum.SOMETHING_WENT_WRONG.getCode());
            response.setMessage(e.getLocalizedMessage());
        }
        response.setValidationErrors(validationErrors);
        return response;


    }

    public UserResponse getAllUser(){

        UserResponse response = new UserResponse();
        try{


            List<User> userData = userRepository.findAll();

            response.setCode(200);
            response.setMessage("Success");
            response.setUser(userData);


        }catch(Exception ex){

            response.setCode(406);
            response.setMessage("Something went wrong");
        }

        return response;
    }

    public LoginResponse authenticate(LoginDTO loginDTO){
        LoginResponse response = new LoginResponse();
        List<ValidationError> errorList = new ArrayList<ValidationError>();
        PasswordService passwordService = new PasswordService();

        System.out.println("### PW: " + passwordService.encrypt(loginDTO.getPassword()));
        try {
            User user = userRepository.findByContactNo(loginDTO.getContactNo());
            if (user != null) {
                if (user.getStatus().equals(RecordStatusEnum.ACTIVE.getCode())) {
                    if (passwordService.decrypt(user.getPassword()).equals(loginDTO.getPassword())) {

                        response.setUser(user);
                        response.setCode(ResponseEnum.SUCCESS.getCode());
                        response.setMessage(ResponseEnum.SUCCESS.getMessage());
                    }else{
                        response.setCode(ResponseEnum.PASSWORD_INCORRECT.getCode());
                        response.setMessage(ResponseEnum.PASSWORD_INCORRECT.getMessage());
                    }
                }else{
                    response.setCode(ResponseEnum.INACTIVE_LOGIN.getCode());
                    response.setMessage(ResponseEnum.INACTIVE_LOGIN.getMessage());
                }
            }else{
                response.setCode(ResponseEnum.USERNAME_NOT_FOUND.getCode());
                response.setMessage(ResponseEnum.USERNAME_NOT_FOUND.getMessage());
            }
        } catch (Exception e) {
            response.setCode(ResponseEnum.SOMETHING_WENT_WRONG.getCode());
            response.setMessage(ResponseEnum.SOMETHING_WENT_WRONG.getMessage());
        }
//        response.setValidationErrors(errorList);
        return response;
    }

}

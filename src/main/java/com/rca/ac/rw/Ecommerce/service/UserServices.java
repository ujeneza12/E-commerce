package com.rca.ac.rw.Ecommerce.service;


import com.rca.ac.rw.Ecommerce.api.model.LoginModel;
import com.rca.ac.rw.Ecommerce.api.model.RegistrationModel;
import com.rca.ac.rw.Ecommerce.exception.UserExistsException;
import com.rca.ac.rw.Ecommerce.model.LocalUser;
import com.rca.ac.rw.Ecommerce.model.dao.LocalUserDAO;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserServices {

    private LocalUserDAO localUserDAO;
    private EncryptionService encryptionService;
    private JWTService jwtService;


    public UserServices(LocalUserDAO localUserDAO, EncryptionService encryptionService,JWTService jwtService ){
        this.localUserDAO = localUserDAO;
        this.encryptionService=encryptionService;
        this.jwtService=jwtService;

    }

    //function for user registeration for accepting user inputs
    public LocalUser registerUser( RegistrationModel registrationModel)  throws  UserExistsException {

        if(localUserDAO.findByEmailIgnoreCase(registrationModel.getEmail()).isPresent()){
            throw new UserExistsException();
        };
        LocalUser user= new LocalUser();
        user.setFirstname(registrationModel.getFirstname());
        user.setEmail(registrationModel.getEmail());
        user.setPhone(registrationModel.getPhone());
        user.setPassword(encryptionService.encryptPassword(registrationModel.getPassword()));

        return localUserDAO.save(user);

    }

    //function for userlogin
    public String loginUser(LoginModel loginModel) {

        Optional<LocalUser> opUser = localUserDAO.findByEmailIgnoreCase(loginModel.getEmail());

        if (opUser.isPresent()) {
            LocalUser user = opUser.get();

            if (encryptionService.verifyPassword(loginModel.getPassword(), user.getPassword())) {
                return jwtService.generateJWT(user);
            }
        }

        return null;

    }

}

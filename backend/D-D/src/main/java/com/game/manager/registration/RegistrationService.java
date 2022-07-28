package com.game.manager.registration;

import com.game.manager.appuser.AppUser;
import com.game.manager.appuser.AppUserRole;
import com.game.manager.service.AppUserService;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request){
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }

        return appUserService.signUpUser(
                new AppUser(
                        request.getUsername(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}

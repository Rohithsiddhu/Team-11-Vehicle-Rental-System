package com.project.carrental.services.auth;

import com.project.carrental.dto.SignupRequest;
import com.project.carrental.dto.UserDto;
import com.project.carrental.entity.User;
import com.project.carrental.enums.UserRole;
import com.project.carrental.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

	@Autowired
    UserRepository userRepository;

    @PostConstruct
    public void createAdminAccount() {
        User adminAccount = userRepository.findByUserRole(UserRole.ADMIN);
        if (null == adminAccount) {
            User user = new User();
            user.setEmail("admin@test.com");
            user.setName("Admin");
            user.setUserRole(UserRole.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(user);
        }
    }

    @Transactional
    public UserDto createUser(SignupRequest signupRequest) throws Exception {
        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setUserRole(UserRole.CUSTOMER);
        User createdUser = userRepository.save(user);
        UserDto createdUserDto = new UserDto();
        createdUserDto.setId(createdUser.getId());
        return createdUserDto;
    }


    public Boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }


}

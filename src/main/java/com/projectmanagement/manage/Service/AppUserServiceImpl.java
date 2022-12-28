package com.projectmanagement.manage.Service;

import com.projectmanagement.manage.Model.AppUser;
import com.projectmanagement.manage.Repo.AppUserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserServiceImpl implements AppUserService, UserDetailsService {

    private final AppUserRepo appUserRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = appUserRepo.findByEmail(email);
        if(appUser == null){
            log.error("Email {} not found.", email);
            throw new UsernameNotFoundException("Email {} not found. Please check the username is correct.");
        }
        else{
            log.info("Email {} found successfully!", email);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(appUser.getEmail(), appUser.getPassword(), authorities);
    }

    @Override
    public void saveAppUser(AppUser appUser) {
        String fullName = appUser.getFirstName() + " " + appUser.getLastName();
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUser.setFullName(fullName);
        appUserRepo.save(appUser);
    }

    @Override
    public List<AppUser> getAllUsers() {
        List<AppUser> appUsers = appUserRepo.findAll();
        return appUsers;
    }

    @Override
    public AppUser getUser(String fullName) {
        return appUserRepo.findByFullName(fullName);
    }

    @Override
    public AppUser getByEmail(String email) {
        return appUserRepo.findByEmail(email);
    }
}

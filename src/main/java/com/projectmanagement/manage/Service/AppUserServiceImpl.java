package com.projectmanagement.manage.Service;

import com.projectmanagement.manage.Model.AppUser;
import com.projectmanagement.manage.Repo.AppUserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserServiceImpl implements AppUserService{

    private final AppUserRepo appUserRepo;

    @Override
    public void saveAppUser(AppUser appUser) {
        String fullName = appUser.getFirstName() + " " + appUser.getLastName();
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
}

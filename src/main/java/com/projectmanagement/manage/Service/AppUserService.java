package com.projectmanagement.manage.Service;

import com.projectmanagement.manage.Model.AppUser;

import java.util.List;

public interface AppUserService {

    List<AppUser> getAllUsers();
    AppUser getUser(String fullName);
    AppUser getByEmail(String email);

    void saveAppUser(AppUser appUser);
}

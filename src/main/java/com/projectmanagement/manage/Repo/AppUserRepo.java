package com.projectmanagement.manage.Repo;

import com.projectmanagement.manage.Model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByFullName(String fullName);
}

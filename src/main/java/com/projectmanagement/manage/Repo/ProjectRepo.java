package com.projectmanagement.manage.Repo;

import com.projectmanagement.manage.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Long> {
    Project findByProjectName(String projectName);

    Project findByProjectId(Long projectId);
}

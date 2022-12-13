package com.projectmanagement.manage.Service;


import com.projectmanagement.manage.Model.Project;

import java.util.List;

public interface ProjectService {

    void saveProject(Project project);
    List<Project> getAllProjects();

    Project getProject(String projectName);

    Project getProjectById(Long projectId);
}

package com.projectmanagement.manage.Service;

import com.projectmanagement.manage.Model.Project;
import com.projectmanagement.manage.Repo.ProjectRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepo projectRepo;

    @Override
    public void saveProject(Project project) {
        projectRepo.save(project);
    }

    @Override
    public List<Project> getAllProjects() {
        List<Project> projects = projectRepo.findAll();
        return projects;
    }

    @Override
    public Project getProject(String projectName) {
        return projectRepo.findByProjectName(projectName);
    }

    @Override
    public Project getProjectById(Long projectId) {
        return projectRepo.findByProjectId(projectId);
    }


}

package com.projectmanagement.manage.Service;

import com.projectmanagement.manage.Model.AppUser;
import com.projectmanagement.manage.Model.Project;
import com.projectmanagement.manage.Model.Task;
import com.projectmanagement.manage.Repo.TaskRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepo taskRepo;
    private final AppUserServiceImpl appUserService;

    private final ProjectServiceImpl projectService;

    @Override
    public void editTask(Task task) {
        Optional<Task> tempTask = taskRepo.findById(task.getTaskId());
        if(tempTask.isPresent()){
            Task oldTask = tempTask.get();
            oldTask.setTaskName(task.getTaskName());
            oldTask.setAdditionalInfo(task.getAdditionalInfo());
            oldTask.setPriority(task.getPriority());
            oldTask.setAssignedTo(task.getAssignedTo());
            oldTask.setCategory(task.getCategory());
            AppUser appUser = appUserService.getUser(task.getAssignedTo());
            oldTask.setAppUser(appUser);
            taskRepo.save(oldTask);
        }
    }

    @Override
    public List<Task> findProjectTasks(Long projectId) {
        Project project = projectService.getProjectById(projectId);
        return taskRepo.findAllByProject(project);
    }

    @Override
    public List<Task> findAllTasks() {
        return taskRepo.findAll();
    }

    @Override
    public void saveTask(Task task, Long projectId) {
        AppUser appUser = appUserService.getUser(task.getAssignedTo());
        Project project = projectService.getProjectById(projectId);
        task.setAppUser(appUser);
        task.setProject(project);
        taskRepo.save(task);

    }
}

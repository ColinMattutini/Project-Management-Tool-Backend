package com.projectmanagement.manage.Controller;

import com.projectmanagement.manage.Model.Project;
import com.projectmanagement.manage.Model.Task;
import com.projectmanagement.manage.Service.ProjectServiceImpl;
import com.projectmanagement.manage.Service.TaskServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class TaskController {

    private final TaskServiceImpl taskService;
    private final ProjectServiceImpl projectService;

    @PostMapping("/project/{projectName}/newtask")
    public void saveTask(@RequestBody Task task, @PathVariable String projectName){
        Project project = projectService.getProject(projectName);
        Long projectId = project.getProjectId();
        taskService.saveTask(task, projectId);
    }


    @PutMapping("/project/{projectName}/edittask")
    public void editTask(@RequestBody Task task){
        taskService.editTask(task);
    }

    @GetMapping("/alltasks")
    public ResponseEntity getAllTasks(){
        return ResponseEntity.ok().body(taskService.findAllTasks());
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/project/{projectName}/tasks")
    public ResponseEntity getProjectTasks(@PathVariable String projectName){
        Project project = projectService.getProject(projectName);
        Long projectId = project.getProjectId();
        return ResponseEntity.ok().body(taskService.findProjectTasks(projectId));
    }

}


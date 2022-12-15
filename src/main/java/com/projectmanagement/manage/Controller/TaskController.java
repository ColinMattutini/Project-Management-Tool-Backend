package com.projectmanagement.manage.Controller;

import com.projectmanagement.manage.Model.Task;
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

    @PostMapping("/project/{projectId}/newtask")
    public void saveTask(@RequestBody Task task, @PathVariable Long projectId){
        taskService.saveTask(task, projectId);
    }

    @PutMapping("/project/{projectId}/edittask")
    public void editTask(@RequestBody Task task){
        taskService.editTask(task);
    }

    @GetMapping("/alltasks")
    public ResponseEntity getAllTasks(){
        return ResponseEntity.ok().body(taskService.findAllTasks());
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/project/{projectId}/tasks")
    public ResponseEntity getProjectTasks(@PathVariable Long projectId){
        return ResponseEntity.ok().body(taskService.findProjectTasks(projectId));
    }

}


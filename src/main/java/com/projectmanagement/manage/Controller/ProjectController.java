package com.projectmanagement.manage.Controller;


import com.projectmanagement.manage.Model.Project;
import com.projectmanagement.manage.Service.ProjectServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProjectController {

    private final ProjectServiceImpl projectService;

    @GetMapping("/projects")
    public ResponseEntity getAllProjects(){
        return ResponseEntity.ok().body(projectService.getAllProjects());
    }

    @PostMapping("/save/project")
    public void saveProject(@RequestBody Project project){
        projectService.saveProject(project);
    }
}

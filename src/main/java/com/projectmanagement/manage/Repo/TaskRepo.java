package com.projectmanagement.manage.Repo;

import com.projectmanagement.manage.Model.Project;
import com.projectmanagement.manage.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long> {

    List<Task> findAllByProject(Project project);
}

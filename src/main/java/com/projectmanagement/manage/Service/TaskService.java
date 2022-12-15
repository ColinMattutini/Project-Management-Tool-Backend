package com.projectmanagement.manage.Service;

import com.projectmanagement.manage.Model.Task;

import java.util.List;

public interface TaskService {
    void saveTask(Task task, Long projectId);
    void editTask(Task task);

    List<Task> findProjectTasks(Long projectId);

    List<Task> findAllTasks();
}

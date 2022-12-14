package com.projectmanagement.manage.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private String taskName;

    private String additionalInfo;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private PriorityEnum priority;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private AppUser appUser;

    private String assignedTo;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private TaskCategoryEnum category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="projectId", referencedColumnName = "projectId")
    private Project project;

}

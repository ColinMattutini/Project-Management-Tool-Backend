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
    @Column(name = "Priority")
    private PriorityEnum priority;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "postTotalScoreId", referencedColumnName = "postTotalScoreId")
    private AppUser appUser;

}

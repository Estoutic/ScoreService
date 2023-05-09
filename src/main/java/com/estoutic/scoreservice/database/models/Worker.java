package com.estoutic.scoreservice.database.models;

import com.estoutic.scoreservice.database.models.task.UserTaskResult;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
public class Worker {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 64, updatable = false, nullable = false)
    private String id;

    private String username;

    @OneToMany(mappedBy = "worker")
    private List<UserTaskResult> taskResults;

    public Worker() {}
}

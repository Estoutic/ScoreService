package com.estoutic.scoreservice.database.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 64, updatable = false, nullable = false)
    private String id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Task(){}
}

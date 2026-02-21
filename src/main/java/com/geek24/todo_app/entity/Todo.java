package com.geek24.todo_app.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
@Getter
@Setter
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String description;
    private Boolean completed;
    private LocalDateTime createdAt;
    @PrePersist // This means - run this method BEFORE the entity is inserted into the database.
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}

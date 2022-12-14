package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "tasks")
public class Task {
    @javax.persistence.Id
    @Id
    @GeneratedValue
    private Long taskId;

    @Column(name = "name")
    private String title;

    @Column(name = "description")
    private String content;

    public void setId(Long taskId) {
        this.taskId = taskId;
    }

}
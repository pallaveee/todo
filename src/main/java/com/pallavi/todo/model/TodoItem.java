package com.pallavi.todo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TodoItem {

    @Id
    @GeneratedValue
    private long id;
    private long created;
    private String text;
    private String userName;
    private boolean isDone;
}

package com.codewithsowmiya.JpaTodo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @GeneratedValue
    private int id;
    private String items;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="userid",referencedColumnName = "userid")
    private User user;
}

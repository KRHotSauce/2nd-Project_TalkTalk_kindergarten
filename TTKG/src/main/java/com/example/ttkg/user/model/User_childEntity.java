package com.example.ttkg.user.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Getter
@Entity
@Table(name="user_child")
public class User_childEntity {

    @EmbeddedId
    private User_Child_Id user_child_id;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name="user_id")
    private UserEntity user;

    @ManyToOne
    @MapsId("child_id")
    @JoinColumn(name="child_id")
    private ChildEntity child;

    @Column(name="kindercode")
    private String kinderCode;

    public User_childEntity(){
        this.kinderCode=null;
    }

}


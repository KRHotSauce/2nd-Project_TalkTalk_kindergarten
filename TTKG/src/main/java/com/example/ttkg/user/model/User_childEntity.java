package com.example.ttkg.user.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Getter
@Entity
@Table(name="User_child")
public class User_childEntity {

    @EmbeddedId
    private User_Child_Idx user_child_idx;

    @ManyToOne
    @MapsId("user_idx")
    @JoinColumn(name="user_idx")
    private UserEntity user;

    @ManyToOne
    @MapsId("child_idx")
    @JoinColumn(name="child_idx")
    private ChildEntity child;

    @Column(name="kinderCode")
    private String kinderCode;

    public User_childEntity(){
        this.kinderCode=null;
    }

}


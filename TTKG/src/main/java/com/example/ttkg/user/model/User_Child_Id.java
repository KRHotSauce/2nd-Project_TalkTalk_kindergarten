package com.example.ttkg.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Embeddable
public class User_Child_Id implements Serializable {

    @Column(name="user_id")
    Long user_id;

    @Column(name="child_id")
    Long child_id;

    public User_Child_Id() {

    }

    public User_Child_Id(Long user_id, Long child_id) {
        this.user_id = user_id;
        this.child_id = child_id;
    }

}


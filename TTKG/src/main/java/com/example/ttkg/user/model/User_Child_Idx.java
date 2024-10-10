package com.example.ttkg.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Embeddable
public class User_Child_Idx implements Serializable {

    @Column(name="user_idx")
    Long user_idx;

    @Column(name="child_idx")
    Long child_idx;

    public User_Child_Idx() {

    }

    public User_Child_Idx(Long user_id, Long child_id) {
        this.user_idx = user_id;
        this.child_idx = child_id;
    }

}


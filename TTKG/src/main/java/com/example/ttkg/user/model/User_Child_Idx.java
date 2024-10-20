package com.example.ttkg.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User_Child_Idx that = (User_Child_Idx) o;
        return Objects.equals(user_idx, that.user_idx) &&
                Objects.equals(child_idx, that.child_idx);
    }

    // hashCode() 메서드
    @Override
    public int hashCode() {
        return Objects.hash(user_idx, child_idx);
    }

}


package com.example.ttkg.user.model;

import com.example.ttkg.kinder.model.KinderEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="User_child")
public class User_ChildEntity {

    @EmbeddedId
    private User_Child_Idx user_child_idx;

    @ManyToOne
    @MapsId("user_idx")
    @JoinColumn(name="user_idx")
    private UserEntity users;

    @ManyToOne
    @MapsId("child_idx")
    @JoinColumn(name="child_idx")
    private ChildEntity child;

    @Column(name="kinderCode")
    private String kinderCode;
  
    //0은 디폴트 1은 유치원 승낙상태 2는 신청상태
    @Column(name="access_state")
    private int accessState;

    public User_ChildEntity(){
        this.kinderCode=null;
    }

}


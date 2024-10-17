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

<<<<<<< HEAD:TTKG/src/main/java/com/example/ttkg/user/model/User_ChildEntity.java
    @ManyToOne
    @JoinColumn(name="kinderCode",referencedColumnName = "kinderCode")
    KinderEntity kinderCode;
=======
    @Column(name="kinderCode")
    private String kinderCode;
>>>>>>> c883d78b2c57469af9d5d06daf46de7b0ac218fc:TTKG/src/main/java/com/example/ttkg/user/model/User_childEntity.java

    public User_ChildEntity(){
        this.kinderCode=null;
    }

}


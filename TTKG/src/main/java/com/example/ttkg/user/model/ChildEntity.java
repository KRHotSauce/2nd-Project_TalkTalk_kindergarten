package com.example.ttkg.user.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SequenceGenerator(
        name = "CHILD_SEQ_GENERATOR",
        sequenceName = "child_seq",
        initialValue = 1,
        allocationSize = 1
)
@Setter
@Getter
@Entity
@Table(name = "child")
public class ChildEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CHILD_SEQ_GENERATOR"
    )
    @Column(name = "child_idx")
    private long child_idx;

    @Column(name = "child_name", nullable = true, length = 255)
    private String child_name;

    @Column(name = "child_birth", nullable = true)
    private LocalDate child_birth;


    @OneToMany(mappedBy = "child",cascade = CascadeType.REMOVE)
    private Set<User_childEntity> user_childEntities=new HashSet<>();
}

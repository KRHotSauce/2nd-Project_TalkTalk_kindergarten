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
    @Column(name = "child_id")
    private long child_id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "age", nullable = true)
    private LocalDate age;

    @Column(name = "height", nullable = true)
    private long height;

    @Column(name = "weight", nullable = true)
    private long weight;

    @Column(name = "allergy", nullable = true)
    private String allergy;

    @Column(name = "mdi_history", nullable = true)
    private String mdi_history;

    @Column(name = "attendance_date", nullable = true)
    private Date attendance_date;

    @Column(name = "check_in_time", nullable = true)
    private String check_in_time;

    @Column(name = "check_out_time", nullable = true)
    private String check_out_time;

    @OneToMany(mappedBy = "child",cascade = CascadeType.REMOVE)
    private Set<User_childEntity> user_childEntities=new HashSet<>();
}

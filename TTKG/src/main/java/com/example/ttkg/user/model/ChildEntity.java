package com.example.ttkg.user.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "child")
public class ChildEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CHILD_SEQ_GENERATOR"
    )
    @Column(name = "child_idx")
    private long childIdx;

    @Column(name = "child_name", nullable = true, length = 255)
    private String childName;

    @Column(name = "child_birth", nullable = true)
    private LocalDate childBirth;

    @Column(name = "child_addr", nullable = false)
    private String childAddr;

    @Column(name = "child_gender", nullable = false)
    private String childGender;

    @Column(name = "child_allergy", nullable = false)
    private Boolean childAllergy;

    @Column(name = "kinderCode")
    private String kinderCode;

    @OneToMany(mappedBy = "child",cascade = CascadeType.REMOVE)
    private Set<User_ChildEntity> user_childEntities=new HashSet<>();
}

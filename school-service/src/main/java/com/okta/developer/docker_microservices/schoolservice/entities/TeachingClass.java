package com.okta.developer.docker_microservices.schoolservice.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint( name = "un_class", columnNames = {
        "course_id", "teacher_id", "year"
}))
public class TeachingClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_class_course"))
    @NotNull
    @NonNull
    private Course course;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_class_teacher"))
    @NotNull
    @NonNull
    private Teacher teacher;

    @ManyToMany
    @JoinTable(
            foreignKey = @ForeignKey(name = "fk_class_student"),
            inverseForeignKey = @ForeignKey(name = "fk_student_class")
    )
    @NonNull private List<Student> students;
    @NonNull private int year;


}


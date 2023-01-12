package com.manage.people.model;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name="PERSONS")
@TypeDefs(
        @TypeDef(name = "json", typeClass = JsonType.class)
)
public class Person {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String birthDate;

    @Column(nullable = false)
    private String name;

    @Type(type = "json")
    @Column(name = "ADRESS", columnDefinition = "json")
    private List<Adress> adress;
}

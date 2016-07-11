package com.nealma.domain;

import javax.persistence.*;

/**
 * Created by nealpc on 7/4/16.
 */
@Entity
@Table(name="t_user", uniqueConstraints = {@UniqueConstraint(columnNames={"name", "level"})})
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 50, name = "name")
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false, columnDefinition = "tinyint(1) default '0'")
    private Integer level;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

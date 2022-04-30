package com.na.alkemy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author nagredo
 * @project alkemy
 * @class Character
 */
@Entity
@Table(name = "cha_character", schema = "alkemy")
public class CharacterEntity {
    @Id
    @Column
    private Integer id;

    @Column
    private String image;

    @Column
    private String name;

    @Column
    private String age;

    @Column
    private String weight;

    @Column
    private String history;

    @Column
    private Integer associatedMovies;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Integer getAssociatedMovies() {
        return associatedMovies;
    }

    public void setAssociatedMovies(Integer movieOSeries) {
        this.associatedMovies = movieOSeries;
    }
}

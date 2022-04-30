package com.na.alkemy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author nagredo
 * @project alkemy
 * @class Gender
 */
@Entity
@Table(name = "gen_gender", schema = "alkemy")
public class GenderEntity {
    @Id
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private String image;

    @Column
    private Integer associatedMovies;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getAssociatedMovies() {
        return associatedMovies;
    }

    public void setAssociatedMovies(Integer associatedMovies) {
        this.associatedMovies = associatedMovies;
    }
}

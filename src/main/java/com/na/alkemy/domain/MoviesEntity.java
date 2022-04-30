package com.na.alkemy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author nagredo
 * @project alkemy
 * @class Movies
 */
@Entity
@Table(name = "mos_movies", schema = "alkemy")
public class MoviesEntity {
    @Id
    @Column
    private Integer id;

    @Column
    private String image;

    @Column
    private String title;

    @Column
    private Date creationDate;

    @Column
    private Integer qualification;

    @Column
    private Integer associatedCharacters;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getQualification() {
        return qualification;
    }

    public void setQualification(Integer qualification) {
        this.qualification = qualification;
    }

    public Integer getAssociatedCharacters() {
        return associatedCharacters;
    }

    public void setAssociatedCharacters(Integer associatedCharacters) {
        this.associatedCharacters = associatedCharacters;
    }
}

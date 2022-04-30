package com.na.alkemy.payload;

import java.util.Date;

/**
 * @author nagredo
 * @project alkemy
 * @class MoviesDto
 */
public class MoviesForm {
    private Integer id;
    private String image;
    private String title;
    private Date creationDate;
    private Integer qualification;
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

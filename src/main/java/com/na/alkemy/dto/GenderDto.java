package com.na.alkemy.dto;

/**
 * @author nagredo
 * @project alkemy
 * @class GenderDto
 */
public class GenderDto {
    private Integer id;

    private String name;

    private String image;

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

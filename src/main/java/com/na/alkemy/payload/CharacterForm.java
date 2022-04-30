package com.na.alkemy.payload;

/**
 * @author nagredo
 * @project alkemy
 * @class Character
 */
public class CharacterForm {
    private Integer id;
    private String image;
    private String name;
    private String age;
    private String weight;
    private String history;
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

    public void setAssociatedMovies(Integer associatedMovies) {
        this.associatedMovies = associatedMovies;
    }
}

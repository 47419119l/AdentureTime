package com.example.shengbin.adenturetime.json;

/**
 * Created by shengbin on 2016/1/4.
 */
import java.util.ArrayList;
import java.util.List;


public class Characters {


    private int id;

    private String name;

    private String full_name;

    private String sex;

    private String link;

    private String image;

    private String created;

    private String modified;

    private List<Episode> episode = new ArrayList<Episode>();

    private List<Species> species = new ArrayList<Species>();

    private List<RelativesMany> relatives_many = new ArrayList<RelativesMany>();

    private List<Occupation> occupations = new ArrayList<Occupation>();

    /**
     * @return The id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The fullName
     */
    public String getFullName() {
        return full_name;
    }

    /**
     * @param fullName The full_name
     */
    public void setFullName(String fullName) {
        this.full_name = fullName;
    }

    /**
     * @return The sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex The sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return The link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return The image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return The created
     */
    public String getCreated() {
        return created;
    }

    /**
     * @param created The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * @return The modified
     */
    public String getModified() {
        return modified;
    }

    /**
     * @param modified The modified
     */
    public void setModified(String modified) {
        this.modified = modified;
    }

    /**
     * @return The episode
     */
    public List<Episode> getEpisode() {
        return episode;
    }

    /**
     * @param episode The episode
     */
    public void setEpisode(List<Episode> episode) {
        this.episode = episode;
    }

    /**
     * @return The species
     */
    public List<Species> getSpecies() {
        return species;
    }

    /**
     * @param species The species
     */
    public void setSpecies(List<Species> species) {
        this.species = species;
    }

    /**
     * @return The relativesMany
     */
    public List<RelativesMany> getRelativesMany() {
        return relatives_many;
    }

    /**
     * @param relativesMany The relatives_many
     */
    public void setRelativesMany(List<RelativesMany> relativesMany) {
        this.relatives_many = relativesMany;
    }

    /**
     * @return The occupations
     */
    public List<Occupation> getOccupations() {
        return occupations;
    }

    /**
     * @param occupations The occupations
     */
    public void setOccupations(List<Occupation> occupations) {
        this.occupations = occupations;
    }
}
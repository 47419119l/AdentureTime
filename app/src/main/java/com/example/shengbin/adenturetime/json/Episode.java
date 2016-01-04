package com.example.shengbin.adenturetime.json;

import java.util.ArrayList;
import java.util.List;

public class Episode {

    private int id;
    private String title;
    private int seasonId;
    private int episodeId;
    private String link;
    private String titleCard;
    private String description;
    private String productionCode;
    private String airDate;
    private String airDateUtc;
    private String viewers;
    private String created;
    private String modified;

    private List<Character> characters = new ArrayList<Character>();

    /**
     *
     * @return
     * The id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The seasonId
     */
    public int getSeasonId() {
        return seasonId;
    }

    /**
     *
     * @param seasonId
     * The season_id
     */
    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    /**
     *
     * @return
     * The episodeId
     */
    public int getEpisodeId() {
        return episodeId;
    }

    /**
     *
     * @param episodeId
     * The episode_id
     */
    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    /**
     *
     * @return
     * The link
     */
    public String getLink() {
        return link;
    }

    /**
     *
     * @param link
     * The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     *
     * @return
     * The titleCard
     */
    public String getTitleCard() {
        return titleCard;
    }

    /**
     *
     * @param titleCard
     * The title_card
     */
    public void setTitleCard(String titleCard) {
        this.titleCard = titleCard;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The productionCode
     */
    public String getProductionCode() {
        return productionCode;
    }

    /**
     *
     * @param productionCode
     * The production_code
     */
    public void setProductionCode(String productionCode) {
        this.productionCode = productionCode;
    }

    /**
     *
     * @return
     * The airDate
     */
    public String getAirDate() {
        return airDate;
    }

    /**
     *
     * @param airDate
     * The air_date
     */
    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    /**
     *
     * @return
     * The airDateUtc
     */
    public String getAirDateUtc() {
        return airDateUtc;
    }

    /**
     *
     * @param airDateUtc
     * The air_date_utc
     */
    public void setAirDateUtc(String airDateUtc) {
        this.airDateUtc = airDateUtc;
    }

    /**
     *
     * @return
     * The viewers
     */
    public String getViewers() {
        return viewers;
    }

    /**
     *
     * @param viewers
     * The viewers
     */
    public void setViewers(String viewers) {
        this.viewers = viewers;
    }

    /**
     *
     * @return
     * The created
     */
    public String getCreated() {
        return created;
    }

    /**
     *
     * @param created
     * The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     *
     * @return
     * The modified
     */
    public String getModified() {
        return modified;
    }

    /**
     *
     * @param modified
     * The modified
     */
    public void setModified(String modified) {
        this.modified = modified;
    }

    /**
     *
     * @return
     * The characters
     */
    public List<Character> getCharacters() {
        return characters;
    }

    /**
     *
     * @param characters
     * The characters
     */
    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

}
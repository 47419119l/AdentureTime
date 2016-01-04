package com.example.shengbin.adenturetime.json;

import java.util.ArrayList;
import java.util.List;

public class Episode {

    private int id;
    private String title;
    private int seasonId;
    private int episodeId;
    private String link;
    private String title_card;
    private String description;
    private String production_code;
    private String air_date;
    private String airDateUtc;
    private String viewers;
    private String created;
    private String modified;

    private List<Characters> characters = new ArrayList<Characters>();

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
        return title_card;
    }

    /**
     *
     * @param titleCard
     * The title_card
     */
    public void setTitleCard(String titleCard) {
        this.title_card = titleCard;
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
        return production_code;
    }

    /**
     *
     * @param productionCode
     * The production_code
     */
    public void setProductionCode(String productionCode) {
        this.production_code = productionCode;
    }

    /**
     *
     * @return
     * The airDate
     */
    public String getAirDate() {
        return air_date;
    }

    /**
     *
     * @param airDate
     * The air_date
     */
    public void setAirDate(String airDate) {
        this.air_date = airDate;
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
    public List<Characters> getCharacters() {
        return characters;
    }

    /**
     *
     * @param characters
     * The characters
     */
    public void setCharacters(List<Characters> characters) {
        this.characters = characters;
    }

}
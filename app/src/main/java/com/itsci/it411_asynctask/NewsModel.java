package com.itsci.it411_asynctask;

public class NewsModel {
    private String title;
    private String description;
    private String pubDate;
    private String link;
    private String image_url;

    public NewsModel(String title, String description, String pubDate, String link, String image_url) {
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;
        this.link = link;
        this.image_url = image_url;
    }

    public NewsModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}

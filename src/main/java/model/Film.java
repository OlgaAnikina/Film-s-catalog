package model;

public class Film {
    String id;
    String name;
    String producer;
    String dateOfRelease;
    String style;
    Boolean rank;

    public Film() {
    }

    public Film(String id, String name, String producer, String dateOfRelease, String style) {
        this.dateOfRelease = dateOfRelease;
        this.style = style;
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.rank = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(String dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Boolean getRank() {
        return rank;
    }

    public void setRank(Boolean rank) {
        this.rank = rank;
    }
}

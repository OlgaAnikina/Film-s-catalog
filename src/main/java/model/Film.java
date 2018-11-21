package model;

public class Film {
    String id;
    String name;
    String producer;
    String dateOfRelease;
    String style;
    Boolean state;

    public Film() {
    }

    public Film(String id, String name, String producer, String dateOfRelease, String style) {
        this.dateOfRelease = dateOfRelease;
        this.style = style;
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.state = true;
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

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}

package model;

public class Film implements Comparable {
    String id;
    String name;
    String producer;
    String dateOfRelease;
    String style;
    String rank;

    public Film() {
    }

    public Film(String id, String name, String producer, String dateOfRelease, String style, String rank) {
        this.dateOfRelease = dateOfRelease;
        this.style = style;
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.rank = rank;
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Film))
            return 0;
        Integer obId = Integer.parseInt(((Film) o).getId());
        Integer thisId = Integer.parseInt(this.getId());
        return thisId.compareTo(obId);
    }
}

package janlochba.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table( name = "issue", schema = "nav42")
public class Issue {
    private String id;
    private String name;
    private String description;
    private Double minValue;
    private Double maxValue;
    private String typ;

    @Id
    //@GeneratedValue
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "min_value")
    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    @Basic
    @Column(name = "max_value")
    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    @Basic
    @Column(name = "typ")
    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return Objects.equals(id, issue.id) && Objects.equals(name, issue.name) && Objects.equals(description, issue.description) && Objects.equals(minValue, issue.minValue) && Objects.equals(maxValue, issue.maxValue) && Objects.equals(typ, issue.typ);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typ, name, description, minValue, maxValue);
    }
}

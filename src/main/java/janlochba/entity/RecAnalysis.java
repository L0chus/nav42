package janlochba.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table( name = "recAnalysis", schema = "nav42")
public class RecAnalysis {

    private Integer id;
    private String name;
    private String description;
    private String typ;
    private String extra1;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Basic
    @Column(name = "typ")
    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    @Basic
    @Column(name = "extra1")
    public String getExtra1() {
        return extra1;
    }

    public void setExtra1(String extra1) {
        this.extra1 = extra1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecAnalysis that = (RecAnalysis) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(typ, that.typ) && Objects.equals(extra1, that.extra1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, typ, extra1);
    }
}

package janlochba.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table( name = "solution", schema = "nav42")
public class Solution {
    private String id;
    private String name;
    private String description;
    private Long minCost;
    private Long maxCost;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    @Column(name = "minCost")
    public Long getMinCost() {
        return minCost;
    }

    public void setMinCost(Long minCost) {
        this.minCost = minCost;
    }

    @Basic
    @Column(name = "maxCost")
    public Long getMaxCost() {
        return maxCost;
    }

    public void setMaxCost(Long maxCost) {
        this.maxCost = maxCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return Objects.equals(id, solution.id) && Objects.equals(name, solution.name) && Objects.equals(description, solution.description) && Objects.equals(minCost, solution.minCost) && Objects.equals(maxCost, solution.maxCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, minCost, maxCost);
    }
}

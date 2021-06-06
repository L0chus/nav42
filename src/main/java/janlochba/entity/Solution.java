package janlochba.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table( name = "solution", schema = "nav42")
public class Solution {
    private Integer id;
    private String name;
    private String description;
    private Double minCost;
    private Double maxCost;
    private List<Issue> issues;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @NotNull
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @NotNull
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @NotNull
    @Column(name = "min_cost")
    public Double getMinCost() {
        return minCost;
    }

    public void setMinCost(Double minCost) {
        this.minCost = minCost;
    }

    @Basic
    @NotNull
    @Column(name = "max_cost")
    public Double getMaxCost() {
        return maxCost;
    }

    public void setMaxCost(Double maxCost) {
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


    @ManyToMany
    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }
}

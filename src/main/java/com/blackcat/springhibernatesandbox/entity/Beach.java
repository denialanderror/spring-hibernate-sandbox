package com.blackcat.springhibernatesandbox.entity;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AnyMetaDef(name = "BeachItemsMetaDef", metaType = "string", idType = "long",
    metaValues = {
        @MetaValue(value = "BALL", targetEntity = Ball.class),
        @MetaValue(value = "PARASOL", targetEntity = Parasol.class),
        @MetaValue(value = "BUCKET", targetEntity = Bucket.class)
    }
)

@Entity
public class Beach {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @ManyToAny(metaDef = "BeachItemsMetaDef", metaColumn = @Column(name = "type"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(name = "BeachItems", joinColumns = @JoinColumn(name = "fk_beach"), inverseJoinColumns = @JoinColumn(name = "fk_items"))
    @Filter(name = "ItemTypeFilter", condition = "type = :type")
    private List<Item> items = new ArrayList<>();

    public List<Ball> getBalls() {
        return filterToType(items, Ball.class);
    }

    public void setBalls(List<Ball> balls) {
        items.addAll(balls);
    }

    public List<Parasol> getParasols() {
        return filterToType(items, Parasol.class);
    }

    public void setParasols(List<Parasol> parasols) {
        items.addAll(parasols);
    }

    public List<Bucket> getBuckets() {
        return filterToType(items, Bucket.class);
    }

    public void setBuckets(List<Bucket> buckets) {
        items.addAll(buckets);
    }

    private <T> List<T> filterToType(List<? super T> list, Class<T> clazz) {
        return list.stream().filter(clazz::isInstance).map(clazz::cast).collect(Collectors.toList());
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

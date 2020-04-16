package org.lab9.entity;

import javax.persistence.*;

@Entity
@Table(name = "artists")
@NamedQuery(name ="Artist.findByName",
            query = "select a from Artist a where a.name =:name")
public class Artist {
    public int id;
    public String name;
    public String country;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

}

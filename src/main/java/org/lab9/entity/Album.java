package org.lab9.entity;

import javax.persistence.*;
@Entity
@Table(name = "albums")
@NamedQueries({
        @NamedQuery(name = "Album.findAlbumByArtistId",
                query = "select a from Album a where a.artistId =:artistId"),
        @NamedQuery(name="Album.findByName",
                    query = "select a from Album a where a.name =:name")
})
public class Album {
    public int id;
    public String name;
    public int artistId;
    public int releaseYear;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "artist_id")
    public int getArtistId() {
        return artistId;
    }
    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    @Column(name = "release_year")
    public int getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}

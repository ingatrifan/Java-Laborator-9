package org.lab9.app;


import org.lab9.entity.Album;
import org.lab9.entity.Artist;
import org.lab9.repo.AlbumRepository;
import org.lab9.repo.ArtistRepository;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        Artist artist = new Artist();
        artist.setName("artist1");
        artist.setCountry("country1");
        ArtistRepository.create(artist);
        Artist artist1 = new Artist();
        artist1.setName("artist2");
        artist1.setCountry("country2");
        ArtistRepository.create(artist1);
        Album album = new Album();
        album.setName("album1");
        album.setArtistId(50);
        album.setReleaseYear(2000);
        AlbumRepository.create(album);
        Album album1 = new Album();
        album1.setName("album2");
        album1.setArtistId(50);
        album1.setReleaseYear(2010);
        AlbumRepository.create(album1);
        List<Artist> artist2 = ArtistRepository.findByName("artist2");
        for(Artist artistt: artist2)
            System.out.println(artistt.getCountry());
        List<Album> albumList = AlbumRepository.findByArtistId(50);
        for(Album album2 : albumList){
            System.out.println(album2.getName());
        }
    }
}

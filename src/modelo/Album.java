package modelo;

import javax.persistence.*;

@Entity
public class Album {
    
    @Id
    @SequenceGenerator(name="sec_album", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sec_album")
    private Long id;
    
    private String nombre;
    
    // muchos álbumes se relacionan con el mismo artista
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Artista artista;
    
    // muchos álbumes se relacionan con el mismo Spotify
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Spotify spotify;



    // constructor nulo (necesario)
    public Album() {
    }


    // contructor con parámetros
    public Album(String nombre, Artista artista, Spotify spotify) {
        this.nombre = nombre;
        this.artista = artista;
        this.spotify = spotify;
    }
    
    
    // getters y setters
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Artista getArtista() {
        return this.artista;
    }
    
    public void setArtista(Artista artista) {
        this.artista = artista;
    }
    
    @Override
    public String toString() {
        return this.nombre;
    }
    
}

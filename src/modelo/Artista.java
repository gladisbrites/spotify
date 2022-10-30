package modelo;

import java.util.*;
import javax.persistence.*;

@Entity
public class Artista {
    
    @Id
    @SequenceGenerator(name="sec_artista", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sec_artista")
    private Long id;
    
    private String nombre;

    // un artista se relaciona con muchos álbumes
    @OneToMany(mappedBy="artista")
    private Set<Album> albumes;
    
    // muchos artistas se relacionan con muchas discográficas
    @ManyToMany(mappedBy="artistas", fetch = FetchType.EAGER)
    private Set<Discografica> discograficas;

    // muchos artistas se relacionan con el mismo Spotify
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Spotify spotify;



    // contructor nulo (necesario)
    public Artista() {
        this.albumes = new HashSet();
        this.discograficas = new HashSet();
    }


    // contructor con parámetros
    public Artista(String nombre, Spotify spotify) {
        this();
        this.nombre = nombre;
        this.spotify = spotify;
    }
    
    
    // getters y setters
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Set<Album> getAlbumes() {
        return this.albumes;
    }
    
    public void setAlbumes(Set<Album> albumes) {
        this.albumes = albumes;
    }
    
    public Set<Discografica> getDiscograficas() {
        return this.discograficas;
    }
    
    public void setDiscograficas(Set<Discografica> discograficas) {
        this.discograficas = discograficas;
    }

    
    // gestión de colecciones
    public void agregarAlbum(Album album) {
        this.albumes.add(album);
    }
    
    public void quitarAlbum(Album album) {
        this.albumes.remove(album);
    }
    
    public void agregarDiscografica(Discografica discografica) {
        this.discograficas.add(discografica);
    }
    
    public void quitarDiscografica(Discografica discografica) {
        this.discograficas.remove(discografica);
    }
    

    
    @Override
    public String toString() {
        return this.nombre;
    }
    
}

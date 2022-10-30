package modelo;

import java.util.*;
import javax.persistence.*;

@Entity
public class Discografica {

    @Id
    @SequenceGenerator(name="sec_discografica", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sec_discografica") 
    private Long id;

    private String nombre;

    
    // muchas discográficas se relacionan con muchos artistas
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "artista_discografica", joinColumns = @JoinColumn(name = "discografica_id"), inverseJoinColumns =
        @JoinColumn(name = "artista_id"))
    private Set<Artista> artistas;
    
    // muchas discográficas se relacionan con el mismo Spotify
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Spotify spotify;



    // contructor nulo (necesario)
    public Discografica() {
        this.artistas = new HashSet();
    }


    // contructor con parámetros
    public Discografica(String nombre, Spotify spotify) {
        this();
        this.nombre = nombre;
        this.spotify = spotify;
    }
    
    
    // getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(Set<Artista> artistas) {
        this.artistas = artistas;
    }

    
    // gestión de colecciones
    public void agregarArtista(Artista a) {
        this.artistas.add(a);
    }
    
    public void quitarArtista(Artista a) {
        this.artistas.remove(a);
    }
    
    

    @Override
    public String toString() {
        return this.nombre;
    }
    
}

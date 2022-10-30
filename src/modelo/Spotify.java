package modelo;

import java.util.*;
import javax.persistence.*;
import persistencia.Persistencia;

@Entity
public class Spotify {
    
    @Id
    private Long id;
    
    private String nombre;
    
    private static Persistencia persistencia;
    
    // Spotify conoce a todos los artistas
    @OneToMany(mappedBy="spotify")
    private Set<Artista> artistas;
    
    // Spotify conoce a todos los álbumes
    @OneToMany(mappedBy="spotify")
    private Set<Album> albumes;
    
    // Spotify conoce a todas las discográficas
    @OneToMany(mappedBy="spotify")
    private Set<Discografica> discograficas;



    // contructor nulo (necesario)
    public Spotify() {
    }


    // contructor con parámetros
    public Spotify(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        
        // cuando se construye al Spotify,
        // se guarda en la base de datos a sí mismo
        Spotify.persistencia.insertar(this);
    }
    
    
    // getters y setters
    static {
        persistencia = new Persistencia();
    }
    
    public static Persistencia getPersistencia() {
        return persistencia;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Set<Artista> getArtistas() {
        return this.artistas;
    }
    
    public void setArtistas(Set<Artista> artistas) {
        this.artistas = artistas;
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

    
    
    // Spotify se encarga de la gestión de artistas
    public void crearArtista(String nombre) {
        Artista artista = new Artista(nombre, this);
        this.artistas.add(artista);
        Spotify.getPersistencia().insertar(artista);
    }

    public void modificarArtista(Artista artista, String nombre) {
        if (artista != null) {
            artista.setNombre(nombre);
            Spotify.getPersistencia().modificar(artista);
        }
    }

    public void eliminarArtista(Artista artista) {
        if (artista != null) {
            Spotify.getPersistencia().eliminar(artista);
        }
    }

    
    
    // Spotify se encarga de la gestión de álbumes
    public void crearAlbum(String nombre, Artista artista) {
        Album album = new Album(nombre, artista, this);
        this.albumes.add(album);
        Spotify.getPersistencia().insertar(album);

        
        // el artista tiene que conocer a su álbum
        artista.agregarAlbum(album);
        Spotify.getPersistencia().modificar(artista);
    }

    public void modificarAlbum(Album album, String nombre, Artista nuevo) {
        if (album != null) {
            album.setNombre(nombre);
            
            Artista viejo = album.getArtista();
            
            //si cambio de artista...
            if (! nuevo.equals(viejo)) {
                viejo.quitarAlbum(album);
                Spotify.getPersistencia().modificar(viejo);
                
                nuevo.agregarAlbum(album);
                Spotify.getPersistencia().modificar(nuevo);
                
                album.setArtista(nuevo);
            }
                
            Spotify.getPersistencia().modificar(album);
        }
    }

    public void eliminarAlbum(Album album) {
        if (album != null) {
            // primero aviso al artista que se desvincule
            Artista artista = album.getArtista();
            artista.quitarAlbum(album);
            Spotify.getPersistencia().modificar(artista);
            
            Spotify.getPersistencia().eliminar(album);
        }
    }

    
    
    // Spotify se encarga de la gestión de discográficas
    public void crearDiscografica(String nombre) {
        Discografica discografica = new Discografica(nombre, this);
        this.discograficas.add(discografica);
        Spotify.getPersistencia().insertar(discografica);
    }

    public void modificarDiscografica(Discografica discografica, String nombre) {
        if (discografica != null) {
            discografica.setNombre(nombre);
            Spotify.getPersistencia().modificar(discografica);
        }
    }

    public void eliminarDiscografica(Discografica discografica) {
        if (discografica != null) {
            Spotify.getPersistencia().eliminar(discografica);
        }
    }
    
    public void relacionar(Artista artista, Discografica discografica) {
        if (artista != null && discografica != null) {
            artista.agregarDiscografica(discografica);
            Spotify.getPersistencia().modificar(artista);

            discografica.agregarArtista(artista);
            Spotify.getPersistencia().modificar(discografica);
        }
    }
    
}

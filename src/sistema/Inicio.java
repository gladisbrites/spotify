package sistema;

import modelo.Spotify;
import vistas.Principal;

public class Inicio {
    
    public static void main(String[] args) {
        Spotify s = (Spotify) Spotify.getPersistencia().buscar(Spotify.class, 1L);
        
        if (s == null)
            s = new Spotify(1, "Spotify misionero");
        
        Principal ventana = new Principal(s);
        ventana.setVisible(true);
    }
    
}

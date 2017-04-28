package mx.lfa.com.rawrstudio.models;

/**
 * Created by Tonatiuh on 23/04/2017.
 */

public class PlaybyPlay {
    private String equipo, oportunidad, bolaen, jugada;

    public PlaybyPlay() {

    }

    public PlaybyPlay(String equipo, String oportunidad, String bolaen, String jugada) {
        this.equipo = equipo;
        this.oportunidad = oportunidad;
        this.bolaen = bolaen;
        this.jugada = jugada;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getOportunidad() {
        return oportunidad;
    }

    public void setOportunidad(String oportunidad) {
        this.oportunidad = oportunidad;
    }

    public String getBolaen() {
        return bolaen;
    }

    public void setBolaen(String bolaen) {
        this.bolaen = bolaen;
    }

    public String getJugada() {
        return jugada;
    }

    public void setJugada(String jugada) {
        this.jugada = jugada;
    }

}

package ut2.ficheros.alianzarebelde;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Personaje {

    private String nombre;
    private String rango;

    // Constructor vacío necesario para JAXB
    public Personaje() {
    }

    // Constructor con parámetros
    public Personaje(String nombre, String rango) {
        this.nombre = nombre;
        this.rango = rango;
    }

    // Getter del nombre
    @XmlElement
    public String getNombre() {
        return nombre;
    }

    // Setter del nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter del rango
    @XmlElement
    public String getRango() {
        return rango;
    }

    // Setter del rango
    public void setRango(String rango) {
        this.rango = rango;
    }
}
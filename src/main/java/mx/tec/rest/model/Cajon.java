package mx.tec.rest.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Cajon")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cajon {
    @XmlElement
    private int idCajon;
    @XmlElement
    private String seccion;
    @XmlElement
    private String numero;
    @XmlElement
    private int ocupado;
    @XmlElement
    private int idUsuario;
    @XmlElement
    private int posicion;
    @XmlElement
    private int tipo;

    @Override
    public String toString() {
        return "Cajon{" +
                "idCajon=" + idCajon +
                ", seccion='" + seccion + '\'' +
                ", numero='" + numero + '\'' +
                ", ocupado=" + ocupado +
                ", idUsuario=" + idUsuario +
                ", posicion=" + posicion +
                ", tipo=" + tipo +
                '}';
    }

    public int getIdCajon() {
        return idCajon;
    }

    public void setIdCajon(int idCajon) {
        this.idCajon = idCajon;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getOcupado() {
        return ocupado;
    }

    public void setOcupado(int ocupado) {
        this.ocupado = ocupado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
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
    private int posicionX;
    @XmlElement
    private int posicionY;
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
                ", posicionX=" + posicionX +
                ", posicionY=" + posicionY +
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

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
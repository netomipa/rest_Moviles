package mx.tec.rest.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Usuario")
@XmlAccessorType(XmlAccessType.FIELD)
public class Usuario {
    @XmlElement
    private int idUsuario;
    @XmlElement
    private String correo;
    @XmlElement
    private String password;

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

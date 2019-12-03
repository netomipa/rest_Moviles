package mx.tec.rest.service;

import mx.tec.rest.model.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> findUsuarios();
    Usuario findUsuarioById(int idUsuario);
    boolean validarUsuario(String correo);
    Usuario validarSesion(Usuario usuario);
    boolean deleteUsuario(int idUsuario);
    boolean createUsuario(Usuario usuario);
    boolean editUsuario(Usuario usuario);
}

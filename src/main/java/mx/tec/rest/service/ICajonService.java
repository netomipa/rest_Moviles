package mx.tec.rest.service;

import mx.tec.rest.model.Cajon;

import java.util.List;

public interface ICajonService {
    List<Cajon> findCajones();
    List<Cajon> findCajonesBySeccion(String seccion);
    Cajon findCajonById(int idCajon);
    boolean deleteCajon(int idCajon);
    boolean saveCajon(Cajon cajon);
    boolean editCajon(Cajon cajon);
    boolean cambiarEstadoByIdUsuario(Cajon cajon);
    boolean ocuparCajon(int idCajon);
    boolean liberarCajon(int idCajon);
}

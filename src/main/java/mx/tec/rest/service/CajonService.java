package mx.tec.rest.service;

import mx.tec.rest.model.Cajon;
import mx.tec.rest.util.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CajonService implements ICajonService {
    @Override
    public List<Cajon> findCajones() {
        String sql = "SELECT idCajon, seccion, numero, ocupado, idUsuario, posicionX, posicionY, tipo FROM Cajon";
        List<Cajon> cajones = new ArrayList<>();
        try {
            Connection conexion = Conexion.getConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                Cajon cajon = new Cajon();
                cajon.setIdCajon(resultSet.getInt("idCajon"));
                cajon.setSeccion(resultSet.getString("seccion"));
                cajon.setNumero(resultSet.getString("numero"));
                cajon.setOcupado(resultSet.getInt("ocupado"));
                cajon.setIdUsuario(resultSet.getInt("idUsuario"));
                cajon.setPosicionX(resultSet.getInt("posicionX"));
                cajon.setPosicionY(resultSet.getInt("posicionY"));
                cajon.setTipo(resultSet.getInt("tipo"));
                cajones.add(cajon);
            }
            conexion.close();
            preparedStatement.close();
            resultSet.close();
        }catch (Exception ex){
            System.out.println(this.getClass().getCanonicalName() + " " + ex.getMessage());
        }
        return cajones;
    }

    @Override
    public List<Cajon> findCajonesBySeccion(String seccion) {
        String sql = "SELECT idCajon, seccion, numero, ocupado, idUsuario, posicionX, posicionY, tipo FROM Cajon WHERE seccion = ?";
        List<Cajon> cajones = new ArrayList<>();
        try {
            Connection conexion = Conexion.getConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, seccion);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                Cajon cajon = new Cajon();
                cajon.setIdCajon(resultSet.getInt("idCajon"));
                cajon.setSeccion(resultSet.getString("seccion"));
                cajon.setNumero(resultSet.getString("numero"));
                cajon.setOcupado(resultSet.getInt("ocupado"));
                cajon.setIdUsuario(resultSet.getInt("idUsuario"));
                cajon.setPosicionX(resultSet.getInt("posicionX"));
                cajon.setPosicionY(resultSet.getInt("posicionY"));
                cajon.setTipo(resultSet.getInt("tipo"));
                cajones.add(cajon);
            }
            conexion.close();
            preparedStatement.close();
            resultSet.close();
        }catch (Exception ex){
            System.out.println(this.getClass().getCanonicalName() + " " + ex.getMessage());
        }
        return cajones;
    }

    @Override
    public Cajon findCajonById(int idCajon) {
        String sql = "SELECT idCajon, seccion, numero, ocupado, idUsuario, posicionX, posicionY, tipo FROM Cajon WHERE idCajon=?";
        Cajon cajon = new Cajon();
        try {
            Connection conexion = Conexion.getConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, idCajon);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            cajon.setIdCajon(resultSet.getInt("idCajon"));
            cajon.setSeccion(resultSet.getString("seccion"));
            cajon.setNumero(resultSet.getString("numero"));
            cajon.setOcupado(resultSet.getInt("ocupado"));
            cajon.setIdUsuario(resultSet.getInt("idUsuario"));
            cajon.setPosicionX(resultSet.getInt("posicionX"));
            cajon.setPosicionY(resultSet.getInt("posicionY"));
            cajon.setTipo(resultSet.getInt("tipo"));
            conexion.close();
            preparedStatement.close();
            resultSet.close();
        }catch (Exception ex)
        {
            System.out.println(this.getClass().getCanonicalName() + " " + ex.getMessage());
        }

        return cajon;
    }

    @Override
    public boolean deleteCajon(int idCajon) {
        String sql = "DELETE FROM Cajon WHERE idCajon=?";
        Boolean result = false;
        try {
            Connection conexion = Conexion.getConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1,idCajon);
            preparedStatement.execute();
            result = true;
            conexion.close();
            preparedStatement.close();
        }catch (Exception ex)
        {
            System.out.println(this.getClass().getCanonicalName() + " " + ex.getMessage());
        }
        return result;
    }

    @Override
    public boolean saveCajon(Cajon cajon) {
        String sql = "INSERT INTO Cajon(seccion, numero, ocupado, idUsuario, posicionX, posicionY, tipo) VALUES(?,?,?,?,?,?,?)";
        boolean resultado = false;
        try {
            Connection conexion = Conexion.getConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, cajon.getSeccion());
            preparedStatement.setString(2, cajon.getNumero());
            preparedStatement.setInt(3, cajon.getOcupado());
            preparedStatement.setInt(4, cajon.getIdUsuario());
            preparedStatement.setInt(5, cajon.getPosicionX());
            preparedStatement.setInt(6, cajon.getPosicionY());
            preparedStatement.setInt(7, cajon.getTipo());
            preparedStatement.execute();
            resultado = true;
            conexion.close();
            preparedStatement.close();
        }catch (Exception ex)
        {
            System.out.println(this.getClass().getCanonicalName() + " " + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean editCajon(Cajon cajon) {
        System.out.println("Entro a edit " + cajon.toString());
        String sql = "UPDATE Cajon SET seccion=?, numero=?, ocupado=?, idUsuario=?, posicionX=?, posicionY=?, tipo=? WHERE idCajon=?";
        boolean resultado = false;

        try {
            Connection conexion = Conexion.getConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, cajon.getSeccion());
            preparedStatement.setString(2, cajon.getNumero());
            preparedStatement.setInt(3, cajon.getOcupado());
            preparedStatement.setInt(4, cajon.getIdUsuario());
            preparedStatement.setInt(5, cajon.getPosicionX());
            preparedStatement.setInt(6, cajon.getPosicionY());
            preparedStatement.setInt(7, cajon.getTipo());
            preparedStatement.setInt(8, cajon.getIdCajon());
            preparedStatement.execute();
            resultado = true;
            conexion.close();
            preparedStatement.close();
        }catch (Exception ex)
        {
            System.out.println(this.getClass().getCanonicalName() + " " + ex.getMessage());
        }

        return resultado;
    }

    @Override
    public boolean cambiarEstadoByIdUsuario(Cajon cajon) {
        String sql = "UPDATE Cajon SET ocupado=?, idUsuario=? WHERE idCajon=?";
        boolean resultado = false;
        Cajon cajondb = new CajonService().findCajonById(cajon.getIdCajon());
        System.out.println("cajon_in: " + cajon.toString());
        System.out.println("cajon_db: " + cajondb.toString());
        try {
            Connection conexion = Conexion.getConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            if(cajondb.getOcupado() == 0)
            {
                System.out.println("Estado: libre");
                preparedStatement.setInt(1, 1);
                preparedStatement.setInt(2, cajon.getIdUsuario());
            }else if(cajondb.getIdUsuario() == 1)
            {
                System.out.println("Ocupado sin dueño");
                preparedStatement.setInt(1, 1);
                preparedStatement.setInt(2, cajon.getIdUsuario());
            }else
            {
                System.out.println("Ocupado con dueño");
                preparedStatement.setInt(1, 0);
                preparedStatement.setInt(2, 1);
            }
            preparedStatement.setInt(3, cajon.getIdCajon());
            preparedStatement.execute();
            resultado = true;
            conexion.close();
            preparedStatement.close();
        }catch (Exception ex)
        {
            System.out.println(this.getClass().getCanonicalName() + " " + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean ocuparCajon(int idCajon) {
        return cambiarEstado(1, idCajon);
    }

    @Override
    public boolean liberarCajon(int idCajon) {
        return cambiarEstado(0, idCajon);
    }

    private boolean cambiarEstado(int estado, int idCajon)
    {
        String sql = "UPDATE Cajon SET ocupado=?, idUsuario=? WHERE idCajon=?";
        boolean resultado = false;
        try {
            Connection conexion = Conexion.getConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, estado);
            preparedStatement.setInt(2,1);
            preparedStatement.setInt(3, idCajon);
            preparedStatement.execute();
            resultado = true;

            conexion.close();
            preparedStatement.close();
        }catch (Exception ex)
        {
            System.out.println(this.getClass().getCanonicalName() + " " + ex.getMessage());
        }
        return resultado;
    }

}

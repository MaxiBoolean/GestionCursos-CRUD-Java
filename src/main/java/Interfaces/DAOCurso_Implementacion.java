package Interfaces;

import Main.Main;
import Modelo.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DAOCurso_Implementacion implements DAOCurso {

    Main main = new Main();

    public DAOCurso_Implementacion() {

    }

    @Override
    public void registrar(Curso curso) {
        try {
            Connection conectar = main.establecerConeccion();

            PreparedStatement insertar = conectar.prepareStatement("INSERT INTO cursos(curso, area, precio) VALUES(?,?,?)");

            insertar.setString(1, curso.getCurso());
            insertar.setString(2, curso.getArea());
            insertar.setString(3, curso.getPrecio());

            insertar.executeUpdate();
            insertar.close();
            conectar.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void modificar(Curso curso) {
        try {
            Connection conectar = main.establecerConeccion();

            PreparedStatement modificar = conectar.prepareStatement("UPDATE cursos SET curso = ?, area = ?, precio = ? where id = ?");

            modificar.setString(1, curso.getCurso());
            modificar.setString(2, curso.getArea());
            modificar.setString(3, curso.getPrecio());
            modificar.setInt(4, curso.getId());

            modificar.executeUpdate();

            modificar.close();
            conectar.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void eliminar(Curso curso) {

        try {
            Connection conectar = main.establecerConeccion();

            PreparedStatement eliminar = conectar.prepareStatement("DELETE FROM cursos where id = ?");

            eliminar.setInt(1, curso.getId());

            eliminar.executeUpdate();

            eliminar.close();
            conectar.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

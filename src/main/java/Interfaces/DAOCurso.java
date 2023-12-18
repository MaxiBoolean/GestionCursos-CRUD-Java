package Interfaces;

import Modelo.Curso;

public interface DAOCurso {

    public void registrar(Curso curso);

    public void modificar(Curso curso);

    public void eliminar(Curso curso);

}

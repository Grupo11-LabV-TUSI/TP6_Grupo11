package utnfrgp.dao;

import java.util.List;
import utnfrgp.entidad.Horario;

public interface IDaoHorario {
    public boolean add(Horario horario);
    public Horario readOne(int idHorario);
    public boolean exist(int idHorario);
    public boolean update(Horario horario);
    public boolean delete(Horario horario);
    public List<Horario> readAll();
}

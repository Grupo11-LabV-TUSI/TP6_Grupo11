package utnfrgp.dao;

import java.util.List;
import utnfrgp.entidad.Medico;

public interface IDaoMedico {
    public boolean add(Medico medico);
    public Medico readOne(Long matriculaMedico);
    public boolean exist(Long matriculaMedico);
    public boolean update(Medico medico);
    public boolean delete(Medico medico);
    public List<Medico> readAll();
}

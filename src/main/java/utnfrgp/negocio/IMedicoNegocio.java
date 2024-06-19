package utnfrgp.negocio;

import java.util.List;
import utnfrgp.entidad.Medico;

public interface IMedicoNegocio {
    public boolean add(Medico medico);
    public Medico readOne(Long matriculaMedico);
    public boolean exist(Long matriculaMedico);
    public boolean update(Medico medico);
    public boolean delete(Medico medico);
    public List<Medico> readAll();
}
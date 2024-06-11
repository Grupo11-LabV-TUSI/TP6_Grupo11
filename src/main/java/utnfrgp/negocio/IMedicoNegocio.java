package utnfrgp.negocio;

import java.util.List;
import utnfrgp.entidad.Medico;

public interface IMedicoNegocio {
    public boolean add(Medico medico);
    public Medico readOne(Long id);
    public boolean exist(Long id);
    public boolean update(Medico medico);
    public boolean delete(Medico medico);
    public List<Medico> readAll();
}
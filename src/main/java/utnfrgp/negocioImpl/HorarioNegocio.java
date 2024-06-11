package utnfrgp.negocioImpl;

import java.util.List;
import utnfrgp.dao.IDaoHorario;
import utnfrgp.entidad.Horario;
import utnfrgp.negocio.IHorarioNegocio;

public class HorarioNegocio implements IHorarioNegocio {

    private IDaoHorario daoHorario;

    public HorarioNegocio() {}

    public HorarioNegocio(IDaoHorario daoHorario) {
        this.daoHorario = daoHorario;
    }

    public IDaoHorario getDaoHorario() {
        return daoHorario;
    }

    public void setDaoHorario(IDaoHorario daoHorario) {
        this.daoHorario = daoHorario;
    }

    public boolean add(Horario horario) {
        return daoHorario.add(horario);
    }

    public Horario readOne(int idHorario) {
        return daoHorario.readOne(idHorario);
    }

    public boolean exist(int idHorario) {
        return daoHorario.exist(idHorario);
    }

    public boolean update(Horario horario) {
        return daoHorario.update(horario);
    }

    public boolean delete(Horario horario) {
        return daoHorario.delete(horario);
    }

    public List<Horario> readAll() {
        return daoHorario.readAll();
    }
}

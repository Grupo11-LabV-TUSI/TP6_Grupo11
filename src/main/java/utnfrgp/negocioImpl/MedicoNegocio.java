package utnfrgp.negocioImpl;

import java.util.List;
import utnfrgp.dao.IDaoMedico;
import utnfrgp.entidad.Medico;
import utnfrgp.negocio.IMedicoNegocio;

public class MedicoNegocio implements IMedicoNegocio {

    private IDaoMedico daoMedico;

    public MedicoNegocio() {
    }

    public MedicoNegocio(IDaoMedico daoMedico) {
        this.daoMedico = daoMedico;
    }

    public IDaoMedico getDaoMedico() {
        return daoMedico;
    }

    public void setDaoMedico(IDaoMedico daoMedico) {
        this.daoMedico = daoMedico;
    }

    public boolean add(Medico medico) {
        return daoMedico.add(medico);
    }

    public Medico readOne(Long id) {
        return daoMedico.readOne(id);
    }

    public boolean exist(Long id) {
        return daoMedico.exist(id);
    }

    public boolean update(Medico medico) {
        return daoMedico.update(medico);
    }

    public boolean delete(Medico medico) {
        return daoMedico.delete(medico);
    }

    public List<Medico> readAll() {
        return daoMedico.readAll();
    }
}
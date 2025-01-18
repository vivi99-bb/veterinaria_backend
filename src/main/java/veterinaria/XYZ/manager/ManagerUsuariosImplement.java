package veterinaria.XYZ.manager;

import org.springframework.stereotype.Component;
import veterinaria.XYZ.dao.UsuariosDao;
import veterinaria.XYZ.dto.Usuarios;
import veterinaria.XYZ.exception.DaoException;
import veterinaria.XYZ.exception.ManageException;

import java.util.List;
import java.util.Map;

@Component
public class ManagerUsuariosImplement implements ManagerUsuarios {


    private UsuariosDao usuariosDao;

    public ManagerUsuariosImplement(UsuariosDao usuariosDao, ManagerUsuarios managerUsuarios) {
        this.usuariosDao = usuariosDao;
    }

    public void crear(Usuarios usuarios)  throws ManageException {

        Usuarios userDato = null;

        try {
            userDato = usuariosDao.selectById(usuarios);
            if(userDato==null){
                usuariosDao.insert(usuarios);
            }else{
                usuariosDao.update(usuarios);

            }
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch(Exception ex){
            throw new ManageException(ex.getMessage());
        }
    }


    public Usuarios selectByid(Usuarios usuarios) throws ManageException {
        Usuarios userDato = null;

        try{
            userDato =usuariosDao.selectById(usuarios);

        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }
        return userDato;
    }

    public List<Map<String, Object>> selectAll() throws ManageException{
        try{
            return this.usuariosDao.selectAll();
        } catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        } catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }

    }


    public void delete(Usuarios usuarios) throws ManageException{
        try{
            if(usuarios.getId()!=null) {
                usuariosDao.delete(usuarios);
            }
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }
    }
}

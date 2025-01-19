package veterinaria.XYZ.business;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import veterinaria.XYZ.dto.Usuarios;
import veterinaria.XYZ.exception.BusinessException;
import veterinaria.XYZ.exception.ManageException;
import veterinaria.XYZ.manager.ManagerUsuarios;

import java.util.List;
import java.util.Map;

@Component
public class BusinessUsuariosImplement implements  BusinessUsuarios{

    private ManagerUsuarios managerUsuarios;

    public BusinessUsuariosImplement(ManagerUsuarios managerUsuarios){
        this.managerUsuarios = managerUsuarios;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void registrar(Usuarios usuarios) throws BusinessException {
        try{
            managerUsuarios.crear(usuarios);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public Usuarios selectById(Usuarios usuarios) throws BusinessException{
        Usuarios userData=null;
        try{
            userData = managerUsuarios.selectById(usuarios);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }
        return userData;
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> selectAll() throws BusinessException{
        try{

            return  this.managerUsuarios.selectAll();
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }

    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void delete( Usuarios usuarios ) throws BusinessException{
        try{
            this.managerUsuarios.delete(usuarios);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }
    }
}

package veterinaria.XYZ.manager;

import org.springframework.stereotype.Component;
import veterinaria.XYZ.dao.TutorDao;
import veterinaria.XYZ.dto.Tutor;
import veterinaria.XYZ.exception.DaoException;
import veterinaria.XYZ.exception.ManageException;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class ManagerTutorImplement implements  ManagerTutor {

    private TutorDao tutorDao;

    public ManagerTutorImplement(TutorDao tutorDao) {
        this.tutorDao = tutorDao;
    }

    public void crear(Tutor tutor) throws ManageException{
        if (tutor.getId() == null || tutor.getId().isEmpty()) {
            tutor.setId(UUID.randomUUID().toString());
        }

        Tutor tutorDato= null;
        try {
            tutorDato = tutorDao.selectById(tutor);
            if(tutorDato==null){
                tutorDao.insert(tutor);
            }else{
                tutorDao.update(tutor);

            }
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch(Exception ex){
            throw new ManageException(ex.getMessage());
        }
    }

    public Tutor selectById(Tutor tutor) throws ManageException {
        Tutor tutorDato= null;

        try{
            tutorDato =tutorDao.selectById(tutor);

        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }
        return tutorDato;
    }

    public List<Map<String, Object>> selectAll() throws ManageException{
        try{
            return this.tutorDao.selectAll();
        } catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        } catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }

    }

    public void delete(Tutor tutor) throws ManageException{
        try{
            if(tutor.getId()!=null) {
                tutorDao.delete(tutor);
            }
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }
    }

}

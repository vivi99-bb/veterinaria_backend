package veterinaria.XYZ.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import veterinaria.XYZ.business.BusinessTutor;
import veterinaria.XYZ.dto.Tutor;
import veterinaria.XYZ.dto.Usuarios;
import veterinaria.XYZ.mensaje.ResponseMessage;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/tutor/")
public class TutorController {

    private BusinessTutor businessTutor;

    public TutorController(BusinessTutor businessTutor) {
        this.businessTutor = businessTutor;
    }

    @PostMapping({"/guardar"})
    public ResponseEntity<ResponseMessage<Tutor>> saveOrUpdate(@Valid @RequestBody Tutor request) {
        log.debug("REST request to saveOrUpdate Usuario: {}", request);
        ResponseMessage<Tutor> message;
        try {
            this.businessTutor.registrar(request);
            message = new ResponseMessage<>(HttpStatus.OK.value(),"Operación exitosa", request);
        } catch (Exception ex) {
            log.error("Error en saveOrUpdate Usuario: {}", ex.getMessage());
            message = new ResponseMessage<>(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request);
        }
        return ResponseEntity.status(message.getCode() == 200 ? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(message);
    }


    @PostMapping({"/selectById"})
    public ResponseEntity<ResponseMessage<Tutor>> selectById(@RequestBody Tutor request) {
        log.debug("REST request to saveOrUpdate User : {}", request);
        ResponseMessage message = null;
        try {
            Tutor tutorfound= this.businessTutor.selectById(request);
            message = new ResponseMessage<>(200, "selectById, process successful ", tutorfound);
        } catch (Exception ex) {
            message = new ResponseMessage<>(406, ex.getMessage(), null);
        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("/selectAll")
    public ResponseEntity<ResponseMessage>  selectAll(){
        List<Map<String, Object>> list =null;
        ResponseMessage message = null;
        try {
            list = this.businessTutor.selectAll();
            message = new ResponseMessage<>(200, "selectAll, process successful ", list);

        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(), null);
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseMessage<Tutor>> deleteById(@RequestBody Tutor request) {
        log.debug("REST request to deleteById User : {}", request);
        ResponseMessage message = null;
        try {
            this.businessTutor.delete(request);
            message = new ResponseMessage<>(200, "selectAll, process successful ", request);

        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(), null);
        }
        return ResponseEntity.ok(message);
    }
}

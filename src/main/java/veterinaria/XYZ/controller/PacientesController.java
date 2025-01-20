package veterinaria.XYZ.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import veterinaria.XYZ.business.BusinessPaciente;
import veterinaria.XYZ.dto.Paciente;
import veterinaria.XYZ.dto.Usuarios;
import veterinaria.XYZ.mensaje.ResponseMessage;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/pacientes/")
public class PacientesController {

    private BusinessPaciente businessPaciente;

    public PacientesController(BusinessPaciente businessPaciente) {
        this.businessPaciente = businessPaciente;
    }

    @PostMapping({"/guardar-actualizar"})
    public ResponseEntity<ResponseMessage<Paciente>> saveOrUpdate(@Valid @RequestBody Paciente request) {
        log.debug("REST request to saveOrUpdate Usuario: {}", request);
        ResponseMessage<Paciente> message;
        try {
            this.businessPaciente.registrar(request);
            message = new ResponseMessage<>(HttpStatus.OK.value(),
                    "Operación exitosa", request);
        } catch (Exception ex) {
            log.error("Error en saveOrUpdate Usuario: {}", ex.getMessage());
            message = new ResponseMessage<>(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request);
        }
        return ResponseEntity.status(message.getCode() == 200 ? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(message);
    }

    @PostMapping({"/selectById"})
    public ResponseEntity<ResponseMessage<Paciente>> selectById(@RequestBody Paciente request) {
        log.debug("REST request to saveOrUpdate User : {}", request);
        ResponseMessage message = null;
        try {
            Paciente     userfound= this.businessPaciente.selectById(request);
            message = new ResponseMessage<>(200, "selectById, process successful ", userfound);
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
            list = this.businessPaciente.selectAll();
            message = new ResponseMessage<>(200, "selectAll, process successful ", list);

        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(), null);
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseMessage<Paciente>> deleteById(@RequestBody Paciente request) {
        log.debug("REST request to deleteById User : {}", request);
        ResponseMessage message = null;
        try {
            this.businessPaciente.delete(request);
            message = new ResponseMessage<>(200, "selectAll, process successful ", request);

        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(), null);
        }
        return ResponseEntity.ok(message);
    }
}

package veterinaria.XYZ.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import veterinaria.XYZ.business.BusinessUsuarios;
import lombok.extern.slf4j.Slf4j;
import veterinaria.XYZ.dto.Usuarios;
import veterinaria.XYZ.mensaje.ResponseMessage;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/user/")
public class UsuariosController {

    private BusinessUsuarios businessUsuario;

    public UsuariosController(BusinessUsuarios businessUsuario) {
        this.businessUsuario = businessUsuario;
    }

    @PostMapping({"/guardar"})
    public ResponseEntity<ResponseMessage<Usuarios>> saveOrUpdate(@Valid @RequestBody Usuarios request) {
        log.debug("REST request to saveOrUpdate Usuario: {}", request);
        ResponseMessage<Usuarios> message;
        try {
            this.businessUsuario.registrar(request);
            message = new ResponseMessage<>(HttpStatus.OK.value(),
                    "Operación exitosa", request);
        } catch (Exception ex) {
            log.error("Error en saveOrUpdate Usuario: {}", ex.getMessage());
            message = new ResponseMessage<>(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request);
        }
        return ResponseEntity.status(message.getCode() == 200 ? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(message);
    }

    @PostMapping({"/selectById"})
    public ResponseEntity<ResponseMessage<Usuarios>> selectById(@RequestBody Usuarios request) {
        log.debug("REST request to saveOrUpdate User : {}", request);
        ResponseMessage message = null;
        try {
            Usuarios userfound= this.businessUsuario.selectById(request);
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
            list = this.businessUsuario.selectAll();
            message = new ResponseMessage<>(200, "selectAll, process successful ", list);

        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(), null);
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseMessage<Usuarios>> deleteById(@RequestBody Usuarios request) {
        log.debug("REST request to deleteById User : {}", request);
        ResponseMessage message = null;
        try {
            this.businessUsuario.delete(request);
            message = new ResponseMessage<>(200, "selectAll, process successful ", request);

        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(), null);
        }
        return ResponseEntity.ok(message);
    }
}

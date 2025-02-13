package br.com.peixeazul.gerenciadorPeixeAzul.controllers;
import br.com.peixeazul.gerenciadorPeixeAzul.models.RegistroQualidadeAgua;
import br.com.peixeazul.gerenciadorPeixeAzul.services.RegistroQualidadeAguaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registros-qualidade-agua")
public class RegistroQualidadeAguaController {

    @Autowired
    private RegistroQualidadeAguaService registroQualidadeAguaService;

    @GetMapping
    public List<RegistroQualidadeAgua> listarTodos() {
        return registroQualidadeAguaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroQualidadeAgua> buscarPorId(@PathVariable Integer id) {
        return registroQualidadeAguaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RegistroQualidadeAgua salvar(@RequestBody RegistroQualidadeAgua registroQualidadeAgua) {
        return registroQualidadeAguaService.salvar(registroQualidadeAgua);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroQualidadeAgua> atualizar(@PathVariable Integer id, @RequestBody RegistroQualidadeAgua registroQualidadeAgua) {
        return registroQualidadeAguaService.buscarPorId(id)
                .map(registroExistente -> {
                    registroQualidadeAgua.setId(id);
                    return ResponseEntity.ok(registroQualidadeAguaService.salvar(registroQualidadeAgua));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        registroQualidadeAguaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
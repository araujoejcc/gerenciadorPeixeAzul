package br.com.peixeazul.fazendaPeixeAzul.controllers;
import br.com.peixeazul.fazendaPeixeAzul.models.Tanque;
import br.com.peixeazul.fazendaPeixeAzul.services.TanqueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tanques")
public class TanqueController {

    @Autowired
    private TanqueService tanqueService;

    @GetMapping
    public List<Tanque> listarTodos() {
        return tanqueService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tanque> buscarPorId(@PathVariable Integer id) {
        return tanqueService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tanque salvar(@Valid @RequestBody Tanque tanque) {
        return tanqueService.salvar(tanque);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tanque> atualizar(@PathVariable Integer id,@Valid @RequestBody Tanque tanque) {
        return tanqueService.buscarPorId(id)
                .map(tanqueExistente -> {
                    tanque.setId(id);
                    return ResponseEntity.ok(tanqueService.salvar(tanque));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        tanqueService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
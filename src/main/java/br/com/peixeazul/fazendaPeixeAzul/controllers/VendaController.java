package br.com.peixeazul.fazendaPeixeAzul.controllers;

import br.com.peixeazul.fazendaPeixeAzul.models.Venda;
import br.com.peixeazul.fazendaPeixeAzul.services.VendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<Venda> listarTodos() {
        return vendaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> buscarPorId(@PathVariable Integer id) {
        return vendaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Venda salvar(@Valid @RequestBody Venda venda) {
        return vendaService.salvar(venda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venda> atualizar(@PathVariable Integer id,@Valid @RequestBody Venda venda) {
        return vendaService.buscarPorId(id)
                .map(vendaExistente -> {
                    venda.setId(id);
                    return ResponseEntity.ok(vendaService.salvar(venda));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        vendaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
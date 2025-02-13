package br.com.peixeazul.gerenciadorPeixeAzul.controllers;
import br.com.peixeazul.gerenciadorPeixeAzul.models.Compra;
import br.com.peixeazul.gerenciadorPeixeAzul.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping
    public List<Compra> listarTodos() {
        return compraService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> buscarPorId(@PathVariable Integer id) {
        return compraService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Compra salvar(@RequestBody Compra compra) {
        return compraService.salvar(compra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> atualizar(@PathVariable Integer id, @RequestBody Compra compra) {
        return compraService.buscarPorId(id)
                .map(compraExistente -> {
                    compra.setId(id);
                    return ResponseEntity.ok(compraService.salvar(compra));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        compraService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
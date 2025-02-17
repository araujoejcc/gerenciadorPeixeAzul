package br.com.peixeazul.fazendaPeixeAzul.controllers;

import br.com.peixeazul.fazendaPeixeAzul.models.CicloProducao;
import br.com.peixeazul.fazendaPeixeAzul.services.CicloProducaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ciclos-producao")
public class CicloProducaoController {

    @Autowired
    private CicloProducaoService cicloProducaoService;

    @GetMapping
    public List<CicloProducao> listarTodos() {
        return cicloProducaoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CicloProducao> buscarPorId(@PathVariable Integer id) {
        return cicloProducaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CicloProducao salvar(@Valid @RequestBody CicloProducao cicloProducao) {
        return cicloProducaoService.salvar(cicloProducao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CicloProducao> atualizar(@PathVariable Integer id,@Valid @RequestBody CicloProducao cicloProducao) {
        return cicloProducaoService.buscarPorId(id)
                .map(cicloExistente -> {
                    cicloProducao.setId(id);
                    return ResponseEntity.ok(cicloProducaoService.salvar(cicloProducao));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        cicloProducaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
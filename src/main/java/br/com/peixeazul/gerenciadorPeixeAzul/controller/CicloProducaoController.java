package br.com.peixeazul.gerenciadorPeixeAzul.controller;

import br.com.peixeazul.gerenciadorPeixeAzul.models.CicloProducao;
import br.com.peixeazul.gerenciadorPeixeAzul.services.CicloProducaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cicloProducao")
public class CicloProducaoController {

    private final CicloProducaoService cicloProducaoService;

    @Autowired
    public CicloProducaoController(CicloProducaoService cicloProducaoService) {
        this.cicloProducaoService = cicloProducaoService;
    }

    @GetMapping
    public Optional<List<CicloProducao>> listarTodos() {
        return cicloProducaoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<CicloProducao> listarPorId(@PathVariable Integer id) {
        return cicloProducaoService.listarPorId(id);
    }

    @PostMapping
    public CicloProducao criar(@RequestBody CicloProducao cicloProducao) {
        return cicloProducaoService.registrarCiclo(cicloProducao);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        cicloProducaoService.excluirCiclo(id);
    }

}

package br.com.peixeazul.gerenciadorPeixeAzul.controller;

import br.com.peixeazul.gerenciadorPeixeAzul.entities.Tanque;
import br.com.peixeazul.gerenciadorPeixeAzul.services.TanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tanques")
public class TanqueController {

    private final TanqueService tanqueService;

    @Autowired
    public TanqueController(TanqueService tanqueService) {
        this.tanqueService = tanqueService;
    }

    @GetMapping
    public Optional<List<Tanque>> listarTodos() {
        return tanqueService.listarTanques();
    }

    @GetMapping("/{id}")
    public Optional<Tanque> listarPorId(@PathVariable Integer id) {
        return tanqueService.buscarPorId(id);
    }

    @PostMapping
    public Tanque criar(@RequestBody Tanque tanque) {
        return tanqueService.salvarTanque(tanque);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        tanqueService.excluirTanque(id);
    }
}
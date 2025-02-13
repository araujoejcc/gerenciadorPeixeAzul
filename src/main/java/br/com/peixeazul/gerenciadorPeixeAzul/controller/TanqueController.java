package br.com.peixeazul.gerenciadorPeixeAzul.controllers;

import br.com.peixeazul.gerenciadorPeixeAzul.models.Tanque;
import br.com.peixeazul.gerenciadorPeixeAzul.services.TanqueService;
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
    public ResponseEntity<List<Tanque>> getAllTanques() {
        return ResponseEntity.ok(tanqueService.getAllTanques());
    }

    @GetMapping("/{id}")
    public Tanque getTanqueById(@PathVariable Integer id) {

        return tanqueService.getTanqueById(id);
    }

    @PostMapping
    public ResponseEntity<TanqueService> createTanque(@Valid @RequestBody Tanque tanque) {
        return ResponseEntity.ok(tanqueService);
    }

    @PutMapping("/{id}")
    public Tanque updateTanque(@PathVariable Integer id, @RequestBody Tanque tanque) {
        return tanqueService.updateTanque(id, tanque);
    }

    @DeleteMapping("/{id}")
    public void deleteTanque(@PathVariable Integer id) {
        tanqueService.deleteTanque(id);
    }
}
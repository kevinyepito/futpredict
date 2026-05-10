package com.futpredict.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futpredict.backend.entity.Equipo;
import com.futpredict.backend.service.EquipoService;

@RestController
@RequestMapping("/api/equipos")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost" })
public class EquipoController {

    private final EquipoService equipoService;
    

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping
    public List<Equipo> getEquipos() {
        return equipoService.getAll();
    }

    @GetMapping("/{id}")
    public Equipo getEquipoById(@PathVariable Long id) {
        return equipoService.getById(id);
    }

    @PostMapping
    public Equipo saveEquipo(@RequestBody Equipo equipo) {
        return equipoService.save(equipo);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipo(@PathVariable Long id) {
        equipoService.delete(id);
    }

    @PutMapping("/{id}")
    public Equipo updateEquipo(@PathVariable Long id, @RequestBody Equipo equipo) {
        return equipoService.update(id, equipo);
    }

}

package com.futpredict.backend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.futpredict.backend.entity.Partido;
import com.futpredict.backend.repository.PartidoRepository;

@Service
public class PartidoService {

    private final PartidoRepository partidoRepository;
    private final IAService iaService;

    public PartidoService(PartidoRepository partidoRepository, IAService iaService) {
        this.partidoRepository = partidoRepository;
        this.iaService = iaService;
    }

    public List<Partido> getAll() {
        return partidoRepository.findAll();
    }

    public Partido getById(Long id) {
        return partidoRepository.findById(id).orElse(null);
    }

    public Partido save(Partido partido) {
        Map<String, Object> datos = new HashMap<>();
        // datos para probar por
        // ahora----------------------------------------------------------
        datos.put("equipo_local", partido.getEquipoLocal().getNombre());
        datos.put("equipo_visitante", partido.getEquipoVisitante().getNombre());
        datos.put("goles_local_promedio", 1.5);
        datos.put("goles_visitante_promedio", 1.2);
        datos.put("tiros_local", 12);
        datos.put("tiros_visitante", 10);
        datos.put("tiros_arco_local", 5);
        datos.put("tiros_arco_visitante", 4);
        datos.put("corners_local", 5);
        datos.put("corners_visitante", 4);
        datos.put("victorias_local", 5);
        datos.put("victorias_visitante", 3);
        // en un try por si falla python que no afecte por
        // acá-----------------------------------
        try {
            Map<String, Object> prediccion = iaService.predecir(datos);

            partido.setProbLocal(toDouble(prediccion.get("prob_local")));
            partido.setProbEmpate(toDouble(prediccion.get("prob_empate")));
            partido.setProbVisitante(toDouble(prediccion.get("prob_visitante")));
            partido.setGoleadorProbable((String) prediccion.get("goleador_probable"));
            partido.setProbGoleador(toDouble(prediccion.get("prob_goleador")));
        } catch (Exception e) {
            // Si el servicio IA no está disponible, guarda el partido sin probabilidades
            System.out.println("Servicio IA no disponible: " + e.getMessage());
            partido.setProbLocal(0.0);
            partido.setProbEmpate(0.0);
            partido.setProbVisitante(0.0);
            partido.setGoleadorProbable("Sin definir");
            partido.setProbGoleador(0.0);
        }

        return partidoRepository.save(partido);
    }

    public void delete(Long id) {
        partidoRepository.deleteById(id);
    }

    public Partido update(Long id, Partido nuevo) {
        Partido existente = partidoRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setEquipoLocal(nuevo.getEquipoLocal());
            existente.setEquipoVisitante(nuevo.getEquipoVisitante());
            existente.setGoleadorProbable(nuevo.getGoleadorProbable());
            existente.setProbEmpate(nuevo.getProbEmpate());
            existente.setProbGoleador(nuevo.getProbGoleador());
            existente.setProbLocal(nuevo.getProbLocal());
            existente.setProbVisitante(nuevo.getProbVisitante());
            existente.setResultado(nuevo.getResultado());

            return partidoRepository.save(existente);
        }

        return null;
    }

    // Convierte Object a double de forma segura
    public double toDouble(Object valor) {
        if (valor instanceof Number)
            return ((Number) valor).doubleValue();
        return 0.0;

    }

}

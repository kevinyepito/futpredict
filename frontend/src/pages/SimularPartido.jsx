import { useState } from "react";

export default function SimularPartido() {

    const [datos, setDatos] = useState({
        equipo_local: "",
        equipo_visitante: "",
        goles_local_promedio: 0,
        goles_visitante_promedio: 0,
        tiros_local: 0,
        tiros_visitante: 0,
        tiros_arco_local: 0,
        tiros_arco_visitante: 0,
        corners_local: 0,
        corners_visitante: 0,
        victorias_local: 0,
        victorias_visitante: 0
    });

    const [resultado, setResultado] = useState(null);

    const handleChange = (e) => {
        const { name, value } = e.target;

        setDatos(prev => ({
            ...prev,
            [name]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await fetch("http://localhost:8080/api/predecir", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(datos)
            });

            const data = await response.json();
            setResultado(data);

        } catch (error) {
            console.error("Error:", error);
        }
    };

    return (
        <div>
            <h1 className="title">Simular Partido ⚽</h1>

            <form onSubmit={handleSubmit}>
                <input name="equipo_local" placeholder="Equipo local" onChange={handleChange} />
                <input name="equipo_visitante" placeholder="Equipo visitante" onChange={handleChange} />

                <input name="goles_local_promedio" type="number" placeholder="Goles local" onChange={handleChange} />
                <input name="goles_visitante_promedio" type="number" placeholder="Goles visitante" onChange={handleChange} />

                <input name="tiros_local" type="number" placeholder="Tiros local" onChange={handleChange} />
                <input name="tiros_visitante" type="number" placeholder="Tiros visitante" onChange={handleChange} />

                <input name="tiros_arco_local" type="number" placeholder="Tiros al arco local" onChange={handleChange} />
                <input name="tiros_arco_visitante" type="number" placeholder="Tiros al arco visitante" onChange={handleChange} />

                <input name="corners_local" type="number" placeholder="Corners local" onChange={handleChange} />
                <input name="corners_visitante" type="number" placeholder="Corners visitante" onChange={handleChange} />

                <input name="victorias_local" type="number" placeholder="Victorias local" onChange={handleChange} />
                <input name="victorias_visitante" type="number" placeholder="Victorias visitante" onChange={handleChange} />

                <button type="submit">Predecir</button>
            </form>

            {resultado && (
                <div>
                    <h2>Resultado</h2>
                    <p>Local: {resultado.prob_local}</p>
                    <p>Empate: {resultado.prob_empate}</p>
                    <p>Visitante: {resultado.prob_visitante}</p>
                    <p>Goleador probable: {resultado.goleador_probable}</p>
                </div>
            )}
        </div>
    );
}
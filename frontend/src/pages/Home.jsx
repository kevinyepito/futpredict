import { useState, useEffect } from "react";
import { data, useNavigate } from "react-router-dom";
import { getPredictions } from "../services/PredictionsService";
import PartidoCard from "../components/prediction/PartidoCard";
import LoadingSpinner from "../components/common/LoadingSpinner";
import ErrorMessage from "../components/common/ErrorMessage";

export default function Home() {
    const navigate = useNavigate();
    const [predicciones, setPredicciones] = useState([]);
    const [cargando, setCargando] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        getPredictions().then(data => setPredicciones(data))
        .catch(() => setError("no se pueden cargar las predicciones"))
        .finally(() => setCargando(false))
    }, [2]);

    
    if (cargando) return <LoadingSpinner/>
    if (error != null) return <ErrorMessage/>

    //tomar ultimos 3
    const ultimas_predicciones = predicciones.slice(0, 3);

    return (
        <div className="home">
            <section className="inicio">
                <h1 className="nombre-app">FutPredict ⚽</h1>
                <p>Predice los resultados de tus equipos favoritos con datos inteligentes</p>

                <h2>Ultimos partidos..</h2>
                {ultimas_predicciones.length === 0 ? (
                    <p>Cargando...</p>
                ) : (
                    ultimas_predicciones.map(p => (
                        <PartidoCard key={p.id} partido={p} />
                    ))
                )}
                <button className="prediccion-btn" onClick={() => navigate('/predicciones')}>Ver todas las predicciones</button>


            </section>
        </div>
    );
}
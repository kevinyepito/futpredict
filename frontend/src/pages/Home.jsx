import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { getPartidos } from "../services/PartidoService"
import PartidoCard from "../components/partidos/PartidoCard";
import LoadingSpinner from "../components/common/LoadingSpinner";
import ErrorMessage from "../components/common/ErrorMessage";

export default function Home() {
    const navigate = useNavigate();
    const [partidos, setPartidos] = useState([]);
    const [cargando, setCargando] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        getPartidos().then(data => setPartidos(data))
        .catch(() => setError("no se pueden cargar las predicciones"))
        .finally(() => setCargando(false))
    }, []);

    
    if (cargando) return <LoadingSpinner/>
    if (error != null) return <ErrorMessage/>

    //tomar ultimos 3
    const ultimas_predicciones = partidos.slice(0, 3);

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
                <button className="prediccion-btn" onClick={() => navigate('/partidos')}>Ver todas las predicciones</button>


            </section>
        </div>
    );
}
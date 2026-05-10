import { getPartidos } from "../services/PartidoService";
import { useState, useEffect } from "react";
import PartidoCard from "../components/partidos/PartidoCard";
import LoadingSpinner from "../components/common/LoadingSpinner";
import ErrorMessage from "../components/common/ErrorMessage";

export default function Partidos() {

    const [partidos, setPartidos] = useState([]);
    const [cargando, setCargando] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        getPartidos()
            .then(data => setPartidos(data))
            .catch(err => {
                console.error("ERROR:", err);
                setError("No se pudieron cargar los partidos");
            })
            .finally(() => setCargando(false));
    }, []);

    if (cargando) return <LoadingSpinner />
    if (error) return <ErrorMessage message={error} />

    return (
        <div>
            {partidos.map(p => (
                <PartidoCard key={p.id} partido={p} />
            ))}
        </div>
    );
}
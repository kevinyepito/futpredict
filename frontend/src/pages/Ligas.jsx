import { getLigas } from "../services/LigaService";
import { useState, useEffect } from "react";
import LigaCard from "../components/ligas/LigaCard";
import LoadingSpinner from "../components/common/LoadingSpinner";
import ErrorMessage from "../components/common/ErrorMessage";

export default function Ligas() {
    const [ligas, setLigas] = useState([]);
    const [cargando, setCargando] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        getLigas()
            .then(data => setLigas(data))
            .catch(err => {
                console.error("ERROR:", err);
                setError("No se pudieron cargar las ligas");
            })
            .finally(() => setCargando(false));
    }, []);

    if (cargando) return <LoadingSpinner />
    if (error) return <ErrorMessage message={error} />

    return (
        <div>
            {
                ligas.map(l => (
                    <LigaCard key={l.id} liga={l} />
                ))
            }
        </div>
    );
}
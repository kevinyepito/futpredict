import { useState, useEffect } from "react";
import { getEquipos } from "../services/EquiposService";
import EquipoCard from "../components/equipo/EquipoCard";
import LoadingSpinner from "../components/common/LoadingSpinner";
import ErrorMessage from "../components/common/ErrorMessage";

export default function Equipos() {
    const [equipos, setEquipos] = useState([]);
    const [cargando, setCargando] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        getEquipos().then(data => setEquipos(data))
            .catch(err => {
                console.error("ERROR: ", err);
                setError("No se pudieron cargar los equipos");
            })
            .finally(() => setCargando(false));
    }, []);

    if (cargando) return <LoadingSpinner />
    if (error != null) return <ErrorMessage message={error}/>
    return (
        <div>
            {equipos.map(e =>
            (
                <EquipoCard key={e.id} equipo={e} />
            )

            )}
        </div>

    )
}
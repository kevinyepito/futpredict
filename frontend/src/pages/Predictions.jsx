import { getPredictions } from "../services/PredictionsService";
import { useState, useEffect } from "react";
import PartidoCard from "../components/prediction/PartidoCard";
import LoadingSpinner from "../components/common/LoadingSpinner";
import ErrorMessage from "../components/common/ErrorMessage";

export default function Predictions() {
    //predicciones y cargando mientras trae la data
    const [predicciones, setPredicciones] = useState([]);
    const [cargando, setCargando] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        getPredictions()
            .then(data => setPredicciones(data))
            .catch(err => {console.error("ERROR:", err);
                setError("no se pudieron cargar las predicciones");
            })
            .finally(() => setCargando(false));
    }, []);

    if (cargando) return <LoadingSpinner />
    if (error != null) return <ErrorMessage message={error}/>

    return (
        <div>
            {predicciones.map(p =>
            (
                <PartidoCard key={p.id} partido={p} />
            )
            )}
        </div>

    )


}

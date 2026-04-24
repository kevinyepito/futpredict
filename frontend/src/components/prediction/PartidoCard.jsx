import './PartidoCard.css';
export default function PartidoCard({ partido }) {
    return (
        <div className="partido-card">
            <div className="equipos">

                <div className="equipo">
                    <img
                        className="escudo-img"
                        src={partido.equipoLocal.escudo}
                        alt="logo"
                        onError={(e) => e.target.src = "https://via.placeholder.com/30"}
                    />
                    <span>{partido.equipoLocal.nombre}</span>
                </div>

                <span className="vs">VS</span>

                <div className="equipo">

                    <span>{partido.equipoVisitante.nombre}</span>
                    <img
                        className="escudo-img"
                        src={partido.equipoVisitante.escudo}
                        alt="logo"
                        onError={(e) =>
                            e.target.src = "https://via.placeholder.com/30"
                        }
                    />
                </div>

            </div>

             <div className="probabilidades">
                <div className="prob-local" style={{ width: `${partido.probLocal * 100}%` }}>
                    {partido.equipoLocal.nombre}: {(partido.probLocal * 100).toFixed(0)}%
                </div>
                <div className="prob-empate" style={{ width: `${partido.probEmpate * 100}%` }}>
                    Empate: {(partido.probEmpate * 100).toFixed(0)}%
                </div>
                <div className="prob-visitante" style={{ width: `${partido.probVisitante * 100}%` }}>
                    {partido.equipoVisitante.nombre}: {(partido.probVisitante * 100).toFixed(0)}%
                </div>
            </div>

            <div className="goleador">
                Goleador probable: <span>{partido.goleadorProbable}</span> ({(partido.probGoleador * 100).toFixed(0)}%)
            </div>
        </div>
    )
}
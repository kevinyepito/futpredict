import './EquipoCard.css'
export default function EquipoCard({ equipo }) {
    return (
        <div className="equipo-card">
            <img
                className="escudo-img"
                src={equipo.escudo}
                alt="logo"
                onError={(e) => {
                    e.target.onerror = null;
                    e.target.src = "https://via.placeholder.com/30";
                }}
            />

            <div className="info">
                <div className="nombre">{equipo.nombre}</div>
                <div className="meta">
                    {equipo.pais} • {equipo.competicion}
                </div>
            </div>
        </div>
    )

}
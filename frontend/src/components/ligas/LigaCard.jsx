import './LigaCard.css'
export default function LigaCard({ liga }) {

    return (
        <div className="liga-card">

            {liga.logo && (
                <img
                    className="logo"
                    src={liga.logo}
                    alt={liga.nombre}
                    onError={(e) => e.target.style.display = 'none'}
                />
            )}

            <div className="nombre">
                {liga.nombre}
            </div>

            <div className="pais">
                {liga.pais}
            </div>

        </div>
    );
}
import './SearchBox.css'

function SearchBox() {
    return (
        <div className='search-box'>
            <button className='lupa'>
                <div>
                    <svg width="15" height="15" viewBox="0 0 16 16" fill="none" stroke="currentColor" strokeWidth="1.8">
                        <circle cx="6.5" cy="6.5" r="4.5" />
                        <path d="M10 10l3 3" strokeLinecap="round" />
                    </svg>
                </div>
            </button>

            <input className='input-bar' placeholder="Buscar partidos, equipos, jugadores,..." />
        </div>
    )
}
export default SearchBox
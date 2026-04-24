import './Icons.css'

export default function Icons({darkMode, toggleDark}) {
    return (
        <div className='icons'>
            <button className='icon-btn' onClick={toggleDark} title="Modo oscuro">
                {darkMode ? '☀' : '☾'}
            </button>
            <button className='icon-btn' title="Configuración">
                <svg width="16" height="16" viewBox="0 0 16 16" fill="none" stroke="currentColor" strokeWidth="1.6">
                    <circle cx="8" cy="8" r="2.5" />
                    <path d="M8 1v2M8 13v2M1 8h2M13 8h2M3.05 3.05l1.41 1.41M11.54 11.54l1.41 1.41M3.05 12.95l1.41-1.41M11.54 4.46l1.41-1.41" />
                </svg>
            </button>
            <div className='avatar'>FP</div>
        </div>
    )
}
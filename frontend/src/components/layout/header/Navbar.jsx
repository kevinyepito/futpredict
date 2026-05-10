import { NavLink } from "react-router-dom";
import './Navbar.css'

function Navbar() {
    //links-opciones que irán en la navbar
    const links = [
        { label: 'Ligas', path: '/ligas' },
        { label: 'Partidos', path: '/partidos' },
        { label: 'Equipos', path: '/equipos' },
        { label: 'Jugadores', path: '/jugadores' },
        { label: 'simular partido', path: '/simular-partido' }
    ]

    return (
        <nav className="navbar">
            {links.map(link => (
                <NavLink
                    key={link.path}
                    to={link.path}
                    className="nav-item"
                >
                    {link.label}
                </NavLink>
            ))}
        </nav>
    )
}

export default Navbar
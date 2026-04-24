import { useLocation } from 'react-router-dom'
import { useState } from 'react'
import Navbar from './Navbar';
import SearchBox from './SearchBox';
import Icons from './Icons';
import './Header.css'

function Header() {
    //para poner el modo oscuro
    const [darkMode, setDarkMode] = useState(false);
    //para usar el path actual ¿creo?
    const location = useLocation();

    const toggleDark = () => {
        setDarkMode(!darkMode);
        //agrega o quita clase dark al body del html
        document.body.classList.toggle('dark');
    }



    return (
        <>
            <header>
                <div className='topbar'>
                    <div className='logo'>
                    </div>
                    <div className='name-app'>
                        FutPredict
                    </div>
                    <SearchBox />
                    <Icons
                        darkMode={darkMode}
                        toggleDark={toggleDark}
                    />

                </div>


            </header>
            <Navbar />
        </>
    )


}

export default Header
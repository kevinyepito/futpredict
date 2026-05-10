import { Route, Routes } from "react-router-dom";
import Header from './components/layout/header/Header.jsx';
import Partidos from './pages/Partidos.jsx';
import Equipos from "./pages/Equipos.jsx";
import Home from "./pages/Home.jsx";
import SimularPartido from "./pages/SimularPartido.jsx";
import Ligas from "./pages/Ligas.jsx";

export default function App() {
  return (
    <>
      <Header />

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/partidos" element={<Partidos />} />
        <Route path="/equipos" element={<Equipos />} />
        <Route path="/simular-partido" element={<SimularPartido />} />
        <Route path="/ligas" element={<Ligas/>}/>
        
      </Routes>
    </>
  )
}
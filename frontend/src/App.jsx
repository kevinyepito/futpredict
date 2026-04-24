import { Route, Routes } from "react-router-dom";
import Header from './components/layout/header/Header.jsx';
import Predictions from './pages/Predictions.jsx';
import Equipos from "./pages/Equipos.jsx";
import Home from "./pages/Home.jsx";

export default function App() {
  return (
    <>
      <Header />

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/predicciones" element={<Predictions />} />
        <Route path="/equipos" element={<Equipos />} />
      </Routes>
    </>
  )
}
from fastapi import FastAPI
from pydantic import BaseModel
import pickle
import numpy as np

app = FastAPI()

#cargamos nuestro bello modelito
with open('modelo.pkl', 'rb') as f:
    modelo = pickle.load(f)

#modelo de datos que recibirá la api
class DatosPartido(BaseModel):
    equipo_local: str
    equipo_visitante: str
    goles_local_promedio: float
    goles_visitante_promedio: float
    tiros_local: int
    tiros_visitante: int
    tiros_arco_local: int
    tiros_arco_visitante: int
    corners_local: int
    corners_visitante: int
    


#modelo de respuesta de la prediccion
class Prediccion(BaseModel):
    prob_local: float
    prob_empate: float
    prob_visitante: float
    goleador_probable: str
    prob_goleador: float


#default de fast api------------------------------------------------
@app.get("/health")
def health():
    return {"status": "ok"}

#enviar prediccion---------------------------------------------------
@app.post("/predecir")
def predecir(datos: DatosPartido):

    features = np.array([[
        datos.goles_local_promedio,
        datos.goles_visitante_promedio,
        datos.tiros_local,
        datos.tiros_visitante,
        datos.tiros_arco_local,
        datos.tiros_arco_visitante,
        datos.corners_local,
        datos.corners_visitante
    ]])

    probs = modelo.predict_proba(features)[0]
    clases = modelo.classes_

    resultado = dict(zip(clases, probs))

    prob_local = round(float(resultado.get('H', 0)), 2)
    prob_empate = round(float(resultado.get('D', 0)), 2)
    prob_visitante = round(float(resultado.get('A', 0)), 2)

    goleador_probable = (
        datos.equipo_local
        if resultado.get('H', 0) > resultado.get('A', 0)
        else datos.equipo_visitante
    )

    prob_goleador = round(
        float(max(resultado.get('H', 0), resultado.get('A', 0))), 2
    )
    
    

    return Prediccion(
        prob_local=prob_local,
        prob_empate=prob_empate,
        prob_visitante=prob_visitante,
        goleador_probable=goleador_probable,
        prob_goleador=prob_goleador
    )
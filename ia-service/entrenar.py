import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
import pickle

#tabla completa con datos

df = pd.read_csv("premier-data.csv")
print(df.head())
#para ver los nombres de las columnas del csv
# print("\nColumnas:", df.columns.tolist())
""" 
FTHG → goles local
FTAG → goles visitante
HS → tiros local
AS → tiros visitante
HST → tiros al arco local
AST → tiros al arco visitante
HC → corners local
AC → corners visitante
FTR → resultado (target)

"""
#tomo las columnas que quiero usar
columns = ['FTHG', 'FTAG', 'HS', 'AS', 'HST', 'AST', 'HC', 'AC', 'FTR']
#me quedo con las columnas seleccionadas y elimino las vacías 
df = df[columns].dropna()

print(f"partidos disponibles para entrenar: {len(df)}")
print(f"resultados (local, empate, visitante): {df['FTR'].value_counts()}")

"""
X = datos de entrada
y = lo que quieres predecir
"""
# Features (características que el modelo usará para predecir)
# axis=0 → filas, axis=1 → columnas ------todas menos FTR(resultado) 
X = df.drop('FTR', axis = 1)

# Target (Lo que va a predecir el modelo)
y =  df['FTR']

#.................................................empezamos a entrenar............................
#dividir en entrenar(train) y probar(test)
"""
X_train → datos para aprender
y_train → respuestas correctas

X_test  → datos nuevos
y_test  → respuestas reales (para comparar)
"""
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size= 0.2, random_state=42 )

#el modelo
modelo = RandomForestClassifier(n_estimators=100, random_state=42)
modelo.fit(X_train, y_train)

#ver que tan precisio es el modeliño
precision = modelo.score(X_test, y_test)
print(f"precision del modelo: {precision:.2%}")

#guardamos el famoso modelo 
with open('modelo.pkl', 'wb') as f:
    pickle.dump(modelo, f)

print("Modelo guardado en modelo.pkl")
    




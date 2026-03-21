import random
from PeliculaClass import Pelicula
from SalaClass import Sala
from CinemaxClass import Cinemax


# Crear 15 películas
peliculas = [Pelicula(f"Pelicula {i+1}") for i in range(15)]

# Crear 7 salas
salas = [Sala(i+1, peliculas) for i in range(7)]

# Simular datos
for sala in salas:
    for pelicula in sala.asistentes:
        sala.registrar_asistencia(pelicula, random.randint(50, 200))

# Crear cine
cine = Cinemax(salas)


# 1. Mejor combinación
mejor, cantidad = cine.mejor_combinacion()
print(f"\n🎬 Mejor combinación:")
print(f"   Sala: {mejor[0]}")
print(f"   Película: {mejor[1]}")
print(f"   Asistentes: {cantidad} personas")

# 2. Más y menos vista
mas, mas_cant, menos, menos_cant = cine.peliculas_global()
print(f"\n🍿 Películas globales:")
print(f"   Más vista: {mas} con {mas_cant} personas")
print(f"   Menos vista: {menos} con {menos_cant} personas")
# 3 y 4
lista = cine.obtener_lista()

print("\nOrden DESC:")
print("\n📊 Top 5 (Mayor asistencia):")
for sala, pelicula, cantidad in cine.ordenar_desc(lista)[:5]:
    print(f"   {cantidad} personas |Sala {sala} | {pelicula}")

print("\nOrden ASC:")
print("\n📉 Top 5 (Menor asistencia):")
for sala, pelicula, cantidad in cine.ordenar_asc(lista)[:5]:
    print(f"   {cantidad} personas | Sala {sala} | {pelicula}")
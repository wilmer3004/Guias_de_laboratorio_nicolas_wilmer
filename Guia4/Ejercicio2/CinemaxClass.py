class Cinemax:
    def __init__(self, salas):
        self.salas = salas

    # 1. Mejor combinación sala-película
    def mejor_combinacion(self):
        max_personas = -1
        mejor = None

        for sala in self.salas:
            for pelicula, cantidad in sala.asistentes.items():
                if cantidad > max_personas:
                    max_personas = cantidad
                    mejor = (sala.numero, pelicula)

        return mejor, max_personas

    # 2. Película más y menos vista (global)
    def peliculas_global(self):
        total_peliculas = {}

        for sala in self.salas:
            for pelicula, cantidad in sala.asistentes.items():
                total_peliculas[pelicula] = total_peliculas.get(pelicula, 0) + cantidad

        mas_vista = max(total_peliculas, key=total_peliculas.get)
        menos_vista = min(total_peliculas, key=total_peliculas.get)

        return mas_vista, total_peliculas[mas_vista], menos_vista, total_peliculas[menos_vista]

    # Convertir a lista para ordenar
    def obtener_lista(self):
        lista = []
        for sala in self.salas:
            for pelicula, cantidad in sala.asistentes.items():
                lista.append((sala.numero, pelicula, cantidad))
        return lista

    # 3. Ordenar mayor a menor (recursivo - QuickSort)
    def ordenar_desc(self, lista):
        if len(lista) <= 1:
            return lista

        pivote = lista[0][2]
        mayores = [x for x in lista[1:] if x[2] > pivote]
        iguales = [x for x in lista if x[2] == pivote]
        menores = [x for x in lista[1:] if x[2] < pivote]

        return self.ordenar_desc(mayores) + iguales + self.ordenar_desc(menores)

    # 4. Ordenar menor a mayor (recursivo)
    def ordenar_asc(self, lista):
        if len(lista) <= 1:
            return lista

        pivote = lista[0][2]
        menores = [x for x in lista[1:] if x[2] < pivote]
        iguales = [x for x in lista if x[2] == pivote]
        mayores = [x for x in lista[1:] if x[2] > pivote]

        return self.ordenar_asc(menores) + iguales + self.ordenar_asc(mayores)

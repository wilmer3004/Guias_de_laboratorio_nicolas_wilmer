class Sala:
    def __init__(self, numero, peliculas):
        self.numero = numero
        # Diccionario: pelicula -> asistentes
        self.asistentes = {pelicula.nombre: 0 for pelicula in peliculas}

    def registrar_asistencia(self, pelicula, cantidad):
        self.asistentes[pelicula] = cantidad

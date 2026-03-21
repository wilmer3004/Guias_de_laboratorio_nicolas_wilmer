class Empleado:
    def __init__(self, rut: str, sueldo: float):
        self.rut = rut
        self.sueldo = sueldo

    def calcular_bonificacion(self) -> float:
        return self.sueldo * 0.05
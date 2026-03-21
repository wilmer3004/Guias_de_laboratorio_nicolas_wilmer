class EmpleadoRepository:
    def __init__(self):
        self.empleados = []

    def agregar(self, empleado):
        self.empleados.append(empleado)

    def obtener_todos(self):
        return self.empleados

    def buscar_por_rut(self, rut):
        for e in self.empleados:
            if e.rut == rut:
                return e
        return None

    def eliminar(self, rut):
        self.empleados = [e for e in self.empleados if e.rut != rut]

    def actualizar_sueldo(self, rut, nuevo_sueldo):
        empleado = self.buscar_por_rut(rut)
        if empleado:
            empleado.sueldo = nuevo_sueldo
            return True
        return False
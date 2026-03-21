class BonificacionService:
    def obtener_beneficiados(self, empleados):
        # Ordenar por sueldo (menor a mayor)
        empleados_ordenados = sorted(empleados, key=lambda e: e.sueldo)
        return empleados_ordenados[:30]

    def costo_total(self, empleados):
        beneficiados = self.obtener_beneficiados(empleados)
        return sum(e.calcular_bonificacion() for e in beneficiados)

    def mayor_bonificacion(self, empleados):
        beneficiados = self.obtener_beneficiados(empleados)
        return max(beneficiados, key=lambda e: e.calcular_bonificacion())

    def menor_bonificacion(self, empleados):
        beneficiados = self.obtener_beneficiados(empleados)
        return min(beneficiados, key=lambda e: e.calcular_bonificacion())
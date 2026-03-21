from domain.servicios import BonificacionService

class EmpresaService:
    def __init__(self, repository):
        self.repository = repository
        self.bono_service = BonificacionService()

    def mostrar_beneficiados(self):
        empleados = self.repository.obtener_todos()
        beneficiados = self.bono_service.obtener_beneficiados(empleados)

        print("\n💰 Beneficiados:")
        for e in beneficiados:
            print(f"RUT: {e.rut} | Bono: ${e.calcular_bonificacion():.2f}")

        print(f"\n💵 Costo total: ${self.bono_service.costo_total(empleados):.2f}")

    def estadisticas(self):
        empleados = self.repository.obtener_todos()

        mayor = self.bono_service.mayor_bonificacion(empleados)
        menor = self.bono_service.menor_bonificacion(empleados)

        print("\n🔝 Mayor bonificación:")
        print(f"RUT: {mayor.rut} | Bono: ${mayor.calcular_bonificacion():.2f}")

        print("\n🔻 Menor bonificación:")
        print(f"RUT: {menor.rut} | Bono: ${menor.calcular_bonificacion():.2f}")

    def buscar(self, rut):
        return self.repository.buscar_por_rut(rut)

    def modificar(self, rut, sueldo):
        return self.repository.actualizar_sueldo(rut, sueldo)

    def eliminar(self, rut):
        self.repository.eliminar(rut)
import random
from domain.empleado import Empleado
from infrastructure.repositorio import EmpleadoRepository
from application.empresa_service import EmpresaService

def mostrar_menu():
    print("\n====== 🏢 EMPRESA ABC ======")
    print("1. Mostrar beneficiados")
    print("2. Ver estadísticas (mayor y menor bonificación)")
    print("3. Buscar empleado por RUT")
    print("4. Modificar sueldo")
    print("5. Eliminar empleado")
    print("6. Salir")
    print("============================")


# 🔹 Inicialización
repo = EmpleadoRepository()

# Generar datos
for i in range(100):
    rut = f"{i+1}-9"
    sueldo = random.randint(500000, 2000000)
    repo.agregar(Empleado(rut, sueldo))

empresa = EmpresaService(repo)


# 🔹 Menú interactivo
while True:
    mostrar_menu()
    opcion = input("Seleccione una opción: ")

    if opcion == "1":
        empresa.mostrar_beneficiados()

    elif opcion == "2":
        empresa.estadisticas()

    elif opcion == "3":
        rut = input("Ingrese RUT a buscar: ")
        emp = empresa.buscar(rut)
        if emp:
            print(f"\n✅ Encontrado:")
            print(f"   RUT: {emp.rut}")
            print(f"   Sueldo: ${emp.sueldo}")
        else:
            print("\n❌ Empleado no encontrado\n")

    elif opcion == "4":
        rut = input("Ingrese RUT: ")
        nuevo_sueldo = float(input("Ingrese nuevo sueldo: "))

        if empresa.modificar(rut, nuevo_sueldo):
            print("\n✅ Sueldo actualizado correctamente\n")
        else:
            print("\n❌ No se encontró el empleado\n")

    elif opcion == "5":
        rut = input("Ingrese RUT a eliminar: ")
        empresa.eliminar(rut)
        print("\n🗑️ Empleado eliminado (si existía)\n")

    elif opcion == "6":
        print("\n👋 Saliendo del sistema...\n")
        break

    else:
        print("\n⚠️ Opción inválida, intente nuevamente\n")
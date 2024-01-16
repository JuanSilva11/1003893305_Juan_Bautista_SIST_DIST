#logica burbuja.
import random
import time

inicio_tiempo = time.time()

def burbuja(arr):
    n = len(arr)

    # Recorrer todos los elementos del arreglo
    for i in range(n):
        # Últimos i elementos ya están en su lugar, no es necesario revisarlos
        for j in range(0, n - i - 1):
            # Intercambiar si el elemento encontrado es mayor que el siguiente elemento
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]

fin_tiempo = time.time()
duracion_total = fin_tiempo - inicio_tiempo

# Ejemplo de uso
mi_lista = [random.randint(0, 500) for _ in range(500)] # Genera una lista de 500 números aleatorios
print("Lista original:", mi_lista)

burbuja(mi_lista)

print("Lista ordenada:", mi_lista)
print(f'Duración total de la ejecución: {duracion_total} segundos')

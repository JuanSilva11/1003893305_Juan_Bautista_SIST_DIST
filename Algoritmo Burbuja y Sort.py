import random
import time
import sys

# Implementación del método de burbuja
def bubble_sort(lst):
    n = len(lst)
    for i in range(n):
        for j in range(0, n - i - 1):
            if lst[j] > lst[j + 1]:
                lst[j], lst[j + 1] = lst[j + 1], lst[j]

# Comparación de los métodos de ordenamiento
def compare_sorts(n):
    # Generar lista de números aleatorios
    lst = [random.randint(0, n) for _ in range(n)]
    
    # Medir el tiempo de ordenamiento del método de burbuja
    start_time = time.time()
    bubble_sort(lst.copy())  # Usar una copia de la lista
    bubble_time = time.time() - start_time

    # Medir el tiempo de ordenamiento del método sort()
    start_time = time.time()
    lst.sort()
    sort_time = time.time() - start_time

    print(f"Para n = {n}:")
    print(f"Tiempo de burbuja: {bubble_time} segundos")
    print(f"Tiempo de sort(): {sort_time} segundos")

# Comparar los métodos de ordenamiento para diferentes tamaños de lista
compare_sorts(1000)
compare_sorts(10000)
compare_sorts(1000000)
# compare_sorts(100000000)  # Esta línea puede tardar mucho tiempo en ejecutarse

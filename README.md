# Examen Final: Fichas Técnicas de Estructuras Arbóreas y Aplicación Práctica

### **Universidad Da Vinci de Guatemala**
**Facultad:** Ingeniería en Sistemas y Ciencias de la Computación  
**Curso:** Estructura de Datos 1  
**Estudiante:** Juan Carlos Vargas Hernández  
**Carnet:** 202104264  
**Fecha:** 16 de mayo de 2026

---

## 📺 Video de Defensa
En el siguiente enlace se encuentra la explicación técnica de la lógica de eliminación, la sustentación de la complejidad Big-O y la ejecución del programa en tiempo real:

👉 **[ENLACE AL VIDEO EN YOUTUBE](https://www.youtube.com/watch?v=wcMxeAHZbaA)**

---

## 📄 Fase 1: Fichas Técnicas (Investigación)
Se adjunta el documento técnico en formato PDF que contiene la investigación detallada sobre las características, complejidad y aplicaciones reales de los árboles más utilizados en la industria:

* Árbol Binario de Búsqueda (BST)
* Árbol Balanceado (AVL)
* Árbol B / B+
* Trie (Árbol de Prefijos)
* Heap (Montículo Min/Max)

📂 **Archivo:** [Fichas_Tecnicas_Estructuras_Arboreas_202104264.pdf](./Fichas_Tecnicas_Estructuras_Arboreas_202104264.pdf)

---

## 💻 Fase 2: Aplicación Práctica (BST en Java)

Esta fase consiste en la implementación desde cero de un **Árbol Binario de Búsqueda (BST)** en Java, diseñado para gestionar datos de manera jerárquica sin el uso de librerías de colecciones nativas para la estructura del árbol.

### **Características del Programa:**
- **Menú Interactivo:** Interfaz por consola para facilitar la navegación.
- **Inserción Masiva:** Opción para insertar múltiples valores de una sola vez separados por comas o espacios.
- **Eliminación Completa:** Manejo de los 3 casos de eliminación (Nodo hoja, nodo con un hijo y nodo con dos hijos mediante sucesor in-order).
- **Visualización Estructural:** Método que imprime en consola una representación gráfica del árbol (rotada 90°).
- **Recorridos:** Implementación de In-Order, Pre-Order y Post-Order.

### **Análisis de Complejidad (Búsqueda):**
- **Caso Promedio $O(\log n)$:** Debido a la división del espacio de búsqueda en cada paso.
- **Peor Caso $O(n)$:** En caso de que el árbol esté desbalanceado o sesgado.

---

## 🚀 Instrucciones de Ejecución

Para ejecutar el proyecto en su máquina local, asegúrese de tener instalado el **JDK 21** o superior.

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/hjmanp/Estructuras-arboreas-ED.git)
    ```
2.  **Compilar el código:**
    ```bash
    javac ArbolBinarioBusqueda.java
    ```
3.  **Ejecutar el programa:**
    ```bash
    java ArbolBinarioBusqueda
    ```

---

## 🛠️ Tecnologías Utilizadas
- **Lenguaje:** Java 21
- **Sistema Operativo:** macOS
- **Control de Versiones:** Git & GitHub
- **Editor:** Visual Studio Code / Terminal

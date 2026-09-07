/*
 * Autor: Kevin Santiago Morales Zuniga
 * Código de matrícula: U22223695
 * Fecha de creación: 07/09/2026
 * Curso: Lenguajes de Programación
 * Semana 02 - Programa 02: Búsqueda en catálogo
 */

import scala.io.StdIn.readLine

object Main {

  /**
   * Busca un producto recorriendo el Map con un Iterator.
   * La comparación ignora mayúsculas y minúsculas.
   */
  def buscarProducto(
      catalogo: Map[String, Double],
      nombreBuscado: String
  ): Unit = {
    val iterador = catalogo.iterator
    var encontrado = false

    while (iterador.hasNext && !encontrado) {
      val (producto, precio) = iterador.next()

      if (producto.equalsIgnoreCase(nombreBuscado.trim)) {
        println(f"El precio de $producto%s es $$$precio%.2f")
        encontrado = true
      }
    }

    if (!encontrado) {
      println("Producto no encontrado en el catálogo actual")
    }
  }

  def main(args: Array[String]): Unit = {
    val catalogo = Map(
      "Laptop" -> 2800.00,
      "Monitor" -> 850.50,
      "Teclado" -> 120.90,
      "Mouse" -> 75.00
    )

    println("BÚSQUEDA EN EL CATÁLOGO")
    println(s"Productos disponibles: ${catalogo.keys.toList.sorted.mkString(", ")}")
    print("Ingrese el producto que desea buscar: ")
    val nombreBuscado = readLine()

    buscarProducto(catalogo, nombreBuscado)
  }
}

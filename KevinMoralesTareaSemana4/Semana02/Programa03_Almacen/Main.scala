/*
 * Autor: Kevin Santiago Morales Zuniga
 * Código de matrícula: U22223695
 * Fecha de creación: 07/09/2026
 * Curso: Lenguajes de Programación
 * Semana 02 - Programa 03: Reposición de almacén
 */

import scala.io.StdIn.readInt

object Main {

  /**
   * Recorre las cantidades mediante un Iterator e imprime solamente
   * las existencias menores al umbral de reposición.
   */
  def mostrarCantidadesPorReponer(
      cantidades: List[Int],
      umbral: Int
  ): Unit = {
    val iterador = cantidades.iterator

    while (iterador.hasNext) {
      val cantidad = iterador.next()

      if (cantidad < umbral) {
        println(s"Cantidad $cantidad: requiere reposición inmediata.")
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val cantidades = List(25, 8, 14, 3, 40, 11)

    println("CONTROL DE EXISTENCIAS")
    println(s"Cantidades registradas: ${cantidades.mkString(", ")}")
    print("Ingrese el umbral de reposición: ")
    val umbral = readInt()

    mostrarCantidadesPorReponer(cantidades, umbral)
  }
}

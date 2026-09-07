/*
 * Autor: Kevin Santiago Morales Zuniga
 * Código de matrícula: U22223695
 * Fecha de creación: 07/09/2026
 * Curso: Lenguajes de Programación
 * Semana 02 - Programa 01: Control de temperaturas
 */

import scala.io.StdIn.readInt

object Main {

  /**
   * Recorre la lista mediante un Iterator e imprime las temperaturas
   * que están fuera del intervalo seguro [minimo, maximo].
   */
  def mostrarTemperaturasFueraDeRango(
      temperaturas: List[Int],
      minimo: Int,
      maximo: Int
  ): Unit = {
    val iterador = temperaturas.iterator
    var existeTemperaturaInsegura = false

    while (iterador.hasNext) {
      val temperatura = iterador.next()

      if (temperatura < minimo || temperatura > maximo) {
        println(s"Temperatura fuera de rango: $temperatura°C")
        existeTemperaturaInsegura = true
      }
    }

    if (existeTemperaturaInsegura) {
      println("Alerta de estabilidad")
    }
  }

  def main(args: Array[String]): Unit = {
    val temperaturas = List(8, 15, 22, 41, 35, 5, 40)

    println("CONTROL DE TEMPERATURAS")
    println(s"Temperaturas registradas: ${temperaturas.mkString(", ")}")
    print("Ingrese la temperatura mínima segura: ")
    val minimo = readInt()
    print("Ingrese la temperatura máxima segura: ")
    val maximo = readInt()

    if (minimo <= maximo) {
      mostrarTemperaturasFueraDeRango(temperaturas, minimo, maximo)
    } else {
      println("Rango inválido: el mínimo no puede ser mayor que el máximo.")
    }
  }
}

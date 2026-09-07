/*
 * Autor: Kevin Santiago Morales Zuniga
 * Código de matrícula: U22223695
 * Fecha de creación: 07/09/2026
 * Curso: Lenguajes de Programación
 * Semana 04 - Programa 02: Etiquetas con HOF
 */

object Main {

  /**
   * Función de orden superior: recibe las funciones que normalizan
   * y validan cada elemento del conjunto.
   */
  def procesarEtiquetas(
      etiquetas: Set[String],
      normalizar: String => String,
      validar: String => Boolean
  ): Set[String] =
    etiquetas.map(normalizar).filter(validar)

  def main(args: Array[String]): Unit = {
    val etiquetas = Set(
      " Programación ",
      "programación",
      "SCALA ",
      " scala",
      "PF",
      " UTP ",
      "utp"
    )

    val normalizador: String => String = texto => texto.trim.toLowerCase
    val longitudValida: String => Boolean = texto => texto.length >= 3

    val etiquetasLimpias = procesarEtiquetas(
      etiquetas,
      normalizador,
      longitudValida
    )

    val cadenaFinal = etiquetasLimpias.toList.sorted.mkString(", ")

    println("ETIQUETAS CON FUNCIONES DE ORDEN SUPERIOR")
    println(s"Conjunto original: ${etiquetas.toList.sorted.mkString(" | ")}")
    println(s"Cadena final: $cadenaFinal")
  }
}

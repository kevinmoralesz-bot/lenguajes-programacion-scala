/*
 * Autor: Kevin Santiago Morales Zuniga
 * Código de matrícula: U22223695
 * Fecha de creación: 07/09/2026
 * Curso: Lenguajes de Programación
 * Semana 03 - Programa 02: Limpieza de etiquetas
 */

object Main {

  // Elimina espacios externos y normaliza el texto a minúsculas.
  def normalizarEtiqueta(etiqueta: String): String =
    etiqueta.trim.toLowerCase

  // Una etiqueta es válida cuando posee tres caracteres o más.
  def esEtiquetaValida(etiqueta: String): Boolean =
    etiqueta.length >= 3

  def limpiarEtiquetas(etiquetas: Set[String]): String = {
    val etiquetasLimpias = etiquetas
      .map(normalizarEtiqueta)
      .filter(esEtiquetaValida)

    // Se ordenan solo para mostrar un resultado estable y legible.
    etiquetasLimpias.toList.sorted.mkString(", ")
  }

  def main(args: Array[String]): Unit = {
    val etiquetas = Set(
      " Scala ",
      "scala",
      " SCALA",
      "IA",
      " funcional ",
      "UTP",
      " utp "
    )

    val resultado = limpiarEtiquetas(etiquetas)

    println("LIMPIEZA DE ETIQUETAS")
    println(s"Etiquetas originales: ${etiquetas.toList.sorted.mkString(" | ")}")
    println(s"Etiquetas procesadas: $resultado")
  }
}

/*
 * Autor: Kevin Santiago Morales Zuniga
 * Código de matrícula: U22223695
 * Fecha de creación: 07/09/2026
 * Curso: Lenguajes de Programación
 * Semana 03 - Programa 01: Lecturas rápidas
 */

case class Libro(titulo: String, autor: String, paginas: Int)

object Main {

  // Función pura que determina si el libro tiene menos de 200 páginas.
  def esLecturaRapida(libro: Libro): Boolean = libro.paginas < 200

  // Convierte el título a mayúsculas y agrega el prefijo solicitado.
  def prepararTitulo(libro: Libro): String =
    "LECTURA CORTA: " + libro.titulo.toUpperCase

  // Suma los caracteres de los títulos sin contar separadores de impresión.
  def contarCaracteres(titulos: List[String]): Int =
    titulos.map(titulo => titulo.length).sum

  def generarReporte(libros: Set[Libro]): (List[String], Int) = {
    val titulosProcesados = libros
      .filter(esLecturaRapida)
      .map(prepararTitulo)
      .toList
      .sorted

    val totalCaracteres = contarCaracteres(titulosProcesados)
    (titulosProcesados, totalCaracteres)
  }

  def main(args: Array[String]): Unit = {
    val libros = Set(
      Libro("El principito", "Antoine de Saint-Exupéry", 96),
      Libro("Scala práctico", "Ana Torres", 180),
      Libro("Don Quijote", "Miguel de Cervantes", 863),
      Libro("Clean Code", "Robert C. Martin", 464)
    )

    val (reporte, totalCaracteres) = generarReporte(libros)

    println("REPORTE DE LECTURAS RÁPIDAS")
    reporte.foreach(titulo => println(titulo))
    println(s"Total de caracteres: $totalCaracteres")
  }
}

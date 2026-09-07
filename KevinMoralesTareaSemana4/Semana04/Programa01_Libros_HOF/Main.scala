/*
 * Autor: Kevin Santiago Morales Zuniga
 * Código de matrícula: U22223695
 * Fecha de creación: 07/09/2026
 * Curso: Lenguajes de Programación
 * Semana 04 - Programa 01: Lecturas rápidas con HOF
 */

case class Libro(titulo: String, autor: String, paginas: Int)

object Main {

  /**
   * Función de orden superior genérica: recibe como parámetros una
   * condición de filtrado y una función de transformación.
   */
  def procesarColeccion[A, B](
      datos: Set[A],
      criterio: A => Boolean,
      transformacion: A => B
  ): List[B] =
    datos.filter(criterio).map(transformacion).toList

  def main(args: Array[String]): Unit = {
    val libros = Set(
      Libro("Metamorfosis", "Franz Kafka", 144),
      Libro("El alquimista", "Paulo Coelho", 192),
      Libro("Cien años de soledad", "Gabriel García Márquez", 471),
      Libro("Código limpio", "Robert C. Martin", 464)
    )

    val esLibroCorto: Libro => Boolean = libro => libro.paginas < 200
    val obtenerTitulo: Libro => String = libro => libro.titulo.toUpperCase

    val reporte = procesarColeccion(libros, esLibroCorto, obtenerTitulo)
      .map(titulo => "LECTURA CORTA: " + titulo)
      .sorted

    // foldLeft agrega el número de caracteres en un único valor.
    val totalCaracteres = reporte.foldLeft(0) {
      (acumulador, titulo) => acumulador + titulo.length
    }

    println("LECTURAS RÁPIDAS CON FUNCIONES DE ORDEN SUPERIOR")
    reporte.foreach(println)
    println(s"Total de caracteres: $totalCaracteres")
  }
}

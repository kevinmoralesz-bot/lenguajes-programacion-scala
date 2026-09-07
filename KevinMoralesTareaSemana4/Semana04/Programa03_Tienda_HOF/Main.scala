/*
 * Autor: Kevin Santiago Morales Zuniga
 * Código de matrícula: U22223695
 * Fecha de creación: 07/09/2026
 * Curso: Lenguajes de Programación
 * Semana 04 - Programa 03: Tienda con HOF
 */

object Main {

  /**
   * Función de orden superior que recibe el criterio de selección
   * y la operación que actualizará cada precio aceptado.
   */
  def actualizarPrecios(
      productos: Map[String, Double],
      criterio: Double => Boolean,
      actualizacion: Double => Double
  ): Map[String, Double] =
    productos
      .filter { case (_, precio) => criterio(precio) }
      .map { case (nombre, precio) => (nombre, actualizacion(precio)) }

  // Recibe también la función que define el formato del reporte.
  def generarReporte(
      productos: Map[String, Double],
      formatear: (String, Double) => String
  ): List[String] =
    productos.toList
      .sortBy { case (nombre, _) => nombre }
      .map { case (nombre, precio) => formatear(nombre, precio) }

  def main(args: Array[String]): Unit = {
    val productos = Map(
      "Impresora" -> 650.00,
      "Tablet" -> 900.00,
      "Audífonos" -> 150.00,
      "Cable USB" -> 35.00
    )

    val precioMayorA50: Double => Boolean = precio => precio > 50.00
    val descuento20: Double => Double = precio => precio * 0.80

    val productosActualizados = actualizarPrecios(
      productos,
      precioMayorA50,
      descuento20
    )

    val formato: (String, Double) => String =
      (nombre, precio) =>
        f"Producto: $nombre%s | Precio Rebajado: $$$precio%.2f"

    val reporte = generarReporte(productosActualizados, formato)

    // foldLeft agrega los precios; se valida que el mapa no esté vacío.
    val promedio =
      if (productosActualizados.isEmpty) 0.0
      else {
        val total = productosActualizados.values.foldLeft(0.0)(_ + _)
        total / productosActualizados.size
      }

    println("TIENDA CON FUNCIONES DE ORDEN SUPERIOR")
    reporte.foreach(println)
    println(f"Precio promedio: $$$promedio%.2f")
  }
}

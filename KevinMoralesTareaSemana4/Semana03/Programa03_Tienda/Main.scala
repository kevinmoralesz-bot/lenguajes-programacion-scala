/*
 * Autor: Kevin Santiago Morales Zuniga
 * Código de matrícula: U22223695
 * Fecha de creación: 07/09/2026
 * Curso: Lenguajes de Programación
 * Semana 03 - Programa 03: Actualización de precios
 */

object Main {

  def filtrarProductos(productos: Map[String, Double]): Map[String, Double] =
    productos.filter { case (_, precio) => precio > 50.00 }

  def aplicarDescuento(productos: Map[String, Double]): Map[String, Double] =
    productos.map { case (nombre, precio) => (nombre, precio * 0.80) }

  def crearReporte(productos: Map[String, Double]): List[String] =
    productos.toList
      .sortBy { case (nombre, _) => nombre }
      .map {
        case (nombre, precio) =>
          f"Producto: $nombre%s | Precio Rebajado: $$$precio%.2f"
      }

  // El promedio se calcula con los valores numéricos antes de formatearlos.
  def calcularPromedio(productos: Map[String, Double]): Double =
    if (productos.isEmpty) 0.0
    else productos.values.sum / productos.size

  def main(args: Array[String]): Unit = {
    val productos = Map(
      "Laptop" -> 2500.00,
      "Monitor" -> 800.00,
      "Teclado" -> 120.00,
      "Mouse" -> 45.00
    )

    val productosFiltrados = filtrarProductos(productos)
    val productosRebajados = aplicarDescuento(productosFiltrados)
    val reporte = crearReporte(productosRebajados)
    val promedio = calcularPromedio(productosRebajados)

    println("REPORTE DE PRECIOS REBAJADOS")
    reporte.foreach(linea => println(linea))
    println(f"Precio promedio: $$$promedio%.2f")
  }
}

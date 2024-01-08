fun main() {

    var r2d2Pos: List<Int>
    //Ejercicio 1:
    r2d2Pos = moverRobot(10,5,-2)
    println("x: ${r2d2Pos[0]}, y: ${r2d2Pos[1]}, direccion: ${direccionRobot(r2d2Pos[2])}")
    //Ejercicio 2:
    r2d2Pos = moverRobot(0,0,0)
    println("x: ${r2d2Pos[0]}, y: ${r2d2Pos[1]}, direccion: ${direccionRobot(r2d2Pos[2])}")
    //Ejercicio 3:
    r2d2Pos = moverRobot()
    println("x: ${r2d2Pos[0]}, y: ${r2d2Pos[1]}, direccion: ${direccionRobot(r2d2Pos[2])}")
    //Ejercicio 4:
    r2d2Pos = moverRobot(-10, -5, 2)
    println("x: ${r2d2Pos[0]}, y: ${r2d2Pos[1]}, direccion: ${direccionRobot(r2d2Pos[2])}")
    //Ejercicio 5:
    r2d2Pos = moverRobot(-10, -5, 2, 4, -8)
    println("x: ${r2d2Pos[0]}, y: ${r2d2Pos[1]}, direccion: ${direccionRobot(r2d2Pos[2])}")

}//FIN MAIN()

/**
 * Realiza el movimiento del Robot
 *
 * @param movimientos Int (varang) Lista de movimientos a realizar
 * @return List<Any> Las coordenadas de la posición final del reobot.
 *
 */
fun moverRobot(vararg movimientos: Int): List<Int> {

    //LA POSICION INICIAL SERA EN (0,0), POR LO QUE INICIALIZO MI POSICION EN (0,0)
    var ejeX = 0
    var ejeY = 0
    var direccion = 0

    /*En cada movimiento el robot gira 90º en direccion antihorario, por lo que puedo dividir el
     eje completo en una circunferencia por cuartos, donde:
     0-> POSITIVEY; 1-> NEGATIVEX; 2-> NEGATIVEY; 3-> POSITIVEX
     Sumo o resto la siguiente coordenada según en qué eje se encuentre.*/
    for (pasos in movimientos) {
        when (direccion){
            0 -> ejeY += pasos
            1 -> ejeX -= pasos
            2 -> ejeY -= pasos
            3 -> ejeX += pasos
        }//FIN WHEN(DIRECCION)

        //Al finalizar cada movimiento, añado el giro de -90º
        if (direccion == 3) direccion = 0 else direccion += 1
 }//FIN FOR pasos
    return listOf(ejeX,ejeY, direccion)
}//FIN moverRobot

fun direccionRobot (direccion: Int) = when (direccion){
        0 -> "POSITIVEY"
        1 -> "NEGATIVEX"
        2 -> "NEGATIVEY"
        3 -> "POSITIVEX"
        else -> ""
}//FIN direccionRobot

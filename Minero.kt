package com.example.minerobob

enum class estadoBob{
    MINA,HOGAR,BANCO,TABERNA
}
class Minero (private val name: String, private var fatiga: Int, private var sed: Int, private var oro: Int,
              private var estado:estadoBob) {

    var banco: Int = 0

    fun estadoMinero(){
        while (true){
            if (estado==estadoBob.MINA){
                trabajoMina()
            }
            if (estado == estadoBob.BANCO){
                DepositoBanco()
            }
            if(estado == estadoBob.TABERNA){
                taberna()
            }

            if(estado == estadoBob.HOGAR){
                casa()
            }
        }
    }

    private fun trabajoMina(){
        while(true){
            pausa()
            if (oro ==0  || fatiga == 0){
                println("Minero $name: De regreso a la mina")
            }
            oro ++
            sed ++
            fatiga += 2

            println("Minero $name: Recolectando una pepita de oro. Oro actual $oro")
            if (oro >=3){
                estado = estadoBob.BANCO
                break
            }
            if (sed >=5){
                estado = estadoBob.TABERNA
                break
            }
            if (fatiga == 10){
                estado = estadoBob.HOGAR
                break
            }

        }

    }

    private fun DepositoBanco() {
        pausa()
        println("Minero $name: Me voy de la mina de oro con mis bolsillos llenos")
        println("Minero $name: Voy para el banco, si señor")
        banco += oro
        println("Minero $name: Total de oro depositado $banco")
        oro = 0
        if(fatiga >= 8){
            estado = estadoBob.HOGAR
        }
        else{
            estado = estadoBob.MINA
        }

    }

    private fun taberna(){
        pausa()
        println("Minero $name: Hombre, estoy sediento me dirijo a la taberna")
        sed -= 5
        println("Minero $name: Oh! Esto si que esta muy bueno ha calmado mi sed")
        if(fatiga >= 8){
            estado = estadoBob.HOGAR
        }
        else{
            estado = estadoBob.MINA
            println ("Minero $name: De regreso a la mina")
        }
    }

    private fun casa(){
        pausa()
        fatiga = 0
        println("Minero $name: Me siento muy cansado. Ire a descansar")
        println("Minero $name: De camino a mi hogar dulce hogar")
        println("Minero $name: Hogar dulce hogar")
        println("Minero $name: Zzzz")
        estado = estadoBob.MINA
    }

    private fun pausa(){
        Thread.sleep(1000)
    }



    override fun toString(): String {
        return "Nombre: $name \nFatiga: $fatiga\nSed: $sed\nOro: $oro"
    }
}
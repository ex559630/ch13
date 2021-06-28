fun main(){

    val player = Player("sayori",89,true,false)
    player.castFireball()

    val auraColor = player.auraColor()

    printPlayerStatus(player)

    //println("光環顏色: $auraColor , 是否受祝福: ${if(isBlessed) "是的" else "否"}   ")
    //println("${player.name} ${player.formatHealthStatus()}")
}
private fun printPlayerStatus(player:Player){
    println("Aura: ${player.auraColor()}"+
            "(Blessed: ${if (player.isBlessed) "Yes" else "No"})")
    println("${player.name} ${player.formatHealthStatus()}")
}
class Player (_name:String,
              var healthPoints:Int,
              val isBlessed:Boolean,
              private val isImmortal:Boolean){
    var name = _name
        get() = field.capitalize()
        private set(value) {
            field = value.trim()
        }

    fun auraColor():String{
        var auraVisible = healthPoints >=50 && isBlessed || isImmortal
        val auracolor = if (auraVisible) "Green" else "None"
        return auracolor
    }
    fun formatHealthStatus() = when(healthPoints){
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed){
            "has some minor wounds but is heading quite quickly."
        }else {
            "has some minor wounds."
        }
        in 15..74 -> "look pretty hurt."
        else -> "is in awful condition"
    }
    fun castFireball(numFireballs:Int=2){
        println("A glass of FireBall springs into existence.(x$numFireballs)")
    }
}
/*
field 不允許直接定義
get 讀取屬性
set 設定屬性
 */
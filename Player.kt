import java.io.File

class Player (_name:String,
              var healthPoints:Int = 100,
              val isBlessed:Boolean,
              private val isImmortal:Boolean){
    var name = _name
        get() = "${field.capitalize()} of $hometown"
        private set(value) {
            field = value.trim()
        }
    val hometown = selectHometown()
    init {
        require(healthPoints >0 ,{"healPoints must be greater then zero."})
        require(name.isNotBlank(),{"Player must have a name."})
    }
    constructor(name:String):this(name,
        isBlessed = true,
        isImmortal = false){
        if (name.toLowerCase() == "kar") healthPoints = 40
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
    private fun selectHometown() = File("data/towns.txt")
        .readText()
        .split("\n")
        .shuffled()
        .first()
    fun castFireball(numFireballs:Int=2){
        println("A glass of FireBall springs into existence.(x$numFireballs)")
    }
}
/*
field 不允許直接定義
get 讀取屬性
set 設定屬性
 */
package signature

enum class Letters(val letter: Char, val list: List<String>) {
    A('a', listOf("____", "|__|", "|  |")),
    B('b',  listOf("___ ", "|__]", "|__]")),
    C('c' , listOf("____", "|   ", "|___")),
    D('d' , listOf("___ ", "|  \\", "|__/")),
    E('e' , listOf("____", "|___", "|___")),
    F('f' , listOf("____", "|___", "|   ")),
    G('g' , listOf("____", "| __", "|__]")),
    H('h' , listOf("_  _", "|__|", "|  |")),
    I('i' , listOf("_", "|", "|")),
    J('j' , listOf(" _", " |", "_|")),
    K('k' , listOf("_  _", "|_/ ", "| \\_")),
    L('l' , listOf("_   ", "|   ", "|___")),
    M('m' , listOf("_  _", "|\\/|", "|  |")),
    N('n' , listOf("_  _", "|\\ |", "| \\|")),
    O('o' , listOf("____", "|  |", "|__|")),
    P('p' , listOf("___ ", "|__]", "|   ")),
    Q('q' , listOf("____", "|  |", "|_\\|")),
    R('r' , listOf("____", "|__/", "|  \\")),
    S('s' , listOf("____", "[__ ", "___]")),
    T('t' , listOf("___", " | ", " | ")),
    U('u' , listOf("_  _", "|  |", "|__|")),
    V('v' , listOf("_  _", "|  |", " \\/ ")),
    W('w' , listOf("_ _ _", "| | |", "|_|_|")),
    X('x' , listOf("_  _", " \\/ ", "_/\\_")),
    Y('y' , listOf("_   _", " \\_/ ", "  |  ")),
    Z('z' , listOf("___ ", "  / ", " /__")),
    ELSE( ' ', listOf("    ", "    ", "    "));

    companion object {
        fun getLetter(name: String, index: Int): String {
            var result = ""
            name.forEach {
                val character = it
                result += values().firstOrNull { it.letter == character }!!.list[index] + " "
            }
            return result
        }
    }
}

/*fun padCenter() {
    val spaces: Int = length - str.Length
    val padLeft: Int = spaces / 2 + str.Length
    return str.PadLeft(padLeft).PadRight(length)
}*/

fun main() {
    println("Enter name and surname:")
    val name = readln().lowercase()
    println("Enter person's status:")
    val status = readln()
    val tagLength = name.length * 5 + 1

    print("*".repeat(tagLength))
    println()
    repeat(3) {
        print("*  ")
        println(Letters.getLetter(name, it) + " *")
    }
    print("*")
    print("%${tagLength / 2 + status.length / 2}s%-${tagLength / 2 - status.length / 2}s".format(status, "") + "*")
    println()
    print("*".repeat(tagLength))
    //println(Letters.getLetter())

}
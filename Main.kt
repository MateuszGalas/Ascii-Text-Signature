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


fun main() {
    println("Enter name and surname:")
    val name = readln().lowercase()
    println("Enter person's status:")
    val status = readln()

    val countJ = name.count { it == 'j'}
    val countW = name.count { it == 'w'}
    val countI = name.count { it == 'i'}
    val countT = name.count { it == 't'}
    val countY = name.count { it == 'y'}
    val countSpace = name.count { it == ' '}

    val tagLength = countJ * 2 + countW * 5 + countI + countT * 3 + countY * 5 + countSpace * 6 +
             (name.length - countJ - countW - countI - countT - countY - countSpace) * 4 + name.length - 2

    val length: Int = if (tagLength > status.length) tagLength + 5 else status.length + 6

    val statusMargins =
        if ((tagLength % 2 == 1 && status.length % 2 == 1) || (tagLength % 2 == 0 && status.length % 2 == 0)) {
        (tagLength - status.length - 1) / 2 + 2
    }
    else {
        (tagLength - status.length) / 2 + 2
    }

    val tagMargins =
        if ((tagLength % 2 == 1 && status.length % 2 == 1) || (tagLength % 2 == 0 && status.length % 2 == 0)) {
            (length - tagLength - 1) / 2
    }
    else {
            (length - tagLength - 1) / 2
    }


    print("*".repeat(length))
    println()
    repeat(3) {
        print("*")
        print("%-${if (status.length > tagLength) tagMargins else 2}s".format("") +
                Letters.getLetter(name, it) +
                "%${if (status.length > tagLength) (length - tagLength) / 2 - 1 else 1}s".format(""))
        println("*")
    }
    print("*")
    print("%-${if (status.length < tagLength) statusMargins else 2}s".format("") +
            status +
            "%${if (status.length < tagLength) (tagLength - status.length) / 2 + 2 else 2}s".format(""))
    println("*")
    print("*".repeat(length))
}
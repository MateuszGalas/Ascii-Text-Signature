package signature

import java.io.File
import kotlin.system.exitProcess

// Getting text from font files
fun getText(name: String, letters: List<String>, lines: Int, spaces: Int): MutableList<MutableList<String>> {
    val text = mutableListOf<MutableList<String>>()
    var index = 0
    var counter = 0
    name.forEach {
        val letter = it
        letters.forEach {
            if (it.matches("""$letter\s\d+""".toRegex())) index = letters.indexOf(it)
        }

        text.add(mutableListOf())
        repeat(lines) {
            if (letter == ' ') text[counter].add(" ".repeat(spaces)) else text[counter].add(letters[index + it + 1])
        }
        counter++
    }
    return text
}
// Reading fonts from files and printing tags
fun main() {
    println("Enter name and surname:")
    val name = readln()
    println("Enter person's status:")
    val status = readln()


    val romanFile = File("src/roman.txt")
    val mediumFile = File("src/medium.txt")
    if (!romanFile.exists()) exitProcess(1)
    if (!mediumFile.exists()) exitProcess(1)
    val romanLetters = romanFile.readLines()
    val mediumLetters = mediumFile.readLines()

    val romanText = getText(name, romanLetters, 10, 10)
    val mediumText = getText(status, mediumLetters, 3, 5)
    printTag(romanText, mediumText)
}
// Printing tag depending on length of name or status
fun printTag(romanText: MutableList<MutableList<String>>, mediumText: MutableList<MutableList<String>>) {
    var tagLength = 0
    var statusLength = 0
    romanText.forEach { tagLength += it[0].length }
    mediumText.forEach { statusLength += it[0].length }

    val borderLength: Int = if (tagLength > statusLength) tagLength + 8 else statusLength + 8

    val tagMargins = (statusLength - tagLength) / 2 + ((statusLength - tagLength) % 2)
    val statusMargins = (tagLength - statusLength) / 2 + ((tagLength - statusLength) % 2)

    print("8".repeat(borderLength))
    println()
    repeat(10) {
        print("88")
        print(
            "%${if (statusLength > tagLength) (statusLength - tagLength) / 2 else ""}s%-2s".format("", "") +
                    getLetter(romanText, it) +
                    "%${if (statusLength > tagLength) tagMargins else ""}s%2s".format("", "")
        )
        println("88")
    }
    repeat(3) {
        print("88")
        print(
            "%${if (statusLength < tagLength) (tagLength - statusLength) / 2 else ""}s%-2s".format("", "") +
                    getLetter(mediumText, it) +
                    "%${if (statusLength < tagLength) statusMargins else ""}s%2s".format("", "")
        )
        println("88")
    }
    print("8".repeat(borderLength))
}
// Getting letter from list of 'characters'
fun getLetter(name: MutableList<MutableList<String>>, index:Int) : String{
    var result = ""
    name.forEach { result += it[index] }
    return result
}
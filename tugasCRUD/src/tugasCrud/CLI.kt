package tugasCrud

fun main() {
    val manager = CharManager()
    var state = "MENU"

    while (true) {
        when (state) {
            "MENU" -> {
                showMenu()
                val input = readLine() ?: ""
                state = when (input) {
                    "1" -> "ADD"
                    "2" -> "LIST"
                    "3" -> "EDIT"
                    "4" -> "DELETE"
                    "5" -> "SEARCH"
                    "6" -> "EXIT"
                    else -> {
                        println("Tidak ada dalam pilihan! coba lagi!\n")
                        "MENU"
                    }
                }
            }
            "ADD" -> {
                addCharacter(manager)
                state = "MENU"
            }
            "LIST" -> {
                charList(manager)
                state = "MENU"
            }
            "EDIT" -> {
                editCharacter(manager)
                state = "MENU"
            }
            "DELETE" -> {
                deleteCharacter(manager)
                state = "MENU"
            }
            "SEARCH" -> {
                searchCharacter(manager)
                state = "MENU"
            }
            "EXIT" -> {
                println("Sampai jumpa lagi, Babay!")
                break
            }
        }
    }
}
package tugasCrud

class CharManager {
    private val charList = mutableListOf<Character>()

    val allChar: List<Character>
        get() = charList.toList()

    fun addCharacter(id : String, name : String, element : String): Boolean{
        if (id.isBlank() || name.isBlank() || element.isBlank()) return false

        val sameId = charList.any { it.id == id }
        if (sameId) return false

        charList.add(Character(id, name, element))
        return true
    }

    fun listCharacter(): List<Character>{
        return allChar
    }

    fun editCharacter(id : String, name : String, element : String): Boolean{
        val character : Character? = listCharacter().find { it.id == id }

        return if (character != null){
            character.name = name
            character.element = element
            true
        } else {
            false
        }
    }

    fun deleteCharacter(id : String): Boolean{
        val character : Character? = listCharacter().find { it.id == id }
        return if (character != null){
            charList.remove(character)
            true
        } else {
            false
        }
    }

    fun showCharacter(id: String): Character? {
        return charList.find { it.id == id }
    }
}
package tugasCrud

fun showMenu() {
    println("==================================")
    println(" Pilihan: ")
    println(" 1. Add Character \n 2. Show List Character\n " +
            "3. Edit Character\n 4. Delete Character \n 5. Search Character\n 6. Exit")
    println("----------------------------------")
    print(" Pilih: ")
}

fun addCharacter(manager : CharManager) {
    println("----------Add Character-----------")
    print("Masukkan ID Character: ")
    val id = readLine() ?: ""
    print("Masukkan Nama Character: ")
    val name = readLine() ?: ""
    print("Masukkan Elemen Character: ")
    val element = readLine() ?: ""

    if (manager.addCharacter(id, name, element)){
        println("Character berhasil ditambahkan!\n")
    } else {
        println("Character gagal ditambahkan karena ID nya ada yang sama!\n")
    }
}

fun charList(manager : CharManager) {
    println("---------List Character-----------")
    val list = manager.listCharacter()

    if (list.isEmpty()) {
        println("Data character kosong!\n")
    } else {
        list.forEachIndexed {index, character ->
            println("${index+1}. ID: ${character.id}, Nama: ${character.name}, Elemen: ${character.element}")
        }
        println()
    }
}

fun editCharacter(manager : CharManager) {
    println("---------Edit Character-----------")
    print("Masukkan ID Character yang ingin di edit: ")
    val id = readLine() ?: ""

    print("Masukkan Nama Character yang baru: ")
    val newName = readLine() ?: ""

    print("Masukkan Elemen Character yang baru: ")
    val newElement = readLine() ?: ""

    if (manager.editCharacter(id, newName, newElement)){
        println("Character berhasil diedit!\n")
    } else {
        println("ID tidak ditemukan!\n")
    }
}

fun deleteCharacter(manager : CharManager) {
    println("--------Hapus Character-----------")
    print("Masukkan ID Character yang ingin dihapus: ")
    val id = readLine() ?: ""

    if (manager.deleteCharacter(id)){
        println("Character berhasil dihapus!\n")
    } else {
        println("ID tidak ditemukan!\n")
    }
}

fun searchCharacter(manager : CharManager) {
    println("---------Search Character---------")
    print("Masukkan ID Character yang ingin dicari: ")
    val id = readLine() ?: ""

    val character: Character? = manager.showCharacter(id)

    if (character != null) {
        println("ID: ${character.id}, Nama: ${character.name}, Elemen: ${character.element}")
        println()
    } else {
        println(" data sengan ID tersebut tidak ditemukan!\n")
    }
}
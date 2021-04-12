fun friendlyPiece(pieces: Array<Pair<String, String>?>, currentCoord: Pair<Int, Int>, targetCoord: Pair<Int, Int>,
                  numColumns: Int): Boolean {
    val currentIndex = chessCoordinateIndex(currentCoord.second, currentCoord.first, numColumns)
    val currentSelectedPiece: Pair<String, String> = pieces[currentIndex] ?: Pair("", "")
    val targetIndex = chessCoordinateIndex(targetCoord.second, targetCoord.first, numColumns)
    val targetSelectedPiece: Pair<String, String> = pieces[targetIndex] ?: Pair("", "")
    return currentSelectedPiece.second != targetSelectedPiece.second
}

fun validBoard(numColumns: Int, numLines: Int): Boolean {
    return when(numColumns*numLines) {
        64-> true
        49-> true
        42-> true
        36-> true
        16-> true
        else -> false
    }
}

fun chessCoordinateIndex(numColumns: Int, numLines: Int, numTotalColumns: Int): Int {
    return (numColumns - 1) + (numLines - 1) * numTotalColumns
}

fun isKnightValid(currentCoord: Pair<Int, Int>, targetCoord: Pair<Int, Int>, pieces: Array<Pair<String, String>?>,
                  numColumns: Int, numLines: Int): Boolean {
    val first = currentCoord.first
    val second = currentCoord.second
    if (first != 0 && second != 0) {
        if (isCoordinateInsideChess(targetCoord, numColumns, numLines)) {
            val validMove: Pair<Int, Int> = Pair((first + 1), second)
            val validMove2: Pair<Int, Int> = Pair((first - 1), second)
            return targetCoord == validMove || validMove2 == targetCoord
        }
    }
    return false
}

fun isQueenValid(currentCoord: Pair<Int, Int>, targetCoord: Pair<Int, Int>, pieces: Array<Pair<String, String>?>,
                 numColumns: Int, numLines: Int): Boolean {
    if (friendlyPiece(pieces, currentCoord, targetCoord, numColumns) && isCoordinateInsideChess(targetCoord, numColumns, numLines)) {
        var contador = 0
        var validMove1: Pair<Int, Int>
        var validMove2: Pair<Int, Int>
        var validMove3: Pair<Int, Int>
        var validMove4: Pair<Int, Int>
        val first = currentCoord.first
        val second = currentCoord.second
        while (first + contador in 1..8 && second + contador in 1..8) {
            contador++
            validMove1 = Pair(first + contador, second + contador)
            if (validMove1 == targetCoord){
                return validMove1 == targetCoord
            }
        }
        contador=0
        while (first - contador in 1..8 && second + contador in 1..8) {
            contador++
            validMove2 = Pair(first - contador, second + contador)
            if (validMove2 == targetCoord){
                return validMove2 == targetCoord
            }
        }
        contador=0
        while (first + contador in 1..8 && second - contador in 1..8) {
            contador++
            validMove3 = Pair(first + contador, second - contador)
            if (validMove3 == targetCoord){
                return validMove3 == targetCoord
            }
        }
        contador=0
        while (first - contador in 1..8 && second - contador in 1..8) {
            contador++
            validMove4 = Pair(first - contador, second - contador)
            if (validMove4 == targetCoord){
                return validMove4 == targetCoord
            }
        }
        val firstTarget = targetCoord.first
        val secondTarget = targetCoord.second
        val validMove5: Pair<Int, Int>
        val validMove6: Pair<Int, Int>
        validMove6 = Pair(first, secondTarget)
        validMove5 = Pair(firstTarget, second)
        return targetCoord == validMove6 || targetCoord == validMove5
    } else{
        return false
    }
    return false
}

fun isBishopValid(currentCoord: Pair<Int, Int>, targetCoord: Pair<Int, Int>, pieces: Array<Pair<String, String>?>,
                  numColumns: Int, numLines: Int): Boolean {
    if (friendlyPiece(pieces, currentCoord, targetCoord, numColumns) &&
            isCoordinateInsideChess(targetCoord, numColumns, numLines)) {
        var contador = 0
        var validMove: Pair<Int, Int>
        val first = currentCoord.first
        val second = currentCoord.second
        while (first + contador in 1..8 && second + contador in 1..8) {
            contador++
            validMove = Pair(first + contador, second + contador)
            if (validMove == targetCoord){
                return validMove == targetCoord
            }
        }
        contador=0
        while (first - contador in 1..8 && second + contador in 1..8) {
            contador++
            validMove = Pair(first - contador, second + contador)
            if (validMove == targetCoord){
                return validMove == targetCoord
            }
        }
        contador=0
        while (first + contador in 1..8 && second - contador in 1..8) {
            contador++
            validMove = Pair(first + contador, second - contador)
            if (validMove == targetCoord){
                return validMove == targetCoord
            }
        }
        contador=0
        while (first - contador in 1..8 && second - contador in 1..8) {
            contador++
            validMove = Pair(first - contador, second - contador)
            if (validMove == targetCoord){
                return validMove == targetCoord
            }
        }
    } else{
        return false
    }
    return false
}

fun isTowerValid(currentCoord: Pair<Int, Int>, targetCoord: Pair<Int, Int>, pieces: Array<Pair<String, String>?>,
                 numColumns: Int, numLines: Int): Boolean {
    if (friendlyPiece(pieces, currentCoord, targetCoord, numColumns) &&
            isCoordinateInsideChess(targetCoord, numColumns, numLines)) {
        val validMove1: Pair<Int, Int> = Pair(currentCoord.first, targetCoord.second)
        val validMove2: Pair<Int, Int> = Pair(targetCoord.first, currentCoord.second)
        return targetCoord == validMove1 || targetCoord == validMove2
    }
    return false
}

fun isKingValid(currentCoord: Pair<Int, Int>, targetCoord: Pair<Int, Int>, pieces: Array<Pair<String, String>?>,
                numColumns: Int, numLines: Int): Boolean {
    val first = currentCoord.first
    val second = currentCoord.second
    if (first != 0 && second != 0) {
        if (friendlyPiece(pieces, currentCoord, targetCoord, numColumns) && isCoordinateInsideChess(targetCoord, numColumns, numLines)) {
            val validMove: Pair<Int, Int> = Pair((first + 1), second);val validMove2: Pair<Int, Int> = Pair((first - 1), second)
            val validMove3: Pair<Int, Int> = Pair((first + 1), (second + 1));val validMove4: Pair<Int, Int> = Pair((first - 1), (second - 1))
            val validMove5: Pair<Int, Int> = Pair((first - 1), (second + 1));val validMove6: Pair<Int, Int> = Pair((first + 1), (second - 1))
            val validMove7: Pair<Int, Int> = Pair(first, ((second+1)));val validMove8: Pair<Int, Int> = Pair(first, ((second-1)))
            return targetCoord == validMove || validMove2 == targetCoord || validMove3 == targetCoord ||
                    validMove4 == targetCoord ||
                    validMove5 == targetCoord || validMove6 == targetCoord || validMove7 == targetCoord ||
                    validMove8 == targetCoord
        }
    }
    return false
}

fun isHorseValid(currentCoord: Pair<Int, Int>, targetCoord: Pair<Int, Int>, pieces: Array<Pair<String, String>?>,
                 numColumns: Int, numLines: Int): Boolean {
    val first = currentCoord.first
    val second = currentCoord.second
    if (first != 0 && second != 0) {
        if (friendlyPiece(pieces, currentCoord, targetCoord, numColumns) &&
                isCoordinateInsideChess(targetCoord, numColumns, numLines)) {
            val validMove: Pair<Int, Int> = Pair((first - 2), ((second -1)));val validMove2: Pair<Int, Int> = Pair((first - 2), ((second +1)))
            val validMove3: Pair<Int, Int> = Pair((first - 1), (second - 2));val validMove4: Pair<Int, Int> = Pair((first + 1), (second - 2))
            val validMove5: Pair<Int, Int> = Pair((first + 1), (second + 2));val validMove6: Pair<Int, Int> = Pair((first - 1), (second + 2))
            val validMove7: Pair<Int, Int> = Pair((first + 2), ((second -1)));val validMove8: Pair<Int, Int> = Pair((first + 2), ((second +1)))
            return targetCoord == validMove || validMove2 == targetCoord || validMove3 == targetCoord ||
                    validMove4 == targetCoord ||
                    validMove5 == targetCoord || validMove6 == targetCoord || validMove7 == targetCoord ||
                    validMove8 == targetCoord
        }
    }
    return false
}


fun askAnswer(nome: String, numColumns: Int, numLines: Int, showLegend: Boolean, showPieces: Boolean,
              pieces: Array<Pair<String, String>?>, action: String = ""): String? {
    var opcao: String
    do {
        if (action == "") {
            println(buildBoard(numColumns, numLines, showLegend, showPieces, pieces))
        }
        println("$nome, choose a$action piece (e.g 2D).")
        println("Menu-> m;\n")
        opcao = readLine() ?: ""
        if(opcao == "" || opcao.length !in 2..2 && opcao !="m"){
            println(invalidResponse())
        }
    } while (opcao == "" || opcao.length !in 2..2 && opcao !="m")
    return opcao
}

fun totalPiecesAndTurnNoNull(info: Array<Int?>): Array<Int> {
    val realInfo: Array<Int> = arrayOf(0, 0, 0)
    for (index in 0..2) {
        val transfer = info[index]
        realInfo[index] = transfer ?: 0
    }
    return realInfo
}

fun startNewGame(whitePlayer: String, blackPlayer: String, pieces: Array<Pair<String, String>?>, totalPiecesAndTurn: Array<Int?>,
                 numColumns: Int, numLines: Int, showLegend: Boolean = false, showPieces: Boolean = false) {
    val piecesAndTurn = totalPiecesAndTurnNoNull(totalPiecesAndTurn)
    var currentCoordIndex: Int
    var currentSelectedPiece: Pair<String, String> = Pair("","")
    var currentCoord: Pair<Int, Int>
    while (piecesAndTurn[0] != 0 && piecesAndTurn[1] !=0) {
        if (piecesAndTurn[2] == 0) {
            do {
                do {
                    val branco = askAnswer(whitePlayer, numColumns, numLines, showLegend, showPieces, pieces)
                    if (branco == "m") {
                        return
                    }
                    currentCoord = getCoordinates(branco) ?: Pair(0, 0)
                    if(isCoordinateInsideChess(currentCoord,numColumns,numLines)){
                        currentCoordIndex = chessCoordinateIndex(currentCoord.second, currentCoord.first, numColumns)
                        currentSelectedPiece = pieces[currentCoordIndex] ?: Pair("", "")
                    }
                    if (!checkRightPieceSelected(currentSelectedPiece.second, piecesAndTurn[2]) || branco == null) {
                        println(invalidResponse())
                    }
                } while (!checkRightPieceSelected(currentSelectedPiece.second, piecesAndTurn[2]) || branco == null)
                val brancoAction = askAnswer(whitePlayer, numColumns, numLines, showLegend, showPieces, pieces, " target")
                if (brancoAction == "m") {
                    return
                }
                val targetCoord = getCoordinates(brancoAction) ?: Pair(0, 0)
                if (!isValidTargetPiece(currentSelectedPiece, currentCoord, targetCoord, pieces, numColumns, numLines)) {
                    println(invalidResponse())
                }
            }while (!movePiece(pieces, numColumns, numLines, currentCoord, targetCoord, piecesAndTurn))
        } else {
            do {
                do {
                    val preto = askAnswer(blackPlayer, numColumns, numLines, showLegend, showPieces, pieces)
                    if (preto == "m") {
                        return
                    }
                    currentCoord = getCoordinates(preto) ?: Pair(0, 0)
                    currentCoordIndex = chessCoordinateIndex(currentCoord.second, currentCoord.first, numColumns)
                    currentSelectedPiece = pieces[currentCoordIndex] ?: Pair("", "")
                    if (!checkRightPieceSelected(currentSelectedPiece.second, piecesAndTurn[2])) {
                        println(invalidResponse())
                    }
                } while (!checkRightPieceSelected(currentSelectedPiece.second, piecesAndTurn[2]))
                val pretoAction = askAnswer(blackPlayer, numColumns, numLines, showLegend, showPieces, pieces, " target")
                if (pretoAction == "m") {
                    return
                }
                val targetCoord = getCoordinates(pretoAction) ?: Pair(0, 0)
                if (!isValidTargetPiece(currentSelectedPiece, currentCoord, targetCoord, pieces, numColumns, numLines)) {
                    println(invalidResponse())
                }
            }while (!movePiece(pieces, numColumns, numLines, currentCoord, targetCoord, piecesAndTurn))
        }
    }
        if(piecesAndTurn[1]==0){
            println("Congrats! $whitePlayer wins!")
        }else if(piecesAndTurn[0]==0){
            println("Congrats! $blackPlayer wins!")
        }
}

fun movePieceEachPlayer(pieces: Array<Pair<String, String>?>, numColumns: Int, numLines: Int, currentCoord: Pair<Int, Int>,
                        targetCoord: Pair<Int, Int>, totalPiecesAndTurn: Array<Int>,playerTurn:Int):Boolean{
    val currentIndex = chessCoordinateIndex(currentCoord.second, currentCoord.first, numColumns)
    val targetIndex = chessCoordinateIndex(targetCoord.second, targetCoord.first, numColumns)
    return if (pieces[targetIndex] == null) {
        totalPiecesAndTurn[2] = playerTurn//1 ou 0
        pieces[targetIndex] = pieces[currentIndex]
        pieces[currentIndex] = null
        true
    } else {
        totalPiecesAndTurn[2] = playerTurn//1 ou 0
        totalPiecesAndTurn[playerTurn] -= 1
        pieces[targetIndex] = pieces[currentIndex]
        pieces[currentIndex] = null
        true
    }
}

fun movePiece(pieces: Array<Pair<String, String>?>, numColumns: Int, numLines: Int, currentCoord: Pair<Int, Int>,
              targetCoord: Pair<Int, Int>, totalPiecesAndTurn: Array<Int>): Boolean {

    val currentIndex = chessCoordinateIndex(currentCoord.second, currentCoord.first, numColumns)
    val currentSelectedPiece: Pair<String, String> = pieces[currentIndex] ?: Pair("", "")
    return if (isValidTargetPiece(currentSelectedPiece, currentCoord, targetCoord, pieces, numColumns, numLines)) {
        if (totalPiecesAndTurn[2] == 0) {
            movePieceEachPlayer(pieces, numColumns, numLines, currentCoord, targetCoord,totalPiecesAndTurn,1)
        } else {
            movePieceEachPlayer(pieces, numColumns, numLines, currentCoord, targetCoord,totalPiecesAndTurn,0)
        }
    } else {
        false
    }
}

fun isValidTargetPiece(currentSelectedPiece: Pair<String, String>, currentCoord: Pair<Int, Int>, targetCoord: Pair<Int, Int>,
                       pieces: Array<Pair<String, String>?>, numColumns: Int, numLines: Int): Boolean {
        val piece = currentSelectedPiece.first
    chessCoordinateIndex(targetCoord.second, targetCoord.first, numColumns)
            return when (piece) {
                "P" -> isKnightValid(currentCoord, targetCoord, pieces, numColumns, numLines)
                "K" -> isKingValid(currentCoord, targetCoord, pieces, numColumns, numLines)
                "Q" -> isQueenValid(currentCoord, targetCoord, pieces, numColumns, numLines)
                "B" -> isBishopValid(currentCoord, targetCoord, pieces, numColumns, numLines)
                "T" -> isTowerValid(currentCoord, targetCoord, pieces, numColumns, numLines)
                "H" -> isHorseValid(currentCoord, targetCoord, pieces, numColumns, numLines)
                else -> false
            }
}

fun isCoordinateInsideChess(coord: Pair<Int, Int>, numColumns: Int, numLines: Int): Boolean {
    val first = coord.first
    val second = coord.second
    when (numColumns*numLines){
        64 ->if (first in 1..8 && second in 1..8)return true
        49 -> if (first in 1..7 && second in 1..7)return true
        42 ->if (first in 1..6 && second in 1..6) return true
        36 -> if (first in 1..6 && second in 1..7) return true
        16 -> if (first in 1..4 && second in 1..4) return true
        else -> return false
    }
    return false
}

fun checkRightPieceSelected(pieceColor: String, turn: Int): Boolean {
    return (pieceColor == "w" && turn == 0) || (pieceColor == "b" && turn == 1)
}


fun getCoordinates(readText: String?): Pair<Int, Int>? {
    val coordinates: Pair<Int, Int>?
    if (readText != null && (readText.length in 2..2)) {
        var letra = readText[1].toString()
        val numero = readText[0].toString()
        when (letra) {
            "A", "a" -> letra = "1"
            "B", "b" -> letra = "2"
            "C", "c" -> letra = "3"
            "D", "d" -> letra = "4"
            "E", "e" -> letra = "5"
            "F", "f" -> letra = "6"
            "G", "g" -> letra = "7"
            "H", "h" -> letra = "8"
            else -> null
        }
        coordinates = Pair(numero.toInt(), letra.toInt())
        return coordinates
    }
    return null
}

fun createTotalPiecesAndTurn(numColumns: Int, numLines: Int): Array<Int?> {
    val info: Array<Int?>
    return if ((numColumns in 5..8) && (numLines in 5..8)) {
        val totalPiecesb = numColumns * 2
        val totalPiecesw = numColumns * 2
        info = arrayOf(totalPiecesw, totalPiecesb, 0)
        info
    } else if ((numColumns == 4) && (numLines == 4)) {
        info = arrayOf(2, 2, 0)
        info
    } else {
        info = arrayOf()
        info
    }
}

fun createInitialBoard(numColumns: Int, numLines: Int): Array<Pair<String, String>?> {
    val size = numColumns * numLines
    val peaoBranco = numColumns * (numLines - 2)
    val peaoPreto = numColumns * (2 - 1)
    var board: Array<Pair<String, String>?> = arrayOfNulls(size)
    if (numColumns > 4 && numLines > 4) {
        for (posicao in peaoPreto..(peaoPreto + (numColumns - 1))) {
            board[posicao] = Pair("P", "b")
        }
        for (posicao in peaoBranco..(peaoBranco + (numColumns - 1))) {
            board[posicao] = Pair("P", "w")
        }
    }
    when (board.size) {
        64 -> {
            board[chessCoordinateIndex(1, 1, numColumns)] = Pair("T", "b");board[chessCoordinateIndex(8, 1, numColumns)] = Pair("T", "b")
            board[chessCoordinateIndex(1, 8, numColumns)] = Pair("T", "w");board[chessCoordinateIndex(8, 8, numColumns)] = Pair("T", "w")
            board[chessCoordinateIndex(2, 1, numColumns)] = Pair("H", "b");board[chessCoordinateIndex(7, 1, numColumns)] = Pair("H", "b")
            board[chessCoordinateIndex(2, 8, numColumns)] = Pair("H", "w");board[chessCoordinateIndex(7, 8, numColumns)] = Pair("H", "w")
            board[chessCoordinateIndex(3, 1, numColumns)] = Pair("B", "b");board[chessCoordinateIndex(6, 1, numColumns)] = Pair("B", "b")
            board[chessCoordinateIndex(3, 8, numColumns)] = Pair("B", "w");board[chessCoordinateIndex(6, 8, numColumns)] = Pair("B", "w")
            board[chessCoordinateIndex(4, 1, numColumns)] = Pair("Q", "b");board[chessCoordinateIndex(5, 8, numColumns)] = Pair("Q", "w")
            board[chessCoordinateIndex(4, 8, numColumns)] = Pair("K", "w");board[chessCoordinateIndex(5, 1, numColumns)] = Pair("K", "b")
        }
        49 -> {
            board[chessCoordinateIndex(1, 1, numColumns)] = Pair("T", "b");board[chessCoordinateIndex(7, 1, numColumns)] = Pair("T", "b")
            board[chessCoordinateIndex(1, 7, numColumns)] = Pair("T", "w");board[chessCoordinateIndex(7, 7, numColumns)] = Pair("T", "w")
            board[chessCoordinateIndex(2, 1, numColumns)] = Pair("H", "b");board[chessCoordinateIndex(6, 1, numColumns)] = Pair("H", "b")
            board[chessCoordinateIndex(2, 7, numColumns)] = Pair("H", "w");board[chessCoordinateIndex(6, 7, numColumns)] = Pair("H", "w")
            board[chessCoordinateIndex(3, 1, numColumns)] = Pair("B", "b");board[chessCoordinateIndex(5, 1, numColumns)] = Pair("B", "b")
            board[chessCoordinateIndex(3, 7, numColumns)] = Pair("B", "w");board[chessCoordinateIndex(5, 7, numColumns)] = Pair("B", "w")
            board[chessCoordinateIndex(4, 1, numColumns)] = Pair("K", "b");board[chessCoordinateIndex(4, 7, numColumns)] = Pair("K", "w")
        }
        42 -> {
            board[chessCoordinateIndex(1, 1, numColumns)] = Pair("T", "b");board[chessCoordinateIndex(1, 7, numColumns)] = Pair("T", "w")
            board[chessCoordinateIndex(6, 1, numColumns)] = Pair("H", "b");board[chessCoordinateIndex(6, 7, numColumns)] = Pair("H", "w")
            board[chessCoordinateIndex(2, 1, numColumns)] = Pair("B", "b");board[chessCoordinateIndex(5, 1, numColumns)] = Pair("B", "b")
            board[chessCoordinateIndex(2, 7, numColumns)] = Pair("B", "w");board[chessCoordinateIndex(5, 7, numColumns)] = Pair("B", "w")
            board[chessCoordinateIndex(4, 1, numColumns)] = Pair("K", "b");board[chessCoordinateIndex(3, 7, numColumns)] = Pair("K", "w")
            board[chessCoordinateIndex(3, 1, numColumns)] = Pair("Q", "b");board[chessCoordinateIndex(4, 7, numColumns)] = Pair("Q", "w")
        }
        36 -> {
            board[chessCoordinateIndex(6, 1, numColumns)] = Pair("T", "b");board[chessCoordinateIndex(6, 6, numColumns)] = Pair("T", "w")
            board[chessCoordinateIndex(1, 1, numColumns)] = Pair("H", "b");board[chessCoordinateIndex(1, 6, numColumns)] = Pair("H", "w")
            board[chessCoordinateIndex(2, 1, numColumns)] = Pair("B", "b");board[chessCoordinateIndex(5, 1, numColumns)] = Pair("B", "b")
            board[chessCoordinateIndex(2, 6, numColumns)] = Pair("B", "w");board[chessCoordinateIndex(5, 6, numColumns)] = Pair("B", "w")
            board[chessCoordinateIndex(4, 1, numColumns)] = Pair("K", "b");board[chessCoordinateIndex(3, 6, numColumns)] = Pair("K", "w")
            board[chessCoordinateIndex(3, 1, numColumns)] = Pair("Q", "b");board[chessCoordinateIndex(4, 6, numColumns)] = Pair("Q", "w")
        }
        16 -> {
            board[chessCoordinateIndex(3, 1, numColumns)] = Pair("T", "b");board[chessCoordinateIndex(1, 4, numColumns)] = Pair("T", "w")
            board[chessCoordinateIndex(4, 1, numColumns)] = Pair("B", "b");board[chessCoordinateIndex(2, 4, numColumns)] = Pair("Q", "w")
        }
        else -> board = arrayOf()
    }
    return board
}

fun convertStringToUnicode(piece: String, color: String): String {
    return when {
        piece == "K" && color == "b" -> "\u265A";piece == "K" && color == "w" -> "\u2654"
        piece == "Q" && color == "b" -> "\u265B";piece == "Q" && color == "w" -> "\u2655"
        piece == "T" && color == "b" -> "\u265C";piece == "T" && color == "w" -> "\u2656"
        piece == "B" && color == "b" -> "\u265D";piece == "B" && color == "w" -> "\u2657"
        piece == "H" && color == "b" -> "\u265E";piece == "H" && color == "w" -> "\u2658"
        piece == "P" && color == "b" -> "\u265F";piece == "P" && color == "w" -> "\u2659"
        else -> " "
    }
}

fun invalidResponse(): String {
    return "Invalid response."
}

fun checkIsNumber(number: String): Boolean {
    return number in "0".."9"
}

fun showChessLegendOrPieces(message: String): Boolean? {
    return when (message){
        "Y","y"-> true
        "N","n"-> false
        else -> null
    }
}

fun buildBoard(numColumns: Int, numLines: Int, showLegend: Boolean = false, showPieces: Boolean = false,
               pieces: Array<Pair<String, String>?>): String {
    var legenda = 0
    val esc: String = Character.toString(27)
    val startBlue = "$esc[30;44m"
    val startGrey = "$esc[30;47m"
    val startWhite = "$esc[30;30m"
    val end = "$esc[0m"
    val desenhoExtra = "$startBlue   $end"
    var desenho = ""
    if (showLegend) {
        desenho += desenhoExtra
        while (legenda <= numColumns) {
            desenho += if (legenda == numColumns) {
                desenhoExtra
            } else {
                "$startBlue ${(65 + legenda).toChar()} $end"
            }
            legenda++
        }
        desenho += "\n"
    }
    for (linhas in 1..numLines) {
        if (showLegend) {
            desenho += "$startBlue $linhas $end"
        }
        for (colunas in 1..numColumns) {
            var cor: String
            var peca: String
            val pecaDesenho = pieces[chessCoordinateIndex(colunas, linhas, numColumns)]
            if (pecaDesenho == null) {
                peca = " "
                cor = " "
            } else {
                peca = pecaDesenho.first
                cor = pecaDesenho.second
            }
            val pecaFinal = convertStringToUnicode(peca, cor)
            desenho += if ((linhas + colunas) % 2 == 0) {
                if (showPieces) {
                    "$startWhite $pecaFinal $end"
                } else {
                    "$startWhite   $end"
                }

            } else {
                if (showPieces) {
                    "$startGrey $pecaFinal $end"
                } else {
                    "$startGrey   $end"
                }
            }
        }
        if (showLegend) {
            desenho += "$startBlue   $end"
        }
        desenho += "\n"
    }
    if (showLegend) {
        legenda = -1
        while (legenda <= numColumns) {
            desenho += desenhoExtra
            legenda++
        }
        desenho += "\n"
    }
    return desenho
}

fun checkName(number: String): Boolean {
    if (number.length > 1 && number[0] in 'A'..'Z') {
        var indice = 1
        while (indice <= number.length - 1 && number[indice] != ' ') {
            if (number[indice] in 'a'..'z') {
                indice++
            } else {
                return false
            }
        }
        if (indice == number.length) {
            return false
        } else {
            indice++
        }
        if (number[indice] in 'A'..'Z') {
            indice++
            while (indice != number.length) {
                if (number[indice] in 'a'..'z' && number[indice] != ' ') {
                    indice++
                } else {
                    return false
                }
            }
            return true
        } else {
            return false
        }
    }
    return false
}

fun buildMenu(): String {
    return "1-> Start New Game;\n2-> Exit Game.\n"
}

fun inserirNomes(perguntaNome: String): String {
    var name1: String
    do {
        println("$perguntaNome player name?\n")
        name1 = readLine() ?: ""
        if (!checkName(name1)) {
            println(invalidResponse())
        }
    } while (!checkName(name1))
    return name1
}

fun inserirLinhasEColunas(linhasOuColunas: String): Int {
    var columnsOrLines: Int?
    do {
        println("How many chess $linhasOuColunas?\n")
        columnsOrLines = readLine()?.toIntOrNull()
        if (columnsOrLines == null || columnsOrLines < 4 || !checkIsNumber(columnsOrLines.toString()) && (columnsOrLines > 8)) {
            println(invalidResponse())
        }
    } while (columnsOrLines == null || columnsOrLines < 4 || !checkIsNumber(columnsOrLines.toString()) && (columnsOrLines > 8))
    return columnsOrLines
}

fun legendaEPecas(legendaOuPecas: String): Boolean {
    var respostaLegendaOuPecas = false
    do {
        println("Show $legendaOuPecas (y/n)?\n")
        val legendaOuPecas = readLine() ?: ""
        val legendaOuPecasEmBool = showChessLegendOrPieces(legendaOuPecas)
        if (legendaOuPecasEmBool == null) {
            println(invalidResponse())
        } else respostaLegendaOuPecas = legendaOuPecasEmBool
    } while (legendaOuPecasEmBool == null)
    return respostaLegendaOuPecas
}

fun validarTabuleiro(): Pair<Int, Int> {
    var columnsAndLines: Pair<Int, Int> = Pair(0, 0)
    do {
        val chessColumns = inserirLinhasEColunas("columns")
        val chessLines = inserirLinhasEColunas("lines")
        if (!validBoard(chessColumns, chessLines)) {
            println(invalidResponse())
        } else columnsAndLines = Pair(chessColumns, chessLines)
    } while (!validBoard(chessColumns, chessLines))
    return columnsAndLines
}


fun main() {
    println("Welcome to the Chess Board Game!")
    do {
        println(buildMenu())
        val escolha = readLine()
        if (escolha != "") {
            when (escolha) {
                "1" -> {
                    val nome1 = inserirNomes("First")
                    val nome2 = inserirNomes("Second")
                    val linesAndColumns = validarTabuleiro()
                    val numColumns = linesAndColumns.first
                    val numLines = linesAndColumns.second
                    val respostaLegenda = legendaEPecas("legend")
                    val respostaPecas = legendaEPecas("pieces")
                    val pecas = createInitialBoard(numColumns, numLines)
                    val totalPiecesAndTurn = createTotalPiecesAndTurn(numColumns, numLines)
                    startNewGame(nome1, nome2, pecas, totalPiecesAndTurn, numColumns,
                            numLines, respostaLegenda, respostaPecas)
                }
                "2" -> return
            }
        }
    } while (escolha != null && escolha != "2")
}
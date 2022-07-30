var win = false
var draw = false
var emptySpace = 9
fun main() {
    emptyBoard()
}

fun emptyBoard() {
    val board = mutableListOf(mutableListOf<String>())
    val row1 = mutableListOf(" ", " ", " ")
    val row2 = mutableListOf(" ", " ", " ")
    val row3 = mutableListOf(" ", " ", " ")
    board.add(0, row1)
    board.add(1, row2)
    board.add(2, row3)

//    println("Empty Board")
    printBoardState(board)
//    println("Enter 9 elements")
//    printBoardState(addToBoard(board))
    makeMoveX(board)
//    gameState(board)
}

fun printBoardState(board: MutableList<MutableList<String>>) {
    println("---------")
    println("| " + board[0].joinToString(" ") + " |")
    println("| " + board[1].joinToString(" ") + " |")
    println("| " + board[2].joinToString(" ") + " |")
    println("---------")
}

fun makeMoveX(board: MutableList<MutableList<String>>) {
//    println("Please enter desired coordinates to insert 'X' ")
    val (xCoordinate, yCoordinate) = readln().split(" ")
//    println("xCor:$xCoordinate")
//    println("yCor:$yCoordinate")
    if (xCoordinate.toIntOrNull() == null || yCoordinate.toIntOrNull() == null) {
        println("You should enter numbers!")
//        printBoardState(board)
        makeMoveX(board)
    } else if (!(xCoordinate.toInt() in 1..3) || !(yCoordinate.toInt() in 1..3)) {
        println("Coordinates should be from 1 to 3!")
        //       printBoardState(board)
        makeMoveX(board)
    } else if ((board[xCoordinate.toInt() - 1][yCoordinate.toInt() - 1] == " ") || (board[xCoordinate.toInt() - 1][yCoordinate.toInt() - 1] == "_")) {
        board[xCoordinate.toInt() - 1][yCoordinate.toInt() - 1] = "X"
        emptySpace--
        printBoardState(board)
        winCheck(board)
        if (win == false && draw == false) {
            makeMoveO(board)
        }
    } else if (board[xCoordinate.toInt() - 1][yCoordinate.toInt() - 1] == "X" || board[xCoordinate.toInt() - 1][yCoordinate.toInt() - 1] == "O") {
        println("This cell is occupied! Choose another one!")
//        printBoardState(board)
        makeMoveX(board)
    } else {
//        printBoardState(board)
        makeMoveX(board)
    }
}

fun makeMoveO(board: MutableList<MutableList<String>>) {
//    println("Please enter desired coordinates to insert 'X' ")
    val (xCoordinate, yCoordinate) = readln().split(" ")
//    println("xCor:$xCoordinate")
//    println("yCor:$yCoordinate")
    if (xCoordinate.toIntOrNull() == null || yCoordinate.toIntOrNull() == null) {
        println("You should enter numbers!")
//        printBoardState(board)
        makeMoveO(board)
    } else if (!(xCoordinate.toInt() in 1..3) || !(yCoordinate.toInt() in 1..3)) {
        println("Coordinates should be from 1 to 3!")
//        printBoardState(board)
        makeMoveO(board)
    } else if ((board[xCoordinate.toInt() - 1][yCoordinate.toInt() - 1] == " ") || (board[xCoordinate.toInt() - 1][yCoordinate.toInt() - 1] == "_")) {
        board[xCoordinate.toInt() - 1][yCoordinate.toInt() - 1] = "O"
        emptySpace--
        printBoardState(board)
        winCheck(board)
        if (win == false && draw == false) {
            makeMoveX(board)
        }
    } else if (board[xCoordinate.toInt() - 1][yCoordinate.toInt() - 1] == "X" || board[xCoordinate.toInt() - 1][yCoordinate.toInt() - 1] == "O") {
        println("This cell is occupied! Choose another one!")
//        printBoardState(board)
        makeMoveO(board)
    } else {
//        printBoardState(board)
        makeMoveO(board)
    }
}

//fun gameState(board: MutableList<MutableList<String>>) {
//    var countX = 0
//    var countO = 0
//    var count_ = 0
//    for (i in 0 until 3) {
//        for (j in 0 until 3) {
//            if (board[i][j] == "X")
//                countX++
//            else if (board[i][j] == "O")
//                countO++
//            else if (board[i][j] == " " || board[i][j] == "_") {
//                count_++
//            }
//        }
//    }
//
//    here@
//    for (i in 0 until 3)
//        for (j in 0 until 3) {
//            if (countX == countO + 2 || countO == countX + 2) {
//                println("Impossible")
//                break@here
//            } else if (
//                        ((board[0][0] == "O" && board[0][1] == "O" && board[0][2] == "O")||
//                        (board[1][0] == "O" && board[1][1] == "O" && board[1][2] == "O") ||
//                        (board[2][0] == "O" && board[2][1] == "O" && board[2][2] == "O") ||
//
//                        (board[0][0] == "O" && board[1][0] == "O" && board[2][0] == "O") ||
//                        (board[0][1] == "O" && board[1][1] == "O" && board[2][1] == "O") ||
//                        (board[0][2] == "O" && board[1][2] == "O" && board[2][2] == "O") ||
//
//                        (board[0][0] == "O" && board[1][1] == "O" && board[2][2] == "O") ||
//                        (board[2][0] == "O" && board[1][1] == "O" && board[0][2] == "O"))
//                &&
//                        ((board[0][0] == "X" && board[0][1] == "X" && board[0][2] == "X")||
//                        (board[1][0] == "X" && board[1][1] == "X" && board[1][2] == "X") ||
//                        (board[2][0] == "X" && board[2][1] == "X" && board[2][2] == "X") ||
//
//                        (board[0][0] == "X" && board[1][0] == "X" && board[2][0] == "X") ||
//                        (board[0][1] == "X" && board[1][1] == "X" && board[2][1] == "X") ||
//                        (board[0][2] == "X" && board[1][2] == "X" && board[2][2] == "X") ||
//
//                        (board[0][0] == "X" && board[1][1] == "X" && board[2][2] == "X") ||
//                        (board[2][0] == "X" && board[1][1] == "X" && board[0][2] == "X"))
//            ) {
//                println("Impossible")
//                break@here
//            } else if (
//                (board[0][0] == "O" && board[0][1] == "O" && board[0][2] == "O") ||
//                (board[1][0] == "O" && board[1][1] == "O" && board[1][2] == "O") ||
//                (board[2][0] == "O" && board[2][1] == "O" && board[2][2] == "O") ||
//
//                (board[0][0] == "O" && board[1][0] == "O" && board[2][0] == "O") ||
//                (board[0][1] == "O" && board[1][1] == "O" && board[2][1] == "O") ||
//                (board[0][2] == "O" && board[1][2] == "O" && board[2][2] == "O") ||
//
//                (board[0][0] == "O" && board[1][1] == "O" && board[2][2] == "O") ||
//                (board[2][0] == "O" && board[1][1] == "O" && board[0][2] == "O")
//            ) {
//                println("O wins")
//                break@here
//            } else if (
//                (board[0][0] == "X" && board[0][1] == "X" && board[0][2] == "X") ||
//                (board[1][0] == "X" && board[1][1] == "X" && board[1][2] == "X") ||
//                (board[2][0] == "X" && board[2][1] == "X" && board[2][2] == "X") ||
//
//                (board[0][0] == "X" && board[1][0] == "X" && board[2][0] == "X") ||
//                (board[0][1] == "X" && board[1][1] == "X" && board[2][1] == "X") ||
//                (board[0][2] == "X" && board[1][2] == "X" && board[2][2] == "X") ||
//
//                (board[0][0] == "X" && board[1][1] == "X" && board[2][2] == "X") ||
//                (board[2][0] == "X" && board[1][1] == "X" && board[0][2] == "X")
//            ) {
//                println("X wins")
//                break@here
//            } else if (count_ > 0) {
//                println("Game not finished")
//                break@here
//            } else {
//                println("Draw")
//                break@here
//
//            }
//        }
//}


//fun addToBoard(board: MutableList<MutableList<String>>): MutableList<MutableList<String>> {
//    var enteredElements = readln().toMutableList()
//    var count = 0
//    for (i in 0 until 3) {
//        for (j in 0 until 3) {
//            board[i][j] = enteredElements[count].toString()
//            count++
//        }
//    }
//    return board
//}

fun winCheck(board: MutableList<MutableList<String>>) {
    if (
        (board[0][0] == "O" && board[0][1] == "O" && board[0][2] == "O") ||
        (board[1][0] == "O" && board[1][1] == "O" && board[1][2] == "O") ||
        (board[2][0] == "O" && board[2][1] == "O" && board[2][2] == "O") ||

        (board[0][0] == "O" && board[1][0] == "O" && board[2][0] == "O") ||
        (board[0][1] == "O" && board[1][1] == "O" && board[2][1] == "O") ||
        (board[0][2] == "O" && board[1][2] == "O" && board[2][2] == "O") ||

        (board[0][0] == "O" && board[1][1] == "O" && board[2][2] == "O") ||
        (board[2][0] == "O" && board[1][1] == "O" && board[0][2] == "O")
    ) {
        println("O wins")
        win = true

    } else if (
        (board[0][0] == "X" && board[0][1] == "X" && board[0][2] == "X") ||
        (board[1][0] == "X" && board[1][1] == "X" && board[1][2] == "X") ||
        (board[2][0] == "X" && board[2][1] == "X" && board[2][2] == "X") ||

        (board[0][0] == "X" && board[1][0] == "X" && board[2][0] == "X") ||
        (board[0][1] == "X" && board[1][1] == "X" && board[2][1] == "X") ||
        (board[0][2] == "X" && board[1][2] == "X" && board[2][2] == "X") ||

        (board[0][0] == "X" && board[1][1] == "X" && board[2][2] == "X") ||
        (board[2][0] == "X" && board[1][1] == "X" && board[0][2] == "X")
    ) {
        println("X wins")
        win = true
    } else if (emptySpace == 0 && win == false) {
        println("Draw")
        draw = true
    }
}

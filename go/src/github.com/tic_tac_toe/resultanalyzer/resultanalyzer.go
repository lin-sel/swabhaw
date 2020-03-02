package resultanalyzer

import (
	"fmt"
	"math"

	"github.com/lin-sel/tic_tac_toe/board"
	"github.com/lin-sel/tic_tac_toe/cell"
)

// ResultAnalyzer Service
type ResultAnalyzer struct{}

// NewResultAnalyzer Return Object Of Result Analyzer
func NewResultAnalyzer() *ResultAnalyzer {
	return &ResultAnalyzer{}
}

// AnalyzeBoard analyze whole board
func (analyzer *ResultAnalyzer) AnalyzeBoard(position uint8, board *board.Board) bool {
	col := uint8(math.Sqrt(float64(board.Size)))
	row := uint8(position / col)
	fmt.Println(col)
	var status bool
	// if position == 0 {
	// 	status = analyzer.diagonalCheck(0, col+1, board, col)
	// } else if position%(col-1) == 0 {
	// 	fmt.Println("reverse")
	// 	status = analyzer.diagonalCheck(col-1, col-1, board, col) || status
	// }

	status = analyzer.verticalCheck(position, board, col, row)
	return status
}

func (analyzer *ResultAnalyzer) horizontalCheck(initpos uint8, increment uint8, board *board.Board, col uint8) bool {
	return checkBoard(initpos, increment, board, col, col-2)
}

func (analyzer *ResultAnalyzer) verticalCheck(position uint8, board *board.Board, col uint8, row uint8) bool {
	// uint8(position/col), col,initpos uint8, increment uint8,
	fmt.Println(col*row, row, col)
	initpos := position - (col * row)
	endpos := initpos + col*(col-1)
	return checkBoard(initpos, col, board, col, endpos)
}

func (analyzer *ResultAnalyzer) diagonalCheck(initpos uint8, increment uint8, board *board.Board, col uint8) bool {
	endpos := board.Size - increment - 1
	return checkBoard(initpos, increment, board, col, endpos)
}

func checkBoard(initpos uint8, increment uint8, board *board.Board, col uint8, endpos uint8) bool {
	for initpos = initpos; initpos <= endpos; initpos += increment {
		mark, _ := board.GetMark(initpos)
		mark2, _ := board.GetMark(initpos + increment)
		fmt.Println(mark, mark2, initpos, increment, col, endpos)
		if mark == mark2 && mark != cell.NoMark && mark2 != cell.NoMark {
			continue
		}
		return false
	}
	return true
}

// func (analyzer *ResultAnalyzer) checkBoard(initpos uint8, board *board.Board) {
// 	for initpos; initpos < endpos; initpos++ {
// 		if board.GetMark(initpos) == board.GetMark(initpos+1) || board.GetMark(initpos) != cell.NoMark {
// 			continue
// 		}
// 		return false
// 	}
// 	return true
// }

// func (analyzer *ResultAnalyzer) verticalCheck() {

// }

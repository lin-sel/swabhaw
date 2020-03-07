package resultanalyzer

import (
	"math"

	"github.com/lin-sel/tic_tac_toe/board"
	"github.com/lin-sel/tic_tac_toe/cell"
)

type status uint8

const (
	Draw    status = 0
	Win     status = 1
	Running status = 2
)

// ResultAnalyzer Service
type ResultAnalyzer struct{}

// NewResultAnalyzer Return Object Of Result Analyzer
func NewResultAnalyzer() *ResultAnalyzer {
	return &ResultAnalyzer{}
}

// AnalyzeBoard analyze whole board
func (analyzer *ResultAnalyzer) AnalyzeBoard(position uint8, board *board.Board) status {
	col := uint8(math.Sqrt(float64(board.Size)))
	row := uint8(position / col)
	var st bool = false
	if position == 0 {
		st = analyzer.diagonalCheck(position, board, col, row)
	} else if position%(col-1) == 0 {
		st = analyzer.diagonalRCheck(position, board, col, row) || st
	}

	st = analyzer.verticalCheck(position, board, col, row) ||
		analyzer.horizontalCheck(position, board, col, row) || st

	if !st {
		st = analyzer.isDraw(board)
	}
	return st
}

func (analyzer *ResultAnalyzer) isDraw(board *board.Board) bool {
	for i := uint8(0); i < board.Size; i++ {
		if mark, _ := board.GetMark(i); mark != cell.NoMark {
			continue
		}
		return false
	}
	return true
}

// Horizontal Check from Position
func (analyzer *ResultAnalyzer) horizontalCheck(position uint8,
	board *board.Board, col uint8, row uint8) bool {
	initpos := position - (col * row)
	endpos := initpos + col*(col-1)
	return checkBoard(initpos, 1, board, col, endpos)
}

// Verical Check from Position
func (analyzer *ResultAnalyzer) verticalCheck(position uint8,
	board *board.Board, col uint8, row uint8) bool {
	initpos := position - (col * row)
	endpos := initpos + col*(col-1)
	return checkBoard(initpos, col, board, col, endpos)
}

// Diagonal Check from Position
func (analyzer *ResultAnalyzer) diagonalCheck(position uint8,
	board *board.Board, col uint8, row uint8) bool {
	endpos := board.Size - 1
	return checkBoard(0, col+1, board, col, endpos)
}

// Reverse Diagonal Check from Position
func (analyzer *ResultAnalyzer) diagonalRCheck(position uint8,
	board *board.Board, col uint8, row uint8) bool {
	endpos := board.Size - col
	return checkBoard(col-1, col-1, board, col, endpos)
}

// Base Function for Board Check
func checkBoard(initpos uint8, increment uint8, board *board.Board, col uint8, endpos uint8) bool {
	for index := initpos; index < endpos; index = index + increment {
		mark, _ := board.GetMark(index)
		mark2, _ := board.GetMark(index + increment)
		if mark == mark2 && mark != cell.NoMark && mark2 != cell.NoMark {
			continue
		}
		return false
	}
	return true
}

package resultanalyzer

import (
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
	var status bool = false
	if position == 0 {
		status = analyzer.diagonalCheck(position, col+1, board, col)
	} else if position%(col-1) == 0 {
		status = analyzer.diagonalCheck(col-1, col-1, board, col) || status
	}

	status = analyzer.verticalCheck(position, board, col, row) || analyzer.horizontalCheck(position, board, col, row)
	return status
}

func (analyzer *ResultAnalyzer) horizontalCheck(position uint8, board *board.Board, col uint8, row uint8) bool {
	initpos := position - (col * row)
	endpos := initpos + col*(col-1)
	return checkBoard(initpos, 1, board, col, endpos)
}

func (analyzer *ResultAnalyzer) verticalCheck(position uint8, board *board.Board, col uint8, row uint8) bool {
	initpos := position - (col * row)
	endpos := initpos + col*(col-1)
	return checkBoard(initpos, col, board, col, endpos)
}

func (analyzer *ResultAnalyzer) diagonalCheck(initpos uint8, increment uint8, board *board.Board, col uint8) bool {
	endpos := board.Size - increment - 1
	return checkBoard(initpos, increment, board, col, endpos)
}

func checkBoard(initpos uint8, increment uint8, board *board.Board, col uint8, endpos uint8) bool {
	for initpos = initpos; initpos < endpos; initpos += increment {
		mark, _ := board.GetMark(initpos)
		mark2, _ := board.GetMark(initpos + increment)
		if mark == mark2 && mark != cell.NoMark && mark2 != cell.NoMark {
			continue
		}
		return false
	}
	return true
}

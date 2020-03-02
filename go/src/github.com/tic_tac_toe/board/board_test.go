package board

import (
	"testing"

	"github.com/lin-sel/tic_tac_toe/cell"
)

func TestBoardSize(t *testing.T) {
	board := NewBoard(3)
	size := len(board.cells)
	if size != 9 {
		t.Errorf("Expected %v and Actual %v", 9, size)
	}
}

func TestBoardObject(t *testing.T) {
	board := NewBoard(3)
	if board == (&Board{}) {
		t.Error("Excepted Board Object But Nil Found")
	}
}

func TestGetMark(t *testing.T) {
	board := NewBoard(3)
	if board.cells[0].GetMark() != cell.NoMark {
		t.Errorf("Expected %v and Actual %v", cell.NoMark, board.cells[0].GetMark())
	}
}

func TestSetMark(t *testing.T) {
	board := NewBoard(3)
	board.SetMark(0, cell.CrossMark)
	if board.cells[0].GetMark() != cell.CrossMark {
		t.Errorf("Expected %v and Actual %v", cell.CrossMark, board.cells[0].GetMark())
	}
}

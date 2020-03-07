package resultanalyzer

import (
	"math"
	"testing"

	"github.com/lin-sel/tic_tac_toe/board"
	"github.com/lin-sel/tic_tac_toe/cell"
)

func fillVertical(b *board.Board, c uint8, m cell.Mark) {
	size := uint8(math.Sqrt(float64(b.Size)))
	for i := uint8(0); i < b.Size; i++ {
		b.SetMark(i*size+c, m)
	}
}

func fillHorizontal(b *board.Board, r uint8, m cell.Mark) {
	lim := r*b.Size + b.Size
	for i := r * b.Size; i < lim; i++ {
		b.SetMark(i, m)
	}
}

func fillDiagonal(b *board.Board, m cell.Mark) {
	size := uint8(math.Sqrt(float64(b.Size)))
	for i := uint8(0); i < size; i++ {
		b.SetMark(i*size+i, m)
	}
}

func fillRDiagonal(b *board.Board, m cell.Mark) {
	size := uint8(math.Sqrt(float64(b.Size)))
	for i := uint8(0); i < size; i++ {
		index := (i * size) + (size - 1 - i)
		b.SetMark(index, m)
	}
}

func TestResultAnalyzerObject(t *testing.T) {
	analyzer := NewResultAnalyzer()
	if analyzer == nil {
		t.Error("Expected Object Got nil")
	}
}

func TestLinear(t *testing.T) {
	b := board.NewBoard(3)
	analyzer := NewResultAnalyzer()
	fillHorizontal(b, 0, 1)
	expected, actual := true, analyzer.AnalyzeBoard(0, b)
	if expected != actual {
		t.Errorf("Expected %v and Actual %v", expected, actual)
	}
}

func TestDiagonal(t *testing.T) {
	b := board.NewBoard(3)
	analyzer := NewResultAnalyzer()
	fillDiagonal(b, 1)
	expected, actual := true, analyzer.AnalyzeBoard(0, b)
	if expected != actual {
		t.Errorf("Expected %v and Actual %v", expected, actual)
	}
}

func TestRDiagonal(t *testing.T) {
	b := board.NewBoard(3)
	analyzer := NewResultAnalyzer()
	fillRDiagonal(b, 1)
	expected, actual := true, analyzer.AnalyzeBoard(2, b)
	if expected != actual {
		t.Errorf("Expected %v and Actual %v", expected, actual)
	}
}

func TestVertical(t *testing.T) {
	b := board.NewBoard(3)
	analyzer := NewResultAnalyzer()
	fillVertical(b, 1, 1)
	expected, actual := true, analyzer.AnalyzeBoard(1, b)
	if expected != actual {
		t.Errorf("Expected %v and Actual %v", expected, actual)
	}
}

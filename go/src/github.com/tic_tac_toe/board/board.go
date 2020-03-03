package board

import (
	"errors"

	"github.com/lin-sel/tic_tac_toe/cell"
)

// Board Structure
type Board struct {
	Size  uint8
	cells []*cell.Cell
}

// NewBoard Return New Board
func NewBoard(size uint8) *Board {
	var cells []*cell.Cell
	var index uint8
	size = size * size
	for index = 0; index < size; index++ {
		cells = append(cells, cell.NewCell())
	}
	return &Board{
		Size:  size,
		cells: cells,
	}
}

// SetMark Add Mark to Cell
func (board *Board) SetMark(index uint8, mark cell.Mark) error {
	if index <= board.Size {
		return board.cells[index].AddMark(mark)
	}
	return errors.New("Invalid Position of Mark into Board")
}

//GetMark get Mark
func (board *Board) GetMark(index uint8) (cell.Mark, error) {
	if index < board.Size {
		return board.cells[index].GetMark(), nil
	}
	return cell.NoMark, errors.New("Inavlid Index")
}

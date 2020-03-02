package cell

import "errors"

// Mark As Enum
type Mark uint8

const (
	//NoMark Default Mark
	NoMark Mark = 0
	// CrossMark With 1
	CrossMark Mark = 1
	//ZeroMark With 2
	ZeroMark Mark = 2
)

// Cell Structure
type Cell struct {
	mark Mark
}

// NewCell Return new Cell Object
func NewCell() *Cell {
	return &Cell{
		mark: NoMark,
	}
}

// AddMark TO Cell
func (cell *Cell) AddMark(mark Mark) error {
	if cell.mark == NoMark {
		cell.mark = mark
		return nil
	}
	return errors.New("Cell Already Mark")
}

// GetMark Return Mark
func (cell *Cell) GetMark() Mark {
	return cell.mark
}

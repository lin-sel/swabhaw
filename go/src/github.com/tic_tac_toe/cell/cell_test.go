package cell

import "testing"

func TestCellObject(t *testing.T) {
	cell := NewCell()
	if cell == nil {
		t.Error("Excepted Cell Object But Actual Getting Nil")
	}
}

func TestCellDefaultMark(t *testing.T) {
	cell := NewCell()
	if cell.GetMark() != 0 {
		t.Errorf("Expected %d and Actual %d", 0, cell.GetMark())
	}
}

func TestCellMarkChange(t *testing.T) {
	cell := NewCell()
	cell.AddMark(CrossMark)
	if cell.GetMark() != CrossMark {
		t.Errorf("Expected %d and Actual %d", CrossMark, cell.GetMark())
	}
}

func TestCellMarkChangeError(t *testing.T) {
	cell := NewCell()
	cell.AddMark(CrossMark)
	err := cell.AddMark(ZeroMark)
	if err == nil {
		t.Errorf("Expected %v and Actual %v", "Cell Already Mark", err)
	}
}

package game

import "github.com/lin-sel/tic_tac_toe/cell"

type Player struct {
	Name string
	Mark cell.Mark
}

func NewPlayer(nm string, mk cell.Mark) *Player {
	return &Player{
		Name: nm,
		Mark: mk,
	}
}

// func (player *Player) GetMark() cell.Cell {
// 	return player.mark
// }

// func (player *Player) GetName() string {
// 	return player.name
// }

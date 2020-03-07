package game

import (
	"github.com/lin-sel/tic_tac_toe/board"
	"github.com/lin-sel/tic_tac_toe/resultanalyzer"
)

// Game Structure
type Game struct {
	board   *board.Board
	players [2]*Player
	turn    uint8
	ra      *resultanalyzer.ResultAnalyzer
}

// NewGame Return Game Struct
func NewGame(size uint8, player [2]*Player) *Game {
	return &Game{
		board:   board.NewBoard(size),
		players: player,
		ra:      resultanalyzer.NewResultAnalyzer(),
		turn:    0,
	}
}

// Play Start Game
func (game *Game) Play(cellid uint8) (bool, error) {
	cmark := game.players[game.turn].Mark
	if err := game.board.SetMark(cellid, cmark); err != nil {
		return false, err
	}
	return game.ra.AnalyzeBoard(cellid, game.board), nil
}

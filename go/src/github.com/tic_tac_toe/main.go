package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"

	"github.com/lin-sel/tic_tac_toe/game"
)

func main() {
	player := createPlayer()
	fmt.Println(player[0].Name, player[1].Mark)
}

func createPlayer() []game.Player {
	players := make([]game.Player, 2)
	players = append(players, game.Player{
		Name: getInput("Enter Name"),
		Mark: 1,
	})
	players = append(players, game.Player{
		Name: getInput("Enter Name"),
		Mark: 2,
	})
	return players
}

func getInput(st string) string {
	fmt.Println(st)
	reader := bufio.NewReader(os.Stdin)
	input, err := reader.ReadString('\n')
	if err != nil {
		fmt.Println(err)
	}
	input = input[:len(input)-1]
	input = strings.Trim(input, " ")
	if input != "" {
		return input
	}
	return getInput(st)
}

package blueball

import (
	"bufio"
	"errors"
	"fmt"
	"math/rand"
	"os"
	"strconv"
	"strings"
	"time"
)

// MIN_NUMBER for Random Number Range
const minNumber = 0

// MAX_NUMBER for Random Number Range
const maxNumber = 10

//BLUEBALL number
var BLUEBALL int64 = getMagicNumber()

// STATUS for Game Result
var STATUS []string = []string{"You win the game", "You have Enter Big Number", "You have Enter Small Number"}

// func main() {
// 	geussBallNum(5)
// }

// GuessBallNum test
func GuessBallNum(step int) {

	var status int
	var reader = bufio.NewReader(os.Stdin)
	fmt.Printf("Note: Ball are Between %d to %d\n", minNumber, maxNumber)
	for step > 0 {
		fmt.Println("Enter Number")
		input, err := getInput(reader)
		if err != nil {
			fmt.Println(err)
			continue
		}
		status = checkNumber(input)
		fmt.Println(STATUS[status])
		if status == minNumber {
			os.Exit(minNumber)
		}
		step--
	}
	if step == minNumber && status != minNumber {
		fmt.Println("You lose the game try next time.")
	}

}

func getInput(reader *bufio.Reader) (int64, error) {
	input, err := reader.ReadString('\n')
	if err != nil {
		return -1, errors.New("Reader Can't Read input")
	}

	input = strings.Replace(input, "\n", "", -1)
	in, err := strconv.ParseInt(input, maxNumber, 64)
	if err != nil {
		return -1, errors.New("Input not a Number")
	}
	return in, nil
}

func checkNumber(userinput int64) int {
	if userinput > BLUEBALL {
		return 1
	} else if userinput < BLUEBALL {
		return 2
	}
	return minNumber
}

func getMagicNumber() int64 {
	rand.Seed(time.Now().UnixNano())
	return rand.Int63n(maxNumber)
}

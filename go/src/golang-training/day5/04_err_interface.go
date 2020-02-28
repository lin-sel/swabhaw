package main

import (
	"errors"
	"fmt"
)

func main() {

	if i, err := cubeEvenNo(2); err != nil {
		fmt.Println(err.Error())
	} else {
		fmt.Println(i)
	}

}

func cubeEvenNo(no int) (int, error) {
	if no%2 != 0 {
		return 0, errors.New("Not Even Number")
	}
	return no * no * no, nil
}

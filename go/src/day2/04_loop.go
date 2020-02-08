package main

import (
	"fmt"
	"time"
)

func main() {
	case1()
}

func case1() {

	loop := 1
	for loop < 10 {
		fmt.Println(time.Now())
		loop++
	}
}

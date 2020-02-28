package main

import "fmt"

func main() {
	defer func() {
		fmt.Println("Prinln in main")
	}()

	defer f2()
}

func f2() {
	fmt.Println("Inside f2 function")
}

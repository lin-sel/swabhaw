package main

import "fmt"

func main() {
	defer func() {
		fmt.Println("Inside main function")
	}()

	f1()

	fmt.Println("End of the main")
}

func f1() {
	fmt.Println("Inside f1")
	defer f2()
}

func f2() {
	fmt.Println("Inside f2")
}

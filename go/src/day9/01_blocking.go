package main

import (
	"fmt"
	"time"
)

func main() {
	fmt.Println("Inside main")

	func() {
		time.Sleep(3 * time.Second)
		fmt.Println("After 3 second func 1")
	}()

	func() {
		time.Sleep(3 * time.Second)
		fmt.Println("After 3 second func 2")
	}()

	fmt.Println("End of the Program...")
}

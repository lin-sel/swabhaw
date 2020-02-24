package main

import (
	"fmt"
	"time"
)

// var wait sync.WaitGroup

func main() {

	// wait.Add(2)
	go func() {
		// defer wait.Done()
		time.Sleep(3 * time.Second)
		fmt.Println("Function 1")
	}()

	go func() {
		// defer wait.Done()
		time.Sleep(3 * time.Second)
		fmt.Println("Function 2")
	}()

	fmt.Println("End of the Program")

	// wait.Wait()
	fmt.Scanln()
}

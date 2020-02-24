package main

import "fmt"

func main() {
	go func() {
		for i := 0; i < 100; i++ {
			fmt.Println("function 1", i)
		}
	}()

	go func() {
		for i := 0; i < 100; i++ {
			fmt.Println("function 2", i)
		}
	}()

	fmt.Scanln()
}

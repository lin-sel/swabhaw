package main

import "fmt"

func main() {
	fmt.Println("Inside main function")
	m1()
	fmt.Println("End of the Main")
}

func m1() {
	defer func() {
		if err := recover(); err != nil {
			fmt.Printf("Type of Err is %T\n", err)
		}
	}()

	panic("Get out of the function")

	fmt.Println("End of the m1")
}

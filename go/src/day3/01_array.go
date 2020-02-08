package main

import "fmt"

func main() {
	marks := [3]int{1, 2, 3}

	for index, value := range marks {
		fmt.Printf("%d %d ", index, value)
	}
	fmt.Println(marks)

	markcopy := marks

	markcopy[0] = 0

	fmt.Println(markcopy)
	fmt.Println(marks)
}

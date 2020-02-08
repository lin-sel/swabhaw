package main

import "fmt"

func main() {
	nos := []int{10, 20, 30}

	fmt.Println("Total sum of slice", sum(nos...))
}

func sum(nos ...int) (sum int) {
	fmt.Printf("Type of nos in sum function %T\n", nos)
	for _, val := range nos {
		sum += val
	}
	return
}

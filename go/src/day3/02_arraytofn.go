package main

import "fmt"

func main() {
	marks := [3]int{1, 2, 3}
	fmt.Println(marks)
	change(&marks)
	fmt.Println(marks)

}

func modify(arr [3]int) {
	for i := 0; i < len(arr); i++ {
		arr[i] = 0
	}
}

func change(arr *[3]int) {
	for i := 0; i < len(arr); i++ {
		arr[i] = 0
	}
}

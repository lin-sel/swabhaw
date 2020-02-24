package main

import "fmt"

func main() {
	ch := make(chan string, 1)

	ch <- "String"

	fmt.Println(<-ch)

	// ch <- "wand"
}

package main

import "fmt"

func main() {
	ch := make(chan string)

	ch <- "hello"

	fmt.Println(<-ch)
}

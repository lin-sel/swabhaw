package main

import "fmt"

func main() {
	ch := make(chan string)

	go goFunction(ch)
	fmt.Println(<-ch)
}

func goFunction(ch chan<- string) {
	ch <- "hello"
}

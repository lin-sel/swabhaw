package main

func main() {

	// Buffered Channel cant garanteed to deliver to message.
	ch := make(chan int, 10)
	ch <- 10
}

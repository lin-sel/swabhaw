package main

import "fmt"

func main() {
	port := map[int]string{80: "HTTP", 23: "Telnet"}
	fmt.Println(port)

	// Iterate over map
	for index, val := range port {
		fmt.Printf("index: %d and Value: %s\n", index, val)
	}

	delete(port, 99)
	fmt.Println("Map: ", port)
}

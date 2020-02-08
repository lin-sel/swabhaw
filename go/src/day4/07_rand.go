package main

import (
	"fmt"
	"math/rand"
	"time"
)

func main() {

	// Generate Random Number with default sequence based on seed by default seed is 1.
	for i := 0; i < 4; i++ {
		fmt.Println(rand.Int31())
	}

	// Generate Random Number with nanosecond sequence based on seed nano second change every time. so it will give us random number every time.
	rand.Seed(time.Now().UnixNano())
	for i := 0; i < 4; i++ {
		fmt.Println(rand.Intn(100))
	}
}

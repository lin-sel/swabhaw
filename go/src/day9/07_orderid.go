package main

import (
	"fmt"
	"math/rand"
	"time"
)

type order struct {
	amount int
	id     int32
}

var product []*order

func main() {
	fmt.Println(placeOrder(1220))
}

func placeOrder(amount int) int32 {
	id := randomID()
	product = append(product, &order{amount, id})
	return id
}

// randomId generate Random
func randomID() int32 {
	rand.Seed(time.Now().Unix())
	return rand.Int31()
}

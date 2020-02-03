package main

import (
	"fmt"
	"math"
)

// Foo Type
type Foo struct {
	name string
}

func (ab Foo) printName() {
	fmt.Println(ab.name)
}

func main() {
	var name = "Niranjan"
	var cgpa float64 = 7.8
	_ = 1001

	var ab = Foo{name: "Nilesh"}

	fmt.Println(ab)

	ab.printName()

	var s uint64 = uint64(math.Abs(-1))

	fmt.Println(name, cgpa, s)

	// fmt.Println(2 &^ 63)
}

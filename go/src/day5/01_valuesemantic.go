package main

import "fmt"

// Printable interface
type Printable interface {
	print()
}

// Customer Detail
type Customer struct {
	name string
	id   int
}

func (c Customer) print() {
	fmt.Printf("Id %d and name %s \n", c.id, c.name)
}

func main() {

	var p Printable = Customer{"abc", 101}
	p.print()

	var p1 Printable = &Customer{"abcd", 102}
	p1.print()
}

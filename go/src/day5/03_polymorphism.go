package main

import "fmt"

// Movable Interface
type Movable interface {
	move()
}

// Truck struct
type Truck struct {
	name string
}

func (t *Truck) move() {
	fmt.Printf("%s is moving\n", t.name)
}

// Bike struct
type Bike struct {
	name string
}

func (b *Bike) move() {
	fmt.Printf("%s is moving\n", b.name)
}

// Car struct
type Car struct {
	name string
}

func (c *Car) move() {
	fmt.Printf("%s is moving\n", c.name)
}

func main() {

	race([]Movable{&Car{"Car"}, &Truck{"Truck"}, &Bike{"Bike"}})
}

func race(vehicle []Movable) {
	for _, v := range vehicle {
		v.move()
	}
}

package main

import "fmt"

// Movable move
type Movable interface{
	move()
}

// Car details
type Car struct{
	name string
}


func (c *Car) move(){
	fmt.Printf("Car %s is moving\n", c.name)
}


func main(){
	var car Movable = &Car{"Tesla"}
	car.move()
}
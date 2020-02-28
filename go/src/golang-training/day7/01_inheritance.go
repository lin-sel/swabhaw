package main

import "fmt"

// Name Firstname lastname
type Name struct {
	FirstName string
	LastName  string
}

func (name *Name) printName() {
	fmt.Println(name.FirstName, name.LastName)
}

// Customer Detail
type Customer struct {
	Name
	balance float64
}

func (c1 *Customer) printDetail() {
	c1.printName()
	fmt.Println(c1.balance, c1.FirstName, c1.LastName)
}

// Student Detail
type Student struct {
	Name
	cgpa float64
}

func main() {
	c1 := Customer{Name{"ABC", "XYZ"}, 10.00}
	c1.printDetail()
}

// esperanze gomez

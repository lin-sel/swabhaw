package main

import (
	"fmt"
)

type Subscriber struct {
	Name   string
	Rate   float64
	Active bool
	Address
}

type Employee struct {
	Name   string
	Salary float64
	Address
}

type Address struct {
	Street, City, State, PostalCode string
}

// YOUR CODE HERE:
// Define a struct type named Address that has Street, City, State,
// and PostalCode fields, each with a type of "string".
// Then embed the Address type within the Subscriber and Employee
// types using anonymous fields, so that the code in "main" will
// compile, run, and produce the output shown.

func main() {
	var subscriber Subscriber
	subscriber.Name = "Aman Singh"
	subscriber.Street = "123 Oak St"
	subscriber.City = "Omaha"
	subscriber.State = "NE"
	subscriber.PostalCode = "68111"
	fmt.Println("Name:", subscriber.Name)              // => Name: Aman Singh
	fmt.Println("Street:", subscriber.Street)          // => Street: 123 Oak St
	fmt.Println("City:", subscriber.City)              // => City: Omaha
	fmt.Println("State:", subscriber.State)            // => State: NE
	fmt.Println("Postal Code:", subscriber.PostalCode) // => Postal Code: 68111

	var employee Employee
	employee.Name = "Joy Carr"
	employee.Street = "456 Elm St"
	employee.City = "Portland"
	employee.State = "OR"
	employee.PostalCode = "97222"
	fmt.Println("Name:", employee.Name)              // => Name: Joy Carr
	fmt.Println("Street:", employee.Street)          // => Street: 456 Elm St
	fmt.Println("City:", employee.City)              // => City: Portland
	fmt.Println("State:", employee.State)            // => State: OR
	fmt.Println("Postal Code:", employee.PostalCode) // => Postal Code: 97222
}

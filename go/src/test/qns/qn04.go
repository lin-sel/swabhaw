package main

import (
	"fmt"
	"log"
	"strconv"
)

func main() {
	string1 := "12.345"
	string2 := "1.234"

	// YOUR CODE HERE:
	// Look up documentation for the "strconv" package's
	// ParseFloat function. (You can use either "go doc"
	// or a search engine.) Use ParseFloat to convert
	// string1 to a float64 value. Assign the converted
	// number to the variable number1, and any error value
	// to the variable err. Use the integer 64 for
	// ParseFloat's bitSize argument.

	var number1, number2 float64
	var err error

	number1, err = strconv.ParseFloat(string1, 64)

	fmt.Println(number1)

	if err != nil {
		log.Fatal("Could not parse string")
	}

	// YOUR CODE HERE:
	// Use ParseFloat to convert string2 to a float64
	// value. Assign the converted number to the variable
	// number2, and any error value to the variable err.

	number2, err = strconv.ParseFloat(string2, 64)

	if err != nil {
		log.Fatal("Could not parse string")
	}

	fmt.Println(number1 - number2)
}

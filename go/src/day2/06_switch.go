package main

import "fmt"

func main() {
	switch cgpa := 6; {
	case cgpa > 8:
		fmt.Println("8")
	case cgpa > 5 && cgpa < 8:
		fmt.Println(cgpa)
	default:
		fmt.Println("Something wrong")
	}

	switch cgpa := 6; cgpa {
	case 8:
		fmt.Println("8")
	case 5:
		fmt.Println(cgpa)
	default:
		fmt.Println("Something wrong")
	}

}

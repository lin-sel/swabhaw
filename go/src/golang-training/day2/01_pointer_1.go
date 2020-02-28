package main

import "fmt"

func main() {

	// case1()
	case2()
}

// case1
func case1() {
	name := "Swabhaw"
	fmt.Printf(" Type of &name %T", &name)
	fmt.Println(&name)

	var printToname *string = &name
	fmt.Printf("Type of printToname %T \n", printToname)
	fmt.Println(printToname, *printToname)
	fmt.Printf(" Type of &name %T", &name)
	fmt.Println(&name)

	// var printToname *string = &name
	fmt.Printf("Type of printToname %T \n", printToname)
	fmt.Println(printToname, *printToname)
}

// case2
func case2() {
	mark := 10
	var pointertomark = &mark
	var pointertopointer = &pointertomark

	fmt.Println(pointertomark)
	fmt.Println(pointertopointer)
	fmt.Println(*pointertomark)
	fmt.Println(*pointertopointer)

	fmt.Println(*pointertomark == **pointertopointer)
	fmt.Println(*pointertopointer == pointertomark)
}

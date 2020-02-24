// Update this program as described below.

package main

import "fmt"

// negate takes a boolean value and returns its
// opposite. E.g.: negate(false) returns true.
// But we WANT this function to accept a POINTER
// to a boolean value, and update the value at
// the pointer to its opposite. Once this change
// is made, the function doesn't need to return
// anything.
func negate(myBoolean *bool) {
	if *myBoolean {
		*myBoolean = false
		return
	}
	*myBoolean = true
}

func main() {
	truth := true
	// Change this to pass a pointer.
	negate(&truth)
	// Prints "true", but we want "false".
	fmt.Println(truth)
	lies := false
	// Change this to pass a pointer.
	negate(&lies)
	// Prints "false", but we want "true".
	fmt.Println(lies)
}

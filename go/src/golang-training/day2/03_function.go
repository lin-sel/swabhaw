package main

import (
	"fmt"
	"strings"
)

func main() {
	_, _ = ConvertToUpper("firstname", "lastname")

	fmt.Println(ConvertToUpper("Firstname", "lastname"))

}

// ConvertToUpper
func ConvertToUpper(firstname, lastname string) (first string, last string) {
	first, last = strings.ToUpper(firstname), strings.ToUpper(lastname)
	// ti
	return
}

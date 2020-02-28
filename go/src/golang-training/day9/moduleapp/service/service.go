package moduleapp

import "fmt"

var (
	// PORT Number
	PORT = 80
	// URL detail
	URL = "WWW.google.com"
)

const (
	// CLIENT Data
	CLIENT = "cyberInc"
)

func init() {
	fmt.Println(CLIENT)
	fmt.Println("Inside init")
}

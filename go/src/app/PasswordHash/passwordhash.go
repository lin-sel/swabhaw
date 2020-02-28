package main

import (
	"fmt"

	"golang.org/x/crypto/bcrypt"
)

func main() {
	byt, _ := bcrypt.GenerateFromPassword([]byte("nilesh"), 1)
	fmt.Println(string(byt))

	fmt.Println(bcrypt.CompareHashAndPassword([]byte(byt), []byte("nilesh")))
}

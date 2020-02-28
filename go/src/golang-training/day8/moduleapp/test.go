package main

import (
	"fmt"
	"moduleapp/greeting"
	"moduleapp/greeting/hindi"
)

func main() {
	fmt.Println(greeting.Greeting())
	fmt.Println(hindi.HindiFunc())

}

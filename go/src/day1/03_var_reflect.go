package main

import (
	"fmt"
	"reflect"
)

var (
	name   string
	cgpa   float64
	rollno float64
	foo    string
)

func main() {
	fmt.Println("type of name is", reflect.TypeOf(name), name)
	fmt.Println("type of cgpa is", reflect.TypeOf(cgpa), cgpa)
	fmt.Println("type of name is", reflect.TypeOf(rollno), rollno)
}

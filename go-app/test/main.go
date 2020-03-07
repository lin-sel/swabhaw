package main

import (
	"fmt"
	"reflect"
)

type test struct {
	ID      int
	Balance float32
}

func main() {
	v := reflect.ValueOf(test{})
	fmt.Println(v)
	// val := interface{}(23)
	// for i := 0; i < v.NumField(); i++ {
	fmt.Println((v.Kind()))
	// }
	// fmt.Println(int(23))
}

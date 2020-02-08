package main

import (
	"fmt"
	"runtime"
)

func main() {
	fmt.Print("Hello form fmt")
	fmt.Println(runtime.GOOS)
	fmt.Println(runtime.GOARCH)
}

package main

import (
	"fmt"
	"runtime"
)

func main(){
	fmt.Print("Hello form fmt")
	runtime.GOOS()
	runtime.GOARCH()
}
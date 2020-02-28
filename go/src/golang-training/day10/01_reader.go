package main

import (
	"fmt"
	"net/http"
)

func main() {
	resp, _ := http.Get("http://swabhavtechlabs.com/")
	fmt.Printf("Type: %T\n", resp)

	fmt.Printf("Body Type %T\n", resp.Body)
	// fmt.Println(resp.Trailer)
	sb := make([]byte, 5*1024)

	resp.Body.Read(sb)

	fmt.Println(string(sb))
	// for _, s := range sb {
	// 	fmt.Println(rune(s))
	// }
}

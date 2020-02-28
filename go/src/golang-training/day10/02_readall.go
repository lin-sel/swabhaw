package main

import (
	"fmt"
	"io/ioutil"
	"net/http"
)

func main() {
	// url := []{"http://swabhavtechlabs.com/", "https://godoc.org/github.com/golang-china/golangdoc","https://www.google.com"}
	resp, _ := http.Get("http://swabhavtechlabs.com/")

	sb, _ := ioutil.ReadAll(resp.Body)

	defer resp.Body.Close()
	fmt.Println(len(sb))
	// fmt.Println(string(sb))
}

// func get

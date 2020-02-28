package main

import "fmt"

func main() {
	port := map[int]string{80: "HTTP", 23: "telnet", 10: "Arrage test"}
	mapModify(port)
	fmt.Println(port)
}

func mapModify(mp map[int]string) {
	mp[23] = "Modify"
}

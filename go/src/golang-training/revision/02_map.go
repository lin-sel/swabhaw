package main

import "fmt"

func main() {
	// var mp map[int]int

	// mp = make(map[int]int)

	// mp[10] = 10
	// mp[20] = 20
	// mp[30] = 0
	// mp[0] = 10

	// for index := range mp {
	// 	fmt.Println(mp[index])
	// }
	// fmt.Println(mp)

	// m := map[string]float64{
	// 	"pi": 3.1416,
	// 	"e":  2.71828,
	// }
	// fmt.Println(m) // "map[e:2.71828 pi:3.1416]"

	// for key, value := range m { // Order not specified
	// 	fmt.Println(key, value)
	// }

	s := []int{10,20,30,10,40}
	ReverseAndPrint(s)
}

func ReverseAndPrint(s []int) {
	Reverse(int)(s)
	fmt.Println(s)
}

func Reverse (type Element) (s []Element) {
	first := 0
	last := len(s) - 1
	for first < last {
	    s[first], s[last] = s[last], s[first]
	    first++
	    last--
	}
}

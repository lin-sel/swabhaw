package main

import "fmt"

func main() {
	case1()
	case2()
}

func case1() {
	mark := 10
	changevalues(mark)
	fmt.Println(mark)
}

func case2() {
	score := 100
	changescore(&score)
	fmt.Println(score)
}

func changescore(m *int) {
	*m = 0
}

func changevalues(mark int) {
	mark = 0
}

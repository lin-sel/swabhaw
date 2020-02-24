package main

import "fmt"

func main() {
	// case1()
	// case2()
	// case3()
	// case4()
	case5()
}

func case1() {
	func() {
		fmt.Println("Case 1", "Anonymous function called")
	}()
}

func case2() {
	f1 := func(name string) {
		fmt.Println("Hello " + name)
	}

	f1("ABC")
}

func case3() {
	f1 := giveFunc()
	fmt.Println("Case 3", f1(10, 20))
}

func giveFunc() func(int64, int64) int64 {
	return func(n1, n2 int64) int64 {
		return n1 + n2
	}
}

func case4() {
	doProcessing(10, func(r string) {
		fmt.Println(r)
	})
}

func doProcessing(no int, callback func(string)) {
	callback(fmt.Sprintf("Processing server..... %d", no+no+no))
}

func case5() {
	var manyfunc []func() int
	// for i := 1; i <= 5; i++ {
	// 	manyfunc = append(manyfunc, func(i int) func() int {
	// 		return func() int {
	// 			return i * 10
	// 		}
	// 	}(i))
	// }

	for i := 1; i <= 5; i++ {
		j := i * 10
		manyfunc = append(manyfunc, func() int {
			return j
		})
	}

	for i := 0; i < 5; i++ {
		fmt.Println(i, manyfunc[i]())
	}

}

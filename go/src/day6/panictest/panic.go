package panictest

import "fmt"

// Testpanic for test
func Testpanic() {
	defer func() {
		if r := recover(); r != nil {
			fmt.Println("Panic Handle")
		}
		fmt.Println("defer excuted")
	}()
	panicTest()
}

func panicTest() {
	panic("Panic throw")
}

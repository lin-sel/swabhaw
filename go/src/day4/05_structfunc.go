package main

import "fmt"

// Student details
type Student struct {
	rollNO              int
	firdtname, lastname string
}

func main() {

	s1 := Student{10, "Nilesh", "Yadav"}
	fmt.Println(s1)
	modify(s1)
	fmt.Println("After Modify() function call ", s1)
	modifyPointer(&s1)
	fmt.Println("After ModifyPointer() function call ", s1)
}

func modify(s Student) {
	s.rollNO = 100
}

func modifyPointer(s *Student) {
	s.rollNO = 200
}

package main

import "fmt"

// Student details
type Student struct {
	firstname, lastname string
	rollno              int
}

func (stu *Student) modify() {
	stu.rollno = 201
}

func (stu Student) modifyPointer() {
	stu.rollno = 301
}

func main() {
	st := Student{"Nilesh", "Yadav", 100}

	fmt.Println(st)

	st.modifyPointer()
	fmt.Println("Without Refrence", st)

	st.modify()
	fmt.Println("With Reference", st)
}

package main

import "fmt"

// Student details
type Student struct {
	rollNo              int
	firstname, lastname string
}

func main() {
	student := Student{12, "Nilesh", "Yadav"}

	// fmt.Println(student)
	// Make copy of student  type
	st := student
	st.rollNo = 300
	fmt.Println(st, student)
}

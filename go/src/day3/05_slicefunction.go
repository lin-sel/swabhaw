package main

import "fmt"

func main(){
	case2()
}


func case1(){
	marks := []int{12,10,19}
	markstoPointer := marks
	marks[0] = 900
	fmt.Println(marks, markstoPointer)
	marks = append(marks, 189,178,7383)
	marks[0]  = 89
	fmt.Println(marks, markstoPointer)
}

func case2(){
	marks := []int{10,20,30}
	fmt.Println("Before Modification", marks)
	modify(marks)
	fmt.Println("After Modification", marks)
}

func modify(slice []int){
	for i := 0; i < len(slice); i++{
		slice[i] = 0
	}
}
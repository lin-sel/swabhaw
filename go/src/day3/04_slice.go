package main

import "fmt"

func main(){
	// case1()
	case2()
}


func case1(){
	// slice := make([]int, 3, 4)
	slice := []int{12,13,14}
	// slice = append(slice, 10,20,30)
	
	fmt.Println(slice)
	fmt.Printf("value of capacity %v value of length %v  address of slice[0] %v\n", cap(slice), len(slice), &slice[0])


	slicecopy := slice
	pslice := &slice

	slicecopy[0] = 0;
	fmt.Println(slicecopy)

	slice = append(slice, 10,10101,101,10,101,10)
	fmt.Println(slice, slicecopy, pslice)
}


func case2(){
	slice := []int{12,13,14,15}
	fmt.Println(slice)
	pslice := slice
	modify(slice)
	slice = append(slice , 10,190,40)
	fmt.Println(slice)
	fmt.Println(pslice)
}


func modify(slice []int){
	slice[0] = 0
}
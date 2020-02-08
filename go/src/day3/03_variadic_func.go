package main

import "fmt"

func main(){
	sum(10,20, 30, 40, 50, 60, 70)
	sum(10,20)
	max(80,90)
	max()
}

func sum(a,b int, c ...int){
	fmt.Println(a,b)

	for _,val := range c {
		fmt.Println(val)
	}
}


func max(c ...int){
	fmt.Printf("%T\n", c)
	for _,val := range c {
		fmt.Println(val)
	}
}
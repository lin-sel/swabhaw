package main

import "fmt"

type student struct {
	name string
}

func main(){
	displayManyThing(12,"Hello", student{"ABC"})
}


func displayManyThing(element ...interface{}){
	for _, val := range element{
		fmt.Println(val)
		if s,status := val.(student); status {
			fmt.Println(s.name)
		}
	}

}
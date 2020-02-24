package main

import (
	"fmt"
	secondlargest "problem/secondLargest"
)

func main() {
	_, secondlar := secondlargest.SecondLargest([]int{12, 90, 54, 32, 58, 0, 87})
	fmt.Println(secondlar)
}

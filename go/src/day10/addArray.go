package main

import (
	"fmt"
	"strconv"
	"unittest/math"
)

const (
	odd  = 2
	even = 1
	def  = 0
)

// AddArray add Array
func AddArray(array []string) (arr []int64, sum int64) {
	ar, validate := arrayManipulation(array)

	for _, element := range ar {
		if validate(element) {
			sum += element
			arr = append(arr, element)
		}
	}
	return
}

func arrayManipulation(array []string) ([]int64, func(int64) bool) {
	var el []int64
	var flag func(int64) bool = parseFlag("default")
	for _, arr := range array {
		val, err := strconv.ParseInt(arr, 10, 64)
		if err != nil {
			flag = parseFlag(arr)
		}
		el = append(el, val)
	}
	return el, flag
}

func parseFlag(inputflag string) func(int64) bool {
	switch {
	case inputflag == "-e":
		return evenNumber
	case inputflag == "-o":
		return oddNumber
	default:
		return defaultFunc
	}
}

func evenNumber(number int64) bool {
	return math.IsEven(number)
}

func oddNumber(number int64) bool {
	return !math.IsEven(number)
}

func defaultFunc(number int64) bool {
	return true
}

func main() {
	arr := []string{"10", "21", "30", "d-10", ""}
	su, sum := AddArray(arr)
	fmt.Println(su, sum)
}

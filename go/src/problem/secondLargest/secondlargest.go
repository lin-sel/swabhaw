package secondlargest

// SecondLargest number
func SecondLargest(arr []int) (largest int, secondlargest int) {
	largest = -9223372036854775808
	secondlargest = -9223372036854775808

	for _, element := range arr {
		if element > largest {
			secondlargest = largest
			largest = element
		}

		if secondlargest < element && element < largest {
			secondlargest = element
		}
	}
	return
}

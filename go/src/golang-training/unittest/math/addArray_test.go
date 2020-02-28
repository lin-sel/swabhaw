package math

import (
	"reflect"
	"testing"
)

func TestAddArray(t *testing.T) {
	arr := []string{"10", "21", "30", "d-10"}
	expectedarray, expectedsum := []int64{10, 21, 30}, int64(61)
	result, sum := AddArray(arr)
	if reflect.DeepEqual(expectedarray, result) && sum != expectedsum {
		t.Errorf("Expected: \narray = %v\n sum = %v \n actual: \n array = %v \n sum = %v", expectedarray, expectedsum, result, sum)
	}
}

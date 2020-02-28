package math

import "testing"

func TestAdd(t *testing.T) {
	input1, input2 := 10, 20

	expected := 30

	result := Add(input1, input2)

	if result != expected {
		t.Errorf("Expected %v and Actual result %v", expected, result)
	}
}

package math

import (
	"fmt"
	"testing"
)

func TestIsEven(t *testing.T) {
	testlist := []struct {
		number int64
		status bool
	}{
		{12, true},
		{13, false},
		{201, false},
	}

	for _, data := range testlist {
		t.Run("Match", func(t *testing.T) {
			if st := IsEven(data.number); st != data.status {
				t.Errorf(formateError(st, data.status))
			}
		})
	}
}

func formateError(actual, expected bool) string {
	return fmt.Sprintf("Expected status %v and actual status %v", expected, actual)
}

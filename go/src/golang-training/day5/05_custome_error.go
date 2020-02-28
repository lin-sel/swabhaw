package main

import "fmt"

type notEvenNo struct {
	no int
}

func (e *notEvenNo) Error() string {
	return fmt.Sprintf("number %d is not even number", e.no)
}

func main() {
	no, err := cubeEvenNo(3)
	fmt.Println(no, err.Error())
}

func cubeEvenNo(no int) (int, error) {
	if no%2 != 0 {
		return 0, &notEvenNo{no}
	}

	return no * no * no, nil
}

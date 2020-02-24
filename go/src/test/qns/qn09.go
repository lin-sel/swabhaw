package main

import "fmt"

type Refrigerator struct {
	Brand string
}

type Food string

func (r Refrigerator) Open() {
	fmt.Println("Opening refrigerator")
}
func (r Refrigerator) Close() {
	fmt.Println("Closing refrigerator")
}
func (r Refrigerator) FindFood(food string) (Food, error) {
	// Food storage not implemented yet; always return error!
	// Note: don't change FindFood as part of this exercise!
	return Food(""), fmt.Errorf("%s not found", food)
}

// YOUR CODE HERE:
// Modify the code in the Eat function so that fridge.Close will
// always be called at the end, even if fridge.FindFood returns
// an error. Once you've figured the solution out, your changes
// will actually be quite small! Note: it wouldn't be appropriate
// to use either "panic" or "recover" in this exercise; we won't
// be using either one.
func Eat(fridge Refrigerator) error {
	defer fridge.Close()
	fridge.Open()
	food, err := fridge.FindFood("bananas")
	if err != nil {
		return err
	}
	fmt.Println("Eating", food)
	return nil
}

// CURRENT OUTPUT:
// Opening refrigerator
// bananas not found
// DESIRED OUTPUT:
// Opening refrigerator
// Closing refrigerator
// bananas not found
func main() {
	var fridge Refrigerator
	err := Eat(fridge)
	if err != nil {
		fmt.Println(err)
	}
}

package main

import (
	"accountapp/account"
	"fmt"
)

func main() {
	acc := account.CreateAccount("ABC", 1200, 12346789)
	fmt.Println("Before Deposite")
	printDetail(acc)
	acc.Deposite(200)
	fmt.Println("After Deposite")
	printDetail(acc)
	fmt.Println("Withdraw")
	acc.Withdraw(100)
	printDetail(acc)

}

func printDetail(acc *account.Account) {
	fmt.Printf("Name:%s \nAccount Number: %d \nBalance: %.2f \n", acc.Name(), acc.AccountNo(), acc.Balance())
}

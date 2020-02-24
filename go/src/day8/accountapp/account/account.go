package account

// Account Model
type Account struct {
	name      string
	balance   float32
	accountno int
}

// CreateAccount Object
func CreateAccount(name string, balance float32, accountno int) *Account {
	if balance < 0 {
		panic("Balance should not be Negative")
	}
	return &Account{name, balance, accountno}
}

// Balance Return Balance
func (acc *Account) Balance() float32 {
	return acc.balance
}

// AccountNo Return AccountNumber
func (acc *Account) AccountNo() int {
	return acc.accountno
}

// Name Return Name
func (acc *Account) Name() string {
	return acc.name
}

// Deposite deposite amount
func (acc *Account) Deposite(amount float32) {
	if amount < 0 {
		panic("Amount should not be Negative")
	}
	acc.balance += amount
}

// Withdraw Amount from Acocunt
func (acc *Account) Withdraw(amount float32) {
	if acc.balance-amount > 500 {
		acc.balance -= amount
		return
	}
	panic("You have insufficiant Balance to withdraw")
}

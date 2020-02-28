package main

import (
	"app/BookMarkApp/conn"
	"fmt"
	"time"

	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

// Order Details
type Order struct {
	gorm.Model
	Date       time.Time
	Amount     float64
	CustomerID uint
}

// Customer Details
type Customer struct {
	gorm.Model
	Name     string
	Location string
	Orders   []Order
}

func main() {
	con, _ := conn.CreateConn()

	con.AutoMigrate(&Customer{}, &Order{})
	// con.Model(&Order{}).AddForeignKey("customer_id", "customers(id)", "CASCADE", "CASCADE")

	con.Save(&Customer{
		Model:    gorm.Model{CreatedAt: time.Now().Add(12), UpdatedAt: time.Now()},
		Name:     "Nilesh",
		Location: "Mumbai",
		Orders: []Order{
			Order{
				Date:   time.Now(),
				Amount: 1200,
			},
			Order{
				Date:   time.Now(),
				Amount: 1400,
			},
		}},
	)

	var customer []Customer

	// con.Find(&customer, 1)

	// con.Where("id = ? or location = ?", 10, "mumbai").Find(&customer)

	con.Preload("Orders").Find(&customer)
	printCustomerDetails(customer...)
	// fmt.Println(customer)
}

func printCustomerDetails(customer ...Customer) {
	for _, cust := range customer {
		fmt.Printf("Customer :\n ID: %d\nName: %s\n", cust.ID, cust.Name)
		for _, order := range cust.Orders {
			fmt.Printf("Order: \n ID = %d\n Amount: %.2f\n Customer ID: %d\n", order.ID, order.Amount, order.CustomerID)
		}
	}
}

package main

import (
	"app/BookMarkApp/conn"
	"log"

	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

// EMPLOYEE Detail
type EMPLOYEE struct {
	gorm.Model
	Name   string
	Salary int
}

func main() {
	conn, err := conn.CreateConn()
	if err != nil {
		log.Fatal(err)
	}

	defer conn.Close()

	customer := []EMPLOYEE{
		EMPLOYEE{Name: "ABC", Salary: 1600},
		EMPLOYEE{Name: "STU", Salary: 1700},
	}

	conn.Debug().DropTableIfExists(&customer)
	conn.Debug().CreateTable(&customer)

	for _, data := range customer {
		conn.Create(&data)
	}

	conn.Debug().Where("name = ?", "ABC").Delete(&EMPLOYEE{})

}

package main

import (
	"app/gormapp/model"
	"log"

	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

func main() {

	db, err := createConn()
	if err != nil {
		log.Fatal(err)
	}

	customer := model.Customer{}
	db.DropTableIfExists(&customer)

	db.CreateTable(&customer)

	c := []model.Customer{
		model.Customer{1, "ABC", "XYZ", 1200},
		model.Customer{2, "PQR", "ABC", 1200},
		model.Customer{3, "STU", "XYZ", 1200},
	}

	for _, c1 := range c {
		db.Debug().Create(&c1)
	}

	db.Close()

	// var customers []model.Customer

}

func createConn() (*gorm.DB, error) {
	return gorm.Open("mysql", "swabhav:swabhav@/test")
}

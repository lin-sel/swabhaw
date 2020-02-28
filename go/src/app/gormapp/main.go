package main

import (
	"fmt"
	"gormapp/conn"
	"gormapp/model"
	"log"

	_ "github.com/jinzhu/gorm/dialects/mysql"
	_ "github.com/jinzhu/gorm/mysql"
)

func main() {

	db, err := conn.CreateConnection()

	if err != nil {
		log.Fatal(err)
	}

	// db, err := con.Open("mysql", "swabhav:swabhav@/test")
	defer con.Close()
	// if err != nil {
	// 	log.Fatal(err)
	// 	return
	// }

	c := model.Customer{}

	db.Debug().DropTableIfExists(&c)

	db.Debug().CreateTable(&c)

	c1 := model.Customer{ID: 1, Firstname: "ABC", LastName: "XYZ", Balance: 1000}

	db.Debug().Create(&c1)

	defer db.Close()

	fmt.Println("End of the Main")
}


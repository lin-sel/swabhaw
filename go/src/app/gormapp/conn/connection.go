package conn

import (
	"github.com/jinzhu/gorm"
)

// CreateConn Return connection
func CreateConn() (*gorm.DB, error) {
	return gorm.Open("mysql", "swabhav:swabhav@/test")

	// defer db.Close()
	// if err != nil {
	// 	log.Fatal(err)
	// 	return
	// }

	// c := model.Customer{}

	// db.Debug().DropTableIfExists(&c)

	// db.Debug().CreateTable(&c)

	// c1 := model.Customer{ID: 1, Firstname: "ABC", LastName: "XYZ", Balance: 1000}

	// db.Debug().Create(&c1)

	// defer db.Close()

	// fmt.Println("End of the Main")
}

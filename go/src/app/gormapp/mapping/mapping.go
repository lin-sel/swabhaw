package main

import (
	"app/BookMarkApp/conn"
	"fmt"
	"log"

	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

// PASSPORT Details
type PASSPORT struct {
	gorm.Model
	Address string
	USERID  uint
}

// USER Details
type USER struct {
	gorm.Model
	Name     string
	Passport *PASSPORT
}

func main() {
	conn, err := conn.CreateConn()
	if err != nil {
		log.Fatal(err)
	}

	conn.Debug().AutoMigrate(&PASSPORT{}, &USER{})

	conn.Model(&PASSPORT{}).AddForeignKey("user_id", "users(id)", "CASCADE", "CASCADE")

	conn.Save(&USER{
		Name: "Nilesh",
		Passport: &PASSPORT{
			Address: "G/8 Goregaon",
		},
	})

	// conn.Debug().Delete(&USER{}, 1)

	// conn.Debug().Model(&USER{}).Association("users_id").Find(&PASSPORT{})
	var user USER
	// conn.Preload("gorm: auto_preload", true)
	conn.Debug().Preload("Passport").First(&user)
	fmt.Println(user.Name, user.Passport.Address)

}

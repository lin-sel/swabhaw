package main

import (
	"fmt"

	"github.com/jinzhu/gorm"
	uuid "github.com/satori/go.uuid"
	service "github.com/swabhav/gomodapp/service"

	_ "github.com/jinzhu/gorm/dialects/mysql"
)

type userUUID struct {
	ID string `gorm:"type:varchar(36)"`
}

func main() {

	con := createconn()

	// fmt.Println(uuid.Must(uuid.NewV4()))

	con.AutoMigrate(&userUUID{})

	con.Create(
		&userUUID{
			ID: uuid.Must(uuid.NewV4()).String(),
		},
	)

	var users []userUUID

	con.Find(&users)

	var user userUUID

	con.Where("id = ?", users[0].ID).Find(&user)

	fmt.Println(user.ID)

	service.NewDataService()

}

func createconn() *gorm.DB {
	conn, _ := gorm.Open("mysql", "swabhav:swabhav@tcp(127.0.0.1)/Swabhav?charset=utf8&parseTime=true")
	return conn
}

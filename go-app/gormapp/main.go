package main

import (
	"fmt"

	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

type st struct {
	Name string `gorm:"type:varchar(20)"`
}

func main() {
	conn, err := gorm.Open("mysql", "swabhav:swabhav@tcp(127.0.0.1)/Swabhav?charset=utf8&parseTime=true")
	defer func() {
		if err := recover(); err != nil {
			fmt.Println(err, "Handle")
		}
	}()
	defer conn.Close()
	if err != nil {
		fmt.Println(err)
	}

	conn.AutoMigrate(&st{})

	conn.Create(&st{
		Name: "Nilesh",
	})

	st := st{}
	er := conn.First(&st).Error
	if er != nil {
		fmt.Println(er)
	}
	fmt.Println(st)
}

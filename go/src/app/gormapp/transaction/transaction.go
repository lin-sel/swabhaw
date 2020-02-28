package main

import (
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

type cust struct {
	Name string `gorm:"type:varchar(30); unique_index"`
}

func main() {
	co := createConn()
	co.AutoMigrate(&cust{})

	defer co.Close()
	cust := cust{
		Name: "Nilesh",
	}

	txt := co.Begin()
	defer txt.Commit()
	if err := txt.Create(&cust).Error; err != nil {
		txt.Rollback()
	}

	if err := txt.Save(&cust).Error; err != nil {
		txt.Rollback()
	}

	txt.Commit()

}

func createConn() *gorm.DB {
	conn, _ := gorm.Open("mysql", "swabhav:swabhav@tcp(127.0.0.1:3306)/Swabhav?charset=utf8&parseTime=true")
	return conn
}

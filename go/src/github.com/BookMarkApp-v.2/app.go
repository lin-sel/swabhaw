package main

import (
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
	"github.com/lin-sel/Bookmarkapp/model"
	"github.com/lin-sel/Bookmarkapp/service"

	"github.com/lin-sel/Bookmarkapp/view"
	log "github.com/sirupsen/logrus"
)

func main() {
	con := createConn()
	ufw := service.NewUnitOfWork(con, true)
	con.AutoMigrate(&model.User{}, &model.Bookmark{})
	con.Model(&model.Bookmark{}).AddForeignKey("user_id", "users(id)", "CASCADE", "CASCADE")
	if ufw != nil {
		log.Info("Unit of Work Object Created")
	}
	service := service.NewRepository()
	if service != nil {
		log.Info("Repository Object Created")
	}
	view.UserAuthMenu(ufw, service)
}

func createConn() *gorm.DB {
	conn, err := gorm.Open("mysql", "swabhav:swabhav@tcp(127.0.0.1)/Swabhav?charset=utf8&parseTime=true")
	if err != nil {
		log.Fatal(err)
	}
	log.Info("Connection Created")
	return conn
}

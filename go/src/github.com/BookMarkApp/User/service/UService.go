package service

import (
	"github.com/BookMarkApp/User/model"
	"github.com/jinzhu/gorm"
)

// UService Structure
type UService struct {
	DB *gorm.DB
}

//NewUService Return Object Of Service
func NewUService(conn *gorm.DB) *UService {
	conn.AutoMigrate(&model.User{})
	return &UService{DB: conn}
}

// Register user
func (user *UService) Register(registeruser *model.User) {
	user.DB.Save(&registeruser)
}

// Login login user with password and username
func (user *UService) Login(loginuser *model.User) *model.User {
	var validuser model.User
	user.DB.Debug().Where("username = ? and password = ?", loginuser.Username, loginuser.Password).Find(&validuser)
	if validuser != (model.User{}) {
		return &validuser
	}
	return nil
}

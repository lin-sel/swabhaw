package model

import (
	"github.com/BookMarkApp/BookMark/model"
	"github.com/jinzhu/gorm"
)

// User Structure
type User struct {
	gorm.Model
	Name     string
	Username string `gorm:"type:varchar(20);unique_index;not_null"`
	Password string `gorm:"type:varchar(30);not_null"`
	Bookmark *[]model.Bookmark
}

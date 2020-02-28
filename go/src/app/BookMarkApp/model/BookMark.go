package model

import (
	"fmt"

	"github.com/jinzhu/gorm"
)

// BookMark Detail
type BookMark struct {
	ID    uint64
	URL   string
	Name  string
	Categ uint64
}

//GetBookmarkString return string
func (bm *BookMark) GetBookmarkString() string {
	return fmt.Sprintf("<a href=\"%s\"> %s </a><br/>", bm.URL, bm.Name)
}

// GetBookMarkByID Return BMCategory By ID.
func GetBookMarkByID(conn *gorm.DB, id uint64) *BookMark {
	var bookmark BookMark
	conn.Where("id = ?", id).Find(&bookmark)
	return &bookmark
}

// AddNewBookMark Add new Category
func (bm *BookMark) AddNewBookMark(conn *gorm.DB) *gorm.DB {
	return conn.Create(&bm)
}

// DeleteBookMarkByID delete from Table.
func DeleteBookMarkByID(conn *gorm.DB, id uint64) *gorm.DB {
	return conn.Where("ID = ?", id).Delete(&BookMark{})
}

// UpdateBookMarkByID Update Category.
func (bm *BookMark) UpdateBookMarkByID(conn *gorm.DB, id uint64) *gorm.DB {
	return conn.Table("bookmark").Where("id = ?", id).Find(&BookMark{}).Updates(&bm)
}

// UpdateBookMark Update BookMark
func UpdateBookMark(conn *gorm.DB, bookmark *BookMark) {
	bookmark.UpdateBookMarkByID(conn, bookmark.ID)
}

// GetAllBookMark Return All Category.
func GetAllBookMark(conn *gorm.DB) *[]BookMark {
	var bookmark []BookMark
	conn.Debug().Find(&bookmark)
	fmt.Println(bookmark)
	return &bookmark
}

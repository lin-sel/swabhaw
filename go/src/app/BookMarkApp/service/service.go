package service

import (
	"app/BookMarkApp/model"
	"bytes"
	"io"
	"io/ioutil"
	"math/rand"
	"os"
	"time"

	"github.com/jinzhu/gorm"
)

// Init create Table
func Init(conn *gorm.DB) {
	conn.DropTableIfExists(&model.BookMark{}, &model.BMCATEGORY{})
	conn.CreateTable(&model.BMCATEGORY{}, &model.BookMark{})
}

// GetBMCATEGORYByID Return BMCATEGORY By ID.
func GetBMCATEGORYByID(conn *gorm.DB, id uint64) *model.BMCATEGORY {
	return model.GetBMCATEGORYByID(conn, id)
}

// AddNewBMCATEGORY Add new Category
func AddNewBMCATEGORY(conn *gorm.DB, category *model.BMCATEGORY) {
	category.AddNewBMCATEGORY(conn)
}

// DeleteBMCATEGORYByID delete from Table.
func DeleteBMCATEGORYByID(conn *gorm.DB, id uint64) {
	model.DeleteBMCATEGORYByID(conn, id)
}

// UpdateBMCATEGORYByID Update Category.
func UpdateBMCATEGORYByID(conn *gorm.DB, category *model.BMCATEGORY) {
	category.UpdateBMCATEGORY(conn)
}

// GetAllBMCATEGORY Return All Category.
func GetAllBMCATEGORY(conn *gorm.DB) *[]model.BMCATEGORY {
	return model.GetAllBMCATEGORY(conn)
}

// GetBookMarkByID Return BMCategory By ID.
func GetBookMarkByID(conn *gorm.DB, id uint64) *model.BookMark {
	return model.GetBookMarkByID(conn, id)
}

// DeleteBookMarkByID delete from Table.
func DeleteBookMarkByID(conn *gorm.DB, id uint64) *gorm.DB {
	return model.DeleteBookMarkByID(conn, id)
}

// UpdateBookMarkByID Update Category.
func UpdateBookMarkByID(conn *gorm.DB, id uint64, bm *model.BookMark) *gorm.DB {
	return bm.UpdateBookMarkByID(conn, id)
}

// UpdateBookMark Update BookMark
func UpdateBookMark(conn *gorm.DB, bookmark *model.BookMark) {
	bookmark.UpdateBookMarkByID(conn, bookmark.ID)
}

// GetAllBookMark Return All Category.
func GetAllBookMark(conn *gorm.DB) *[]model.BookMark {
	return model.GetAllBookMark(conn)
}

func createRandomID() uint64 {
	rand.Seed(time.Now().UnixNano())
	return rand.Uint64()

}

// ExportToFile Export to html file
func ExportToFile(contents *[]model.BookMark) {
	var output string
	for _, content := range *contents {
		output += content.GetBookmarkString()
	}
	io.Copy(CreateFile(), ioutil.NopCloser(bytes.NewBufferString(output)))
}

// CreateFile return file
func CreateFile() *os.File {
	file, _ := os.Create("link.html")
	return file
}

// AddBookMark add to database
func AddBookMark(conn *gorm.DB, bookmark *model.BookMark, category string) {
	cate := model.GetBMCATEGORYByName(conn, category)
	if *(cate) == (model.BMCATEGORY{}) {
		cate = &model.BMCATEGORY{ID: createRandomID(), Name: category}
		AddNewBMCATEGORY(conn, cate)
	}
	bookmark.Categ = cate.ID
	bookmark.AddNewBookMark(conn)
}

// func (fm *Formate)

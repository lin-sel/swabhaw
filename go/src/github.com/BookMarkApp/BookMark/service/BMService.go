package service

import (
	"github.com/BookMarkApp/BookMark/model"
	umodel "github.com/BookMarkApp/User/model"
	"github.com/jinzhu/gorm"
)

//BookmarkService Structure
type BookmarkService struct {
	DB *gorm.DB
}

//NewBookmarkService return new Bookmark Object
func NewBookmarkService(conn *gorm.DB) *BookmarkService {
	conn.AutoMigrate(&model.Bookmark{})
	conn.Model(&model.Bookmark{}).AddForeignKey("user_id", "users(id)", "CASCADE", "CASCADE")
	return &BookmarkService{
		DB: conn,
	}
}

// AddNewBM add New and Unique BookMark
func (bookmark *BookmarkService) AddNewBM(bm *model.Bookmark) {
	var result model.Bookmark
	bookmark.DB.Debug().Where("url = ? and user_id = ?", bm.URL, bm.USERID).First(&result)
	if result != (model.Bookmark{}) {
		return
	}
	bookmark.DB.Save(bm)
}

// UpdateBM Update Bookmark
func (bookmark *BookmarkService) UpdateBM(bm *model.Bookmark) {
	var result model.Bookmark
	bookmark.DB.Find(&result, bm.ID)
	if result != (model.Bookmark{}) {
		result.Name = bm.Name
		result.Tag = bm.Tag
		result.URL = bm.URL
		bookmark.DB.Save(&result)
	}
}

// DeleteBM Delete Bookmark
func (bookmark *BookmarkService) DeleteBM(id int, user *umodel.User) {
	bookmark.DB.Where("id = ? and user_id = ?", id, user.ID).Delete(&model.Bookmark{})
}

// GetBookmarkByID get Bookmark by id
func (bookmark *BookmarkService) GetBookmarkByID(id int, user *umodel.User) *model.Bookmark {
	var result model.Bookmark
	bookmark.DB.Debug().Where("id = ? and user_id = ?", id, user.ID).Find(&result)
	return &result
}

//GetAllBookmark Return all Bookmark
func (bookmark *BookmarkService) GetAllBookmark(user *umodel.User) *[]model.Bookmark {
	result := []model.Bookmark{}
	bookmark.DB.Debug().Where("user_id = ?", user.ID).Find(&result)
	return &result
}

//GetAllBookmarkByUSERID Return all Bookmark
func (bookmark *BookmarkService) GetAllBookmarkByUSERID(id uint) *[]model.Bookmark {
	var results []model.Bookmark
	bookmark.DB.Debug().Where("user_id = ?", id).Find(&results)
	return &results
}

package model

import (
	"github.com/jinzhu/gorm"
)

// BMCATEGORY Details
type BMCATEGORY struct {
	ID   uint64
	Name string `gorm:"unique"`
}

var bmcategory BMCATEGORY

// GetBMCATEGORYByID Return BMCATEGORY By ID.
func GetBMCATEGORYByID(conn *gorm.DB, id uint64) *BMCATEGORY {
	conn.Debug().Where("id = ?", id).Find(&bmcategory)
	return &bmcategory
}

// GetBMCATEGORYByName Return BMCATEGORY.
func GetBMCATEGORYByName(conn *gorm.DB, name string) *BMCATEGORY {
	conn.Debug().Where("name = ?", name).Find(&bmcategory)
	return &bmcategory
}

// AddNewBMCATEGORY Add new Category
func (bmcategory *BMCATEGORY) AddNewBMCATEGORY(conn *gorm.DB) {
	conn.Create(&bmcategory)
}

// DeleteBMCATEGORYByID delete from Table.
func DeleteBMCATEGORYByID(conn *gorm.DB, id uint64) {
	conn.Where("id = ?", id).Delete(&BMCATEGORY{})
}

// UpdateBMCATEGORY Update Category.
func (bmcategory *BMCATEGORY) UpdateBMCATEGORY(conn *gorm.DB) {
	conn.Debug().Where("id = ?", bmcategory.ID).Find(&BMCATEGORY{}).Update(&bmcategory)
}

// GetAllBMCATEGORY Return All Category.
func GetAllBMCATEGORY(conn *gorm.DB) *[]BMCATEGORY {
	var bmcategory []BMCATEGORY
	conn.Find(&bmcategory)
	return &bmcategory
}

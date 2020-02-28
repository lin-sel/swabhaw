package model

import (
	"fmt"

	"github.com/jinzhu/gorm"
)

// Bookmark Structure
type Bookmark struct {
	gorm.Model
	Name   string `gorm:"type:varchar(150)"`
	URL    string `gorm:"type:varchar(300);unique_index"`
	USERID uint   `gorm:"not_null"`
	Tag    string
}

//Formate formate the Bookmark
func (bm *Bookmark) Formate() string {
	return fmt.Sprintf("<a href=\"%s\"> %s</a><br/>\n", bm.URL, bm.Name)
}

package model

import (
	"fmt"

	uuid "github.com/satori/go.uuid"
)

//Bookmark table details
type Bookmark struct {
	ModelBase
	Name   string    `gorm:"type:varchar(80)"`
	URL    string    `gorm:"type:varchar(150);unique_index"`
	USERID uuid.UUID `gorm:"type:varchar(36);not_null"`
}

//Formate formate the Bookmark
func (bm *Bookmark) Formate() string {
	return fmt.Sprintf("<a href=\"%s\"> %s</a><br/>\n", bm.URL, bm.Name)
}

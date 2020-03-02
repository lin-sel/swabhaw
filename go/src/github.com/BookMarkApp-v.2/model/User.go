package model

// User Structure
type User struct {
	ModelBase
	Username string `gorm:"type:varchar(30);unique_index"`
	Password string `gorm:"type:varchar(30);"`
	Bookmark *[]Bookmark
}

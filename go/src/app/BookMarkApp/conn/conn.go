package conn

import "github.com/jinzhu/gorm"

// CreateConn Return Database Object
func CreateConn() (*gorm.DB, error) {
	return gorm.Open("mysql", "swabhav:swabhav@/test?parseTime=true")
}

package model

import (
	"time"

	uuid "github.com/satori/go.uuid"
)

// ModelBase Structure
type ModelBase struct {
	ID        uuid.UUID  `gorm:"type:varchar(36); primary_key;"`
	CreatedAt time.Time  `gorm:"column:createdOn"`
	UpdateAt  time.Time  `gorm:"column:updateOn"`
	DeletedAt *time.Time `sql:"index" gorm:"column:deletedOn"`
}

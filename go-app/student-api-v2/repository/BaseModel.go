package repository

import (
	"time"

	uuid "github.com/satori/go.uuid"
)

// Basemodel  Struct
type Basemodel struct {
	ID        uuid.UUID  `gorm:"type:varchar(36);primary_key" json:"id,omitempty"`
	CreatedAt time.Time  `gorm:"column:createdOn" json:"-"`
	UpdatedAt time.Time  `gorm:"column:updatedOn" json:"-"`
	DeletedAt *time.Time `sql:"index" gorm:"column:deletedOn" json:"-"`
}

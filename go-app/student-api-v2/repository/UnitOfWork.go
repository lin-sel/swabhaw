package repository

import "github.com/jinzhu/gorm"

// UnitOfWork structure
type UnitOfWork struct {
	DB       *gorm.DB
	Readonly bool
	Commited bool
}

// NewUnitOfWork Return New Object
func NewUnitOfWork(db *gorm.DB, readonly bool) *UnitOfWork {
	if readonly {
		return &UnitOfWork{DB: db.New(), Commited: false, Readonly: true}
	}
	return &UnitOfWork{DB: db.New().Begin(), Commited: false, Readonly: false}
}

// Complete For Rollback
func (ufw *UnitOfWork) Complete() {
	if !ufw.Readonly && !ufw.Commited {
		ufw.DB.Rollback()
	}
}

// Commit Complete Transaction
func (ufw *UnitOfWork) Commit() {
	if !ufw.Readonly && !ufw.Commited {
		ufw.DB.Commit()
	}
	ufw.Commited = true
}

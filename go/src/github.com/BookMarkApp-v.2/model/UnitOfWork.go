package model

import "github.com/jinzhu/gorm"

// UnitOfWork Structure
type UnitOfWork struct {
	DB        *gorm.DB
	Readonly  bool
	Committed bool
}

// Complete Will Rollback Transaction
func (ufw *UnitOfWork) Complete() {
	if !ufw.Committed && !ufw.Readonly {
		ufw.DB.Rollback()
	}
	ufw.Committed = true
}

// Commit Complete Transaction
func (ufw *UnitOfWork) Commit() {
	if !ufw.Readonly {
		ufw.DB.Commit()
	}
}

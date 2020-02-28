package model

import "github.com/jinzhu/gorm"

// DEPARTMENT Detail
type DEPARTMENT struct {
	DEPTNO int64
	DNAME  string
	LOC    string
}

// Customer Detail
type Customer struct {
	gorm.Model
	ID        int
	Firstname string
	LastName  string
	Balance   float64
}

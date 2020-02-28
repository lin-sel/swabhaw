package service

import (
	"fmt"

	"github.com/swabhav/gomodapp/model"
)

// DataService Structure
type DataService struct {
}

// NewDataService Return DataService Object
func NewDataService() *DataService {
	return &DataService{}
}

// ProcessData Process
func (service *DataService) ProcessData(student *model.Student) {
	fmt.Printf("ID: %d\n Name: %s", student.ID, student.Name)
}

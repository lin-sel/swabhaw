package service

import (
	"os"

	"github.com/lin-sel/Bookmarkapp/model"
)

// Formater formate File output
type Formater interface {
	Formate()
}

// NewFileService Return New FileService Object
type NewFileService struct {
}

// CreateNewFileService create object
func CreateNewFileService() *NewFileService {
	return &NewFileService{}
}

// ExportToFile write to file
func (fileser *NewFileService) ExportToFile(file string, content *[]model.Bookmark) error {
	f, err := os.Create(file)
	if err != nil {
		return err
	}
	for _, cont := range *content {
		_, err := f.WriteString(cont.Formate())
		if err != nil {
			return err
		}
	}
	return nil
}

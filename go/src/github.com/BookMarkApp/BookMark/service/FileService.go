package service

import (
	"os"
	"strings"

	"github.com/BookMarkApp/BookMark/model"
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

// CreateFile Create New File
func (fileser *NewFileService) CreateFile(filename string, filextention string) (*os.File, error) {
	var file *os.File
	var err error
	defer func() {
		if er := recover(); er != nil {
			file = nil
			err, _ = er.(error)
			return
		}
	}()
	file, err = os.Create(filename + "." + strings.ToLower(filextention))
	return file, err
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

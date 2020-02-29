package main

import (
	"github.com/swabhav/gomodapp/model"
	"github.com/swabhav/gomodapp/service"
)

func main() {
	ser := service.NewDataService()
	ser.ProcessData(&model.Student{ID: 1, Name: "XYZ"})
}

package main

import (
	"app/BookMarkApp/conn"
	"app/BookMarkApp/model"
	"app/BookMarkApp/service"
	"bufio"
	"fmt"
	"log"
	"os"
	"strings"

	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

var bookmark *[]model.BookMark

func main() {
	db, err := conn.CreateConn()
	defer db.Close()
	status := true
	if err != nil {
		log.Fatal(err)
	}
	service.Init(db)
	for status {
		fmt.Println("1. Add NewBookmark")
		fmt.Println("2. Html file")
		fmt.Println("3. Delete Bookmark")
		fmt.Println("4. All Bookmark")
		fmt.Println("5. Search Bookmark")
		fmt.Println("6. Exit")
		var input int
		fmt.Scanln(&input)
		switch input {
		case 1:
			addBookMark(db)
		case 3:
			fmt.Println("Enter BookMark Id")
			var id int
			fmt.Println(&id)
			service.DeleteBookMarkByID(db, uint64(id))
		case 4, 2:
			getAllBookmark(db)
		case 6:
			os.Exit(0)
		default:
			fmt.Println("Invalid Input")
			status = false
		}
	}
}

func addBookMark(db *gorm.DB) {
	var bookmark model.BookMark
	fmt.Println("Enter Url")
	bookmark.URL = getInput()
	fmt.Println("Enter label of url")
	bookmark.Name = getInput()
	var category string
	fmt.Println("Enter Category")
	category = getInput()
	service.AddBookMark(db, &bookmark, category)
}

func getAllBookmark(db *gorm.DB) {
	bookmark = service.GetAllBookMark(db)
	service.ExportToFile(bookmark)
	printDetail(bookmark)
}

func printDetail(contents *[]model.BookMark) {
	fmt.Println("-----------------------------------------")
	for _, content := range *contents {
		fmt.Printf("ID: %d \nLabel: %s\nUrl: %s\n", content.ID, content.Name, content.URL)
	}
	fmt.Println("-----------------------------------------")
}

func getInput() string {
	reader := bufio.NewReader(os.Stdin)
	input, err := reader.ReadString('\n')
	if err != nil {
		return ""
	}

	input = strings.Replace(input, "\n", "", -1)
	return input
}

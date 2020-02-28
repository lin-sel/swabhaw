package main

import (
	"fmt"
	"os"

	bmodel "github.com/BookMarkApp/BookMark/model"
	"github.com/BookMarkApp/BookMark/service"
	"github.com/BookMarkApp/User/model"
)

var (
	bookmarks   *bmodel.Bookmark
	fileservice *service.NewFileService
)

func showbookMenu(user *model.User, bservice *service.BookmarkService) {
	fileservice = service.CreateNewFileService()
	for true {
		fmt.Println("1. Add New Bookmark\n2. Update Bookmark\n3. Delete Bookmark \n4. Get All Bookmark \n5. Get Bookmark By ID \n6. Export To File\n7. Exit")
		var input int
		fmt.Println("Enter Choice")
		fmt.Scanln(&input)

		switch input {
		case 1:
			addNewBookmark(user.ID, bservice)
		case 2:
			updateBookmark(user.ID, bservice)
		case 3:
			deleteBookmark(user.ID, bservice)
		case 4:
			allBookmark(user.ID, bservice)
		case 5:
			getByID(user.ID, bservice)
		case 7:
			os.Exit(0)
		case 6:
			exportToFile(user.ID, bservice)
		default:
			fmt.Println("Invalid Input")
		}
	}
}

func addNewBookmark(userid uint, service *service.BookmarkService) {
	var bookmark bmodel.Bookmark
	createBookmarkstruct(&bookmark)
	bookmark.USERID = userid
	service.AddNewBM(&bookmark)
}

func createBookmarkstruct(bookmark *bmodel.Bookmark) {
	var value string
	fmt.Println("Enter Url")
	value = getInput()
	bookmark.URL = getValue(value, bookmark.URL)
	fmt.Println("Enter Label for url")
	value = getInput()
	bookmark.Name = getValue(value, bookmark.Name)
	fmt.Println("Enter Tag")
	value = getInput()
	bookmark.Tag = getValue(value, bookmark.Tag)
	return
}

func getValue(val, param string) string {
	if val == "" {
		return param
	}
	return val
}

func updateBookmark(userid uint, service *service.BookmarkService) {
	fmt.Println("Enter Bookmark ID")
	var input int
	fmt.Scanln(&input)
	bookmark := service.GetBookmarkByID(input, user)
	if *bookmark == *(&bmodel.Bookmark{}) {
		fmt.Println("No Data Found")
		return
	}
	fmt.Println("Note: if you want to upgrade then write updated value other Press Enter")
	createBookmarkstruct(bookmark)
	fmt.Println(bookmark.Name, bookmark.Tag, bookmark.URL)
	service.UpdateBM(bookmark)
}

func deleteBookmark(userid uint, service *service.BookmarkService) {
	var input int
	fmt.Println("Enter Id To Delete")
	fmt.Scanln(&input)
	service.DeleteBM(input, user)
}

func allBookmark(userid uint, service *service.BookmarkService) {
	output := service.GetAllBookmarkByUSERID(userid)
	printDetails(output)
}

func getByID(userid uint, service *service.BookmarkService) {
	fmt.Println("Enter Bookmark ID")
	var input int
	fmt.Scanln(&input)
	bookmark := []bmodel.Bookmark{}
	bm := service.GetBookmarkByID(input, user)
	bookmark = append(bookmark, *bm)
	printDetails(&bookmark)
}

func exportToFile(userid uint, service *service.BookmarkService) {
	fmt.Println("Enter File Name")
	fileservice.ExportToFile(getInput(), service.GetAllBookmarkByUSERID(userid))
}

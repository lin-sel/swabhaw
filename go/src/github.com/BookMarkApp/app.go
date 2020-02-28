package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strings"

	bmmodel "github.com/BookMarkApp/BookMark/model"
	"github.com/BookMarkApp/BookMark/service"
	usermodel "github.com/BookMarkApp/User/model"
	userservice "github.com/BookMarkApp/User/service"
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

var (
	user     *usermodel.User
	conn     *gorm.DB
	userauth *userservice.UService
	status   bool = true
)

func main() {
	initApp()
}

func userAuth() {
	for status {
		fmt.Println("1. Login")
		fmt.Println("2. Register")
		var input int
		fmt.Scanln(&input)
		switch input {
		case 1:
			login(userauth)
			status = false
		case 2:
			register(userauth)
		default:
			fmt.Println("Invalid Input")
		}
	}
}

func initApp() {
	conn = createConn()
	userauth = userservice.NewUService(conn)
	userAuth()
}

func createConn() *gorm.DB {
	conn, err := gorm.Open("mysql", "swabhav:swabhav@tcp(127.0.0.1:3306)/Swabhav?charset=utf8&parseTime=true")
	if err != nil {
		log.Fatal(err.Error())
	}
	return conn
}

func login(auth *userservice.UService) {
	var loginuser usermodel.User
	fmt.Println("Enter username")
	loginuser.Username = getInput()
	fmt.Println("Enter Password")
	loginuser.Password = getInput()
	user = auth.Login(&loginuser)
	if user == nil {
		fmt.Println("Inavlid Creadential")
		return
	}
	showbookMenu(user, service.NewBookmarkService(conn))
}

func register(auth *userservice.UService) {
	user := usermodel.User{}
	fmt.Println("Enter Name For Account")
	user.Name = getInput()
	fmt.Println("Enter UserName For Account")
	user.Username = getInput()
	fmt.Println("Enter Password For Account")
	user.Password = getInput()
	auth.Register(&user)
	fmt.Println("Registration Successfully Done now Login")
}

func printDetails(content *[]bmmodel.Bookmark) {
	if content == nil {
		fmt.Println("No Records...")
	}
	for _, cont := range *content {
		fmt.Println("-------------------------------------------------------------------")
		if cont != *(&bmmodel.Bookmark{}) {
			fmt.Printf("ID: %d \nName: %s\n URL: %s \n Tag: %s\n", cont.ID, cont.Name, cont.URL, cont.Tag)
		}
	}
	fmt.Println("-------------------------------------------------------------------")
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

package view

import (
	"bufio"
	"fmt"
	"os"
	"strings"
	"time"

	"github.com/lin-sel/Bookmarkapp/model"
	"github.com/lin-sel/Bookmarkapp/service"
	uuid "github.com/satori/go.uuid"
	log "github.com/sirupsen/logrus"
)

//UserAuthMenu Show Authorization menu
func UserAuthMenu(ufw *model.UnitOfWork, repository *service.GormRepository) {
	for true {
		fmt.Println(" 1. Login \n 2. Register \n 3. Exit")
		var input int
		fmt.Scan(&input)
		switch input {
		case 1:
			Login(ufw, repository)
		case 2:
			RegisterUser(ufw, repository)
		case 3:
			log.Info("Exit")
			os.Exit(0)
		default:
			fmt.Println("Invalid Choice")
		}
	}
}

// RegisterUser Register new User
func RegisterUser(ufw *model.UnitOfWork, repository *service.GormRepository) {
	user := model.User{
		ModelBase: model.ModelBase{
			ID:        GetUUID(),
			CreatedAt: time.Now(),
			UpdateAt:  time.Now(),
			DeletedAt: nil,
		},
	}
	user.Username = Scanln("Enter Username")
	user.Password = Scanln("Enter Password")
	err := repository.Add(ufw, user)
	if err != nil {
		log.Fatal(err)
		return
	}
	fmt.Println("Register SuccessFully...")
}

// Login User
func Login(ufw *model.UnitOfWork, repository *service.GormRepository) {
	user := model.User{}
	user.Username = Scanln("Enter Username")
	user.Password = Scanln("Enter Password")
	users := []model.User{}
	var preload []string
	err := repository.GetAll(ufw, &users, preload)
	if err != nil {
		log.Fatal(err)
		return
	}
	for _, dbuser := range users {
		if dbuser.Username == user.Username && dbuser.Password == user.Password {
			log.Info("Login successfully")
			ShowMenu(&dbuser, repository, ufw)
			return
		}
	}
	log.Warn("Invalid Username, Password")
}

// Scanln take input from user
func Scanln(statement string) string {
	fmt.Println(statement)
	reader := bufio.NewReader(os.Stdin)
	input, err := reader.ReadString('\n')
	input = input[:len(input)-1]
	input = strings.ReplaceAll(input, " ", "")
	fmt.Println(input)
	if err != nil || input == "" {
		log.Warn(err)
		Scanln(statement)
	}
	if input == "" {
		log.Warn("Invalid input")
		Scanln(statement)
	}
	return input
}

// GetUUID Generate UUID
func GetUUID() uuid.UUID {
	return uuid.NewV4()
}

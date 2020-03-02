package view

import (
	"fmt"
	"os"
	"time"

	"github.com/lin-sel/Bookmarkapp/model"
	"github.com/lin-sel/Bookmarkapp/service"
	"github.com/sirupsen/logrus"
	log "github.com/sirupsen/logrus"
)

var (
	user model.User
	repo *service.GormRepository
	uow  *model.UnitOfWork
)

// ShowMenu Show Bookmark Menu
func ShowMenu(authUser *model.User, repository *service.GormRepository, ufw *model.UnitOfWork) {
	user = *authUser
	repo = repository
	uow = ufw
	for true {
		fmt.Println(" 1. Add New Bookmark \n 2. Update Bookmark \n 3. Get Bookmark By ID\n 4. Get All Bookmark \n 5. Delete Bookmark \n 6. Export To File \n 7. Exit")
		var input int
		fmt.Scan(&input)
		switch input {
		case 1:
			addBookmark()
		case 2:

		case 3:

		case 4:
			getAllBookmark()
		case 5:

		case 6:

		case 7:
			logrus.Info("Application Terminated....")
			os.Exit(0)
		}
	}
}

func addBookmark() {
	bookmark := model.Bookmark{
		ModelBase: model.ModelBase{
			ID:        GetUUID(),
			CreatedAt: time.Now(),
			UpdateAt:  time.Now(),
			DeletedAt: nil,
		},
		Name:   Scanln("Enter Label For Url"),
		URL:    Scanln("Enter URL"),
		USERID: user.ID,
	}
	err := repo.Add(uow, bookmark)
	statusHandler(err)
}

func getAllBookmark() {
	bookmarks := []model.Bookmark{}
	var assoc []string
	repo.GetAllForTenant(uow, &bookmarks, user.ID, assoc)
	println(bookmarks)
}

func statusHandler(err error) {
	if err != nil {
		log.Fatal(err)
		uow.Complete()
		return
	}
	log.Info("Action Completed")
	uow.Commit()
}

func println(bookmarks []model.Bookmark) {
	for _, bookmark := range bookmarks {
		fmt.Printf("ID: %v\nLabel: %s\nurl: %s\n", bookmark.ID, bookmark.Name, bookmark.URL)
	}
}

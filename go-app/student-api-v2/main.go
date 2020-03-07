package main

import (
	"context"
	"net/http"
	"os"
	"os/signal"
	"time"

	"github.com/gorilla/handlers"
	"github.com/gorilla/mux"
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
	"github.com/lin-sel/student-api/controller"
	log "github.com/sirupsen/logrus"
)

func main() {
	route := mux.NewRouter()
	db := dbConn()
	serviceInit(db, route)
	headers := handlers.AllowedHeaders([]string{"Content-Type"})
	methods := handlers.AllowedMethods([]string{"POST", "PUT", "GET", "DELETE"})
	origin := handlers.AllowedOrigins([]string{"*"})
	srv := &http.Server{
		Handler:      handlers.CORS(headers, methods, origin)(route),
		WriteTimeout: 15 * time.Second,
		ReadTimeout:  15 * time.Second,
		Addr:         ":8080",
	}
	var wait time.Duration

	go func() {
		log.Fatal(srv.ListenAndServe())
	}()

	ch := make(chan os.Signal, 1)

	signal.Notify(ch, os.Interrupt)

	<-ch

	ctx, cancel := context.WithTimeout(context.Background(), wait)
	defer cancel()
	defer func() {
		db.Close()
	}()
	srv.Shutdown(ctx)
	log.Info("Server ShutDown....")
}

func dbConn() *gorm.DB {
	obj, err := gorm.Open("mysql", "swabhav:swabhav@tcp(127.0.0.1)/Swabhav?charset=utf8&parseTime=true")
	if err != nil {
		log.Fatal(err)
	}
	return obj
}

func serviceInit(db *gorm.DB, route *mux.Router) {
	db.AutoMigrate(&controller.Student{})
	studentservice := controller.NewStudentService(db)
	routerservice := controller.NewRouterService(studentservice)
	routerservice.RouterStart(route)
}

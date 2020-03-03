package main

import (
	"context"
	"net/http"
	"os"
	"os/signal"
	"time"

	"github.com/gorilla/handlers"
	"github.com/gorilla/mux"
	"github.com/lin-sel/student-api/controller"
	log "github.com/sirupsen/logrus"
)

func main() {
	route := mux.NewRouter()
	if route == nil {
		log.Fatal("New Router Not Created")
	}
	log.Info("Router Object Created")
	controller.RouterStart(route)
	headers := handlers.AllowedHeaders([]string{"Content-Type"})
	methods := handlers.AllowedMethods([]string{"POST", "PUT", "GET", "DELETE"})
	origin := handlers.AllowedOrigins([]string{"*"})
	srv := &http.Server{
		Handler:      handlers.CORS(headers, methods, origin)(route),
		WriteTimeout: 15 * time.Second,
		ReadTimeout:  15 * time.Second,
		Addr:         "127.0.0.1:8080",
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
	srv.Shutdown(ctx)
	log.Info("Server ShutDown....")
	os.Exit(0)
}

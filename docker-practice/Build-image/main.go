package main

import (
	"fmt"
	"log"
	"net/http"
	"os"

	"github.com/gorilla/mux"
)

func main() {
	r := mux.NewRouter()
	fmt.Println("Server Started")
	r.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		w.Write([]byte("Hello " + os.Getenv("NAME")))
	})

	log.Fatal(http.ListenAndServe(":"+os.Getenv("PORT"), r))
}

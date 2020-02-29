package main

import (
	"net/http"

	"github.com/gorilla/mux"
)

func main() {
	route := mux.NewRouter()
	route.HandleFunc("/", index)
	route.HandleFunc("/welcome", welcome)
	route.HandleFunc("/welcome/{name}", welcomename)
	http.ListenAndServe(":8080", route)
}

func index(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-type", "text")
	w.Write([]byte("index Page"))
}

func welcome(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("content-type", "text")
	w.Write([]byte("Welcome to page"))
}

func welcomename(w http.ResponseWriter, r *http.Request) {
	name := mux.Vars(r)
	w.Write([]byte("welcome " + name["name"]))
}

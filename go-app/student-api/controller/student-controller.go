package controller

import (
	"encoding/json"
	"fmt"
	"net/http"
	"strconv"
	"strings"

	"github.com/gorilla/mux"
	log "github.com/sirupsen/logrus"
)

var (
	studentser = NewStudentService()
)

// RouterStart start endpoint
func RouterStart(router *mux.Router) {
	router.HandleFunc("/", getAll).Methods("GET")
	router.HandleFunc("/{id}", getByID).Methods("GET")
	router.HandleFunc("/", addStudent).Methods("POST")
	router.HandleFunc("/{id}", updateStudent).Methods("PUT")
	router.HandleFunc("/{id}", deleteStudent).Methods("DELETE")
	log.Info("Route Register")
}

func getAll(w http.ResponseWriter, r *http.Request) {
	log.Info("Get Endpoint Hit")
	w.Header().Set("Content-type", "application/json")
	var students []Student
	err := studentser.GetAll(&students)
	fmt.Println(students)
	if err != nil {
		w.Write([]byte(`{"msg":"` + err.Error() + `"}`))
		return
	}
	json.NewEncoder(w).Encode(students)
}

func getByID(w http.ResponseWriter, r *http.Request) {
	log.Info("GetByID Endpoint Hit")
	w.Header().Set("Content-type", "application/json")
	id := mux.Vars(r)["id"]
	var student []Student
	err := studentser.GetByID(id, &student)
	if err != nil {
		w.Write([]byte(`{"msg":"` + err.Error() + `"}`))
		return
	}
	json.NewEncoder(w).Encode(student)
}

func addStudent(w http.ResponseWriter, r *http.Request) {
	log.Info("Add Endpoint Hit")
	w.Header().Set("Content-type", "application/json")
	var student Student
	if strings.Compare(r.Header["Content-Type"][0], "application/x-www-form-urlencoded") == 0 {
		urlEncodedData(&student, r)
		fmt.Println(student)
	} else {
		err := json.NewDecoder(r.Body).Decode(&student)
		if err != nil {
			fmt.Println(err)
			w.Write([]byte(`{"msg":"Something Wrong in Data Parsing"}`))
			return
		}
	}
	fmt.Println(student)
	id, err := studentser.AddStudent(&student)
	if err != nil {
		w.Write([]byte(`{"msg":"` + err.Error() + `"}`))
		return
	}
	json.NewEncoder(w).Encode(id)
}

func updateStudent(w http.ResponseWriter, r *http.Request) {
	log.Info("Update Endpoint Hit")
	w.Header().Set("Content-Type", "application/json")
	var student Student
	id := mux.Vars(r)["id"]
	if strings.Compare(r.Header["Content-Type"][0], "application/x-www-form-urlencoded") == 0 {
		urlEncodedData(&student, r)
	} else {
		err := json.NewDecoder(r.Body).Decode(&student)
		if err != nil {
			w.Write([]byte(`{"msg":"Something Wrong in Data Parsing"}`))
			return
		}
	}
	student.ID = id
	fmt.Println(student)
	err := studentser.UpdateStudent(&student)
	if err != nil {
		w.Write([]byte(`{"msg":"` + err.Error() + `"}`))
		return
	}
}

func deleteStudent(w http.ResponseWriter, r *http.Request) {
	log.Info("Delete Endpoint Hit")
	w.Header().Set("Content-Type", "application/json")
	id := mux.Vars(r)["id"]
	err := studentser.DeleteStudent(id)
	if err != nil {
		w.Write([]byte(`{"msg":"` + err.Error() + `"}`))
		return
	}
}

func urlEncodedData(student *Student, r *http.Request) {
	r.ParseForm()
	student.Name = r.FormValue("name")
	student.Age = int8(getInt(r.FormValue("age")))
	student.Date = r.FormValue("date")
	student.Email = r.FormValue("email")
	student.IsMale = getBool(r.FormValue("isMale"))
	student.RollNo = int8(getInt(r.FormValue("rollNo")))
}

func getInt(s string) int64 {
	v, _ := strconv.ParseInt(s, 10, 64)
	return v
}

func getBool(s string) bool {
	return strings.Compare(s, "true") == 0
}

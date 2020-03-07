package controller

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
	"strconv"
	"strings"

	"github.com/gorilla/mux"
	uuid "github.com/satori/go.uuid"
)

// RouterService Object
type RouterService struct {
	Studentservice *StudentService
}

// NewRouterService return new Object
func NewRouterService(st *StudentService) *RouterService {
	return &RouterService{
		Studentservice: st,
	}
}

// RouterStart start endpoint
func (rs *RouterService) RouterStart(router *mux.Router) {
	router.HandleFunc("/api/", rs.getAll).Methods("GET")
	router.HandleFunc("/api/{id}", rs.getByID).Methods("GET")
	router.HandleFunc("/api/", rs.addStudent).Methods("POST")
	router.HandleFunc("/api/{id}", rs.updateStudent).Methods("PUT")
	router.HandleFunc("/api/{id}", rs.deleteStudent).Methods("DELETE")
}

// Return All Student
func (rs *RouterService) getAll(w http.ResponseWriter, r *http.Request) {
	setHeader(&w)
	var students []Student
	err := rs.Studentservice.GetAll(&students)
	if err != nil {
		w.WriteHeader(http.StatusInternalServerError)
		return
	}
	json.NewEncoder(w).Encode(students)
}

// Return Student By ID
func (rs *RouterService) getByID(w http.ResponseWriter, r *http.Request) {
	setHeader(&w)
	id := mux.Vars(r)["id"]
	var student []Student
	err := rs.Studentservice.GetByID(id, &student)
	if err != nil {
		w.WriteHeader(http.StatusInternalServerError)
		return
	}
	json.NewEncoder(w).Encode(student)
}

// Add New Student to List
func (rs *RouterService) addStudent(w http.ResponseWriter, r *http.Request) {
	setHeader(&w)
	var student Student
	if strings.Compare(r.Header["Content-Type"][0], "application/x-www-form-urlencoded") == 0 {
		urlEncodedData(&student, r)
	} else {
		var p []byte
		p, _ = ioutil.ReadAll(r.Body)
		// r.Body.Read(p)
		fmt.Println("Byte", string(p))
		err := json.NewDecoder(r.Body).Decode(&student)
		fmt.Println(student)
		if err != nil {
			fmt.Println(err)
			w.WriteHeader(http.StatusBadRequest)
			return
		}
	}
	id, err := rs.Studentservice.AddStudent(&student)
	if err != nil {
		w.WriteHeader(http.StatusInternalServerError)
		return
	}
	json.NewEncoder(w).Encode(id)
}

// Update Student By ID
func (rs *RouterService) updateStudent(w http.ResponseWriter, r *http.Request) {
	setHeader(&w)
	var student Student
	id := mux.Vars(r)["id"]
	if strings.Compare(strings.Trim(id, " "), "") == 0 {
		w.Write([]byte("Invalid ID"))
		return
	}
	if strings.Compare(r.Header["Content-Type"][0], "application/x-www-form-urlencoded") == 0 {
		urlEncodedData(&student, r)
	} else {
		err := json.NewDecoder(r.Body).Decode(&student)
		if err != nil {
			w.WriteHeader(http.StatusInternalServerError)
			return
		}
	}
	if id, err := uuid.FromString(id); err == nil {
		student.ID = id
	} else {
		w.WriteHeader(http.StatusInternalServerError)
		return
	}
	err := rs.Studentservice.UpdateStudent(&student)
	if err != nil {
		w.WriteHeader(http.StatusInternalServerError)
		return
	}
}

// Delete Student By ID
func (rs *RouterService) deleteStudent(w http.ResponseWriter, r *http.Request) {
	setHeader(&w)
	id := mux.Vars(r)["id"]
	err := rs.Studentservice.DeleteStudent(id)
	if err != nil {
		w.WriteHeader(http.StatusInternalServerError)
		return
	}
}

// Decode application/x-www-form-urlencoded data to Struct
func urlEncodedData(student *Student, r *http.Request) {
	r.ParseForm()
	student.Name = r.FormValue("name")
	student.Age = int8(getInt(r.FormValue("age")))
	student.Date = r.FormValue("date")
	student.Email = r.FormValue("email")
	student.IsMale = getBool(r.FormValue("isMale"))
	student.RollNo = getInt(r.FormValue("rollNo"))
}

func getInt(s string) int64 {
	v, _ := strconv.ParseInt(s, 10, 64)
	return v
}

func getBool(s string) bool {
	return strings.Compare(s, "true") == 0
}

func setHeader(w *http.ResponseWriter) {
	(*w).Header().Set("Content-Type", "application/json")
}

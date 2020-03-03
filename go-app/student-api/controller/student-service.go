package controller

import (
	"errors"
	"fmt"

	uuid "github.com/satori/go.uuid"
)

var studentlist map[string]Student

// Student Object
type Student struct {
	ID     string `json:"id"`
	Name   string `json:"name"`
	RollNo int8   `json:"rollNo"`
	Age    int8   `json:"age"`
	Email  string `json:"email"`
	Date   string `json:"date"`
	IsMale bool   `json:"isMale"`
}

// StudentService Structure
type StudentService struct{}

//NewStudentService new Student Service
func NewStudentService() *StudentService {
	initService()
	return &StudentService{}
}

// AddStudent Add to Map
func (studentser *StudentService) AddStudent(student *Student) (string, error) {
	student.ID = newUUID()
	if _, ok := studentlist[student.ID]; !ok {
		studentlist[student.ID] = *student
		return student.ID, nil
	}

	return "", errors.New("Can't Add Value Already Present on ID")
}

// DeleteStudent Delete Student From list
func (studentser *StudentService) DeleteStudent(id string) error {
	if _, ok := studentlist[id]; ok {
		delete(studentlist, id)
		return nil
	}
	return errors.New("Student Data Not Found")
}

// UpdateStudent Student list
func (studentser *StudentService) UpdateStudent(student *Student) error {
	if _, ok := studentlist[student.ID]; ok {
		studentlist[student.ID] = *student
		return nil
	}
	return errors.New("Student Not Found")
}

// GetByID Get By ID
func (studentser *StudentService) GetByID(id string, student *[]Student) error {
	if val, ok := studentlist[id]; ok {
		*student = append(*student, val)
		fmt.Println(val)
		return nil
	}
	return errors.New("invalid ID")
}

// GetAll Return all Students
func (studentser *StudentService) GetAll(students *[]Student) error {
	if len(studentlist) == 0 {
		return errors.New("No Data Found")
	}
	for _, student := range studentlist {
		*students = append(*students, student)
	}
	return nil
}

func initService() {
	id := newUUID()
	studentlist = make(map[string]Student)
	studentlist[id] = Student{
		ID:     id,
		Age:    23,
		Date:   "10-20-1997",
		Email:  "ccnsy@gmail.com",
		IsMale: true,
		Name:   "Nilesh",
		RollNo: 12,
	}
	id = newUUID()
	studentlist[id] = Student{
		ID:     id,
		Age:    25,
		Date:   "10-1-1997",
		Email:  "ccnsy@gmail.com",
		IsMale: true,
		Name:   "Akshay",
		RollNo: 19,
	}
}

func newUUID() string {
	return uuid.NewV4().String()
}

// // DateFormat date format
// func DateFormat(date string) time.Time {
// 	layout := "2006-01-02"
// 	st, _ := time.Parse(layout, date)
// 	return st
// }

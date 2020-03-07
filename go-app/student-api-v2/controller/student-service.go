package controller

import (
	"errors"

	"github.com/jinzhu/gorm"
	"github.com/lin-sel/student-api/repository"
	uuid "github.com/satori/go.uuid"
)

var studentlist map[string]Student

// Student Object
type Student struct {
	repository.Basemodel
	Name   string `json:"name"`
	RollNo int64  `json:"rollNo"`
	Age    int8   `json:"age"`
	Email  string `json:"email"`
	Date   string `json:"date"`
	IsMale bool   `json:"isMale"`
}

// StudentService Structure
type StudentService struct {
	DB  *gorm.DB
	svr *repository.StudentRepository
}

//NewStudentService new Student Service
func NewStudentService(db *gorm.DB) *StudentService {
	return &StudentService{
		DB:  db,
		svr: repository.NewRepository(),
	}
}

// AddStudent Add to Map
func (studentser *StudentService) AddStudent(student *Student) (string, error) {
	student.ID = newUUID()
	uow := repository.NewUnitOfWork(studentser.DB, false)
	err := studentser.svr.Add(uow, student)
	if err != nil {
		uow.Complete()
		return "", err
	}
	uow.Commit()
	return student.ID.String(), nil
}

// DeleteStudent Delete Student From list
func (studentser *StudentService) DeleteStudent(id string) error {
	uow := repository.NewUnitOfWork(studentser.DB, false)
	uuid, err := uuid.FromString(id)
	if err != nil {
		return errors.New("Inavlid Id")
	}

	err = studentser.svr.Delete(uow, uuid, &Student{})
	if err != nil {
		uow.Complete()
		return err
	}
	uow.Commit()
	return nil
}

// UpdateStudent Student list
func (studentser *StudentService) UpdateStudent(student *Student) error {
	uow := repository.NewUnitOfWork(studentser.DB, false)
	err := studentser.svr.Update(uow, student)
	if err != nil {
		uow.Complete()
		return err
	}
	uow.Commit()
	return nil
}

// GetByID Get By ID
func (studentser *StudentService) GetByID(id string, students *[]Student) error {
	var student Student
	uuid, err := uuid.FromString(id)
	if err != nil {
		return errors.New("Inavlid Id")
	}
	uow := repository.NewUnitOfWork(studentser.DB, true)
	err = studentser.svr.Get(uow, uuid, &student)
	if err != nil {
		uow.Complete()
		return err
	}
	*students = append(*students, student)
	uow.Commit()
	return nil
}

// GetAll Return all Students
func (studentser *StudentService) GetAll(students *[]Student) error {
	uow := repository.NewUnitOfWork(studentser.DB, true)
	err := studentser.svr.GetAll(uow, students)
	if err != nil {
		uow.Complete()
		return err
	}
	uow.Commit()
	return err
}

func newUUID() uuid.UUID {
	return uuid.NewV4()
}

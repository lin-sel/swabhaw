package main

import (
	"time"

	uuid "github.com/satori/go.uuid"
)

// ModelBase model
type ModelBase struct {
	ID        uuid.UUID
	CreatedAt time.Time `gorm:"column:createOn"`
	UpadtedAt time.Time `gorm:"column:updateOn"`
	DeletedAt time.Time `gorm:"column:deleteOn"`
}

// repositorystruct implements Repository
type repositorystruct struct {
	ModelBase
	Name    string
	Detaile string
}

func main() {

}

// NewRepository returns a new repository object
func NewRepository() Repository {
	return &repositorystruct{}
}

// Get a record for specified entity with specific id
func (repository *repositorystruct) Get(uow *UnitOfWork, out interface{}, id uuid.UUID, preloadAssociations []string) error {
	db := uow.DB
	for _, association := range preloadAssociations {
		db = db.Preload(association)
	}
	return db.First(out, "id = ?", id).Error
}

// GetAll retrieves all the records for a specified entity and returns it
func (repository *repositorystruct) GetAll(uow *UnitOfWork, out interface{}, preloadAssociations []string) error {
	db := uow.DB
	for _, association := range preloadAssociations {
		db = db.Preload(association)
	}
	return db.Find(out).Error
}

// GetAllForTenant returns all objects of specifeid tenantID
func (repository *repositorystruct) GetAllForTenant(uow *UnitOfWork, out interface{}, tenantID uuid.UUID, preloadAssociations []string) error {
	db := uow.DB
	for _, association := range preloadAssociations {
		db = db.Preload(association)
	}
	return db.Where("tenantID = ?", tenantID).Find(out).Error
}

// Add specified Entity
func (repository *repositorystruct) Add(uow *UnitOfWork, entity interface{}) error {
	return uow.DB.Create(entity).Error
}

// Update specified Entity
func (repository *repositorystruct) Update(uow *UnitOfWork, entity interface{}) error {
	return uow.DB.Model(entity).Update(entity).Error
}

// Delete specified Entity
func (repository *repositorystruct) Delete(uow *UnitOfWork, entity interface{}) error {
	return uow.DB.Delete(entity).Error
}

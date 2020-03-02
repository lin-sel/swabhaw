package service

import (
	"github.com/jinzhu/gorm"
	"github.com/lin-sel/Bookmarkapp/model"
	uuid "github.com/satori/go.uuid"
)

// Repository Interface
type Repository interface {
	Get(ufw *model.UnitOfWork, out interface{}, id uuid.UUID, preloadAssociation []string) error
	GetAll(ufw *model.UnitOfWork, out interface{}, preloadAssociation []string) error
	GetAllForTenant(ufw *model.UnitOfWork, out interface{}, id uuid.UUID, preloadAssociation []string)
	Add(ufw *model.UnitOfWork, out interface{}) error
	Update(ufw *model.UnitOfWork, out interface{}) error
	Delete(ufw *model.UnitOfWork, out interface{}) error
}

// GormRepository Implement interface
type GormRepository struct{}

// NewUnitOfWork return Object Of Unitofwork
func NewUnitOfWork(conn *gorm.DB, readonly bool) *model.UnitOfWork {
	if readonly {
		return &model.UnitOfWork{
			DB:        conn,
			Readonly:  true,
			Committed: false,
		}
	}
	return &model.UnitOfWork{
		DB:        conn,
		Readonly:  false,
		Committed: false,
	}
}

// NewRepository return new Repository Object.
func NewRepository() *GormRepository {
	return &GormRepository{}
}

// Get Entity by id
func (repository *GormRepository) Get(ufw *model.UnitOfWork, out interface{}, id uuid.UUID, preloadAssociation []string) error {
	db := ufw.DB
	for _, assoc := range preloadAssociation {
		db.Preload(assoc)
	}
	return db.First(out, "id = ?", id).Error
}

// GetAll return all data
func (repository *GormRepository) GetAll(ufw *model.UnitOfWork, out interface{}, preloadAssociation []string) error {
	db := ufw.DB
	for _, assoc := range preloadAssociation {
		db.Preload(assoc)
	}
	return db.Find(out).Error
}

// GetAllForTenant get all by tenantid
func (repository *GormRepository) GetAllForTenant(ufw *model.UnitOfWork, out interface{}, tenantid uuid.UUID, preloadAssociation []string) error {
	db := ufw.DB
	for _, assoc := range preloadAssociation {
		db.Preload(assoc)
	}
	return db.Where("user_id = ?", tenantid).Find(out).Error
}

// Update Update Entity
func (repository *GormRepository) Update(ufw *model.UnitOfWork, entity interface{}) error {
	return ufw.DB.Model(entity).Update(entity).Error
}

//Add add Entity to Table
func (respositry *GormRepository) Add(ufw *model.UnitOfWork, entity interface{}) error {
	return ufw.DB.Create(entity).Error
}

// Delete Entity to Table
func (repository *GormRepository) Delete(ufw *model.UnitOfWork, entity interface{}) error {
	return ufw.DB.Delete(entity).Error
}

package main

import (
	"log"
	"time"

	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
	uuid "github.com/satori/go.uuid"
)

// Repository Interface
type Repository interface {
	Get(uow *UnitOfWork, out interface{}, id uuid.UUID, preloadAssociations []string) error
	GetAll(uow *UnitOfWork, out interface{}, preloadAssociations []string) error
	GetAllForTenant(uow *UnitOfWork, out interface{}, tenantID uuid.UUID, preloadAssociations []string) error
	Add(uow *UnitOfWork, out interface{}) error
	Update(uow *UnitOfWork, out interface{}) error
	Delete(uow *UnitOfWork, out interface{}) error
}

// UnitOfWork connection object
type UnitOfWork struct {
	DB       *gorm.DB
	commited bool
	readonly bool
}

// NewUnitofWork Return new Object
func NewUnitofWork(conn *gorm.DB, readonly bool) *UnitOfWork {
	if readonly {
		return &UnitOfWork{
			DB:       conn.New(),
			commited: false,
			readonly: true,
		}
	}
	return &UnitOfWork{
		DB:       conn.New().Begin(),
		commited: false,
		readonly: false,
	}
}

// Complete mark at the end of the unitwork
func (ufw *UnitOfWork) Complete() {
	if !ufw.commited && !ufw.readonly {
		ufw.DB.Rollback()
	}
}

// Commit after writing
func (ufw *UnitOfWork) Commit() {
	if !ufw.readonly {
		ufw.DB.Commit()
	}
}

// ModelBase model
type ModelBase struct {
	ID        uuid.UUID  `gorm:"type:varchar(36)"`
	CreatedAt time.Time  `gorm:"column:createOn; default:CURRENT_TIMESTAMP"`
	UpadtedAt time.Time  `gorm:"column:updateOn;default:CURRENT_TIMESTAMP"`
	DeletedAt *time.Time `gorm:"column:deleteOn;"`
}

// GormRepository implement repository
type GormRepository struct {
}

// NewRepository returns a new repository object
func NewRepository() Repository {
	return &GormRepository{}
}

// Get a record for specified entity with specific id
func (repository *GormRepository) Get(uow *UnitOfWork, out interface{}, id uuid.UUID, preloadAssociations []string) error {
	db := uow.DB
	for _, association := range preloadAssociations {
		db = db.Preload(association)
	}
	return db.First(out, "id = ?", id).Error
}

// GetAll retrieves all the records for a specified entity and returns it
func (repository *GormRepository) GetAll(uow *UnitOfWork, out interface{}, preloadAssociations []string) error {
	db := uow.DB
	for _, association := range preloadAssociations {
		db = db.Preload(association)
	}
	return db.Find(out).Error
}

// GetAllForTenant returns all objects of specifeid tenantID
func (repository *GormRepository) GetAllForTenant(uow *UnitOfWork, out interface{}, tenantID uuid.UUID, preloadAssociations []string) error {
	db := uow.DB
	for _, association := range preloadAssociations {
		db = db.Preload(association)
	}
	return db.Where("tenantID = ?", tenantID).Find(out).Error
}

// Add specified Entity
func (repository *GormRepository) Add(uow *UnitOfWork, entity interface{}) error {
	return uow.DB.Create(entity).Error
}

// Update specified Entity
func (repository *GormRepository) Update(uow *UnitOfWork, entity interface{}) error {
	return uow.DB.Model(entity).Update(entity).Error
}

// Delete specified Entity
func (repository *GormRepository) Delete(uow *UnitOfWork, entity interface{}) error {
	return uow.DB.Delete(entity).Error
}

// Example implements Repository
type Example struct {
	ModelBase
	Name   string
	Detail string
}

func main() {
	con := conn().AutoMigrate(&Example{})
	defer con.Close()
	ufw := NewUnitofWork(con, false)
	id, _ := uuid.NewV4()
	emp := &Example{
		ModelBase: ModelBase{
			ID: id,
		},
		Name:   "Test",
		Detail: "Test",
	}

	gr := NewRepository()
	er := gr.Add(ufw, emp)
	if er != nil {
		log.Fatal(er)
		ufw.Complete()
		return
	}
	ufw.Commit()

}

func conn() *gorm.DB {
	con, err := gorm.Open("mysql", "swabhav:swabhav@tcp(localhost)/Swabhav?charset=utf8&parseTime=true")
	if err != nil {
		log.Fatal(err)
	}
	return con
}

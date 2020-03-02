package model

import "go.mongodb.org/mongo-driver/bson/primitive"

// Expense Model
type Expense struct {
	ID          primitive.ObjectID `json:"_id,omitempty" bson:"_id,omitempty"`
	Amount      int                `json:"amount,omitempty" bson:"amount,omitempty"`
	Date        string             `json:"date,omitempty" bson:"date,omitempty"`
	Description string             `json:"description,omitempty" bson:"description,omitempty"`
	Category    string             `json:"category,omitempty" bson:"category,omitempty"`
}

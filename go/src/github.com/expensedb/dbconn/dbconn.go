package dbconn

import (
	"context"

	"go.mongodb.org/mongo-driver/mongo"
	"go.mongodb.org/mongo-driver/mongo/options"
)

// Conn function connect with mongodb.
func Conn() (*mongo.Client, error) {
	clientOption := options.Client().ApplyURI("mongodb://localhost:27017")

	conns, err := mongo.Connect(context.Background(), clientOption)

	return conns, err
}

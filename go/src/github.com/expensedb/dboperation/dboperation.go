package dboperation

import (
	"context"

	"github.com/lin-sel/expensedb/dbconn"
	"github.com/lin-sel/expensedb/model"
	"go.mongodb.org/mongo-driver/bson"
	"go.mongodb.org/mongo-driver/bson/primitive"
	"go.mongodb.org/mongo-driver/mongo"
)

var mong *mongo.Client
var collection *mongo.Collection

// Insert One Data
func Insert(data model.Expense) (*mongo.InsertOneResult, error) {

	// db Config.
	connectDb()
	defer disconnectDb()

	insertst, err := collection.InsertOne(context.TODO(), data)
	if err != nil {
		return nil, err
	}
	return insertst, nil
}

// Update data
func Update(id string, data model.Expense) (*mongo.UpdateResult, error) {

	// db Config.
	connectDb()
	defer disconnectDb()

	filter := bson.D{
		{"_id", stringToHex(id)},
	}

	data.ID = stringToHex(id)
	updatest, err := collection.UpdateOne(context.TODO(), filter, bson.D{{"$set", data}})
	if err != nil {
		return nil, err
	}
	return updatest, nil
}

// GetByID return one Data
func GetByID(id string) (*mongo.Cursor, error) {

	// db Config.
	connectDb()
	defer disconnectDb()
	data, err := collection.Find(context.TODO(), bson.D{{"_id", stringToHex(id)}})

	if err != nil {
		return nil, err
	}
	return data, nil
}

// GetAll return all Data
func GetAll() (*mongo.Cursor, error) {

	// db Config.
	connectDb()
	defer disconnectDb()

	data, err := collection.Find(context.TODO(), bson.D{{}})
	if err != nil {
		return nil, err
	}
	return data, nil
}

// DeleteByID one Data
func DeleteByID(id string) (*mongo.DeleteResult, error) {
	// db Config.
	connectDb()
	defer disconnectDb()
	deletest, err := collection.DeleteOne(context.TODO(), bson.D{{"_id", stringToHex(id)}})
	if err != nil {
		return nil, err
	}
	return deletest, nil
}

func selectCollection(db, collec string) {
	collection = mong.Database(db).Collection(collec)
}

// Connect To Database.
func connectDb() {
	db, err := dbconn.Conn()
	if err == nil {
		mong = db
		selectCollection("expstest", "coll")
		return
	}
}

// Disconnect from Database.
func disconnectDb() {
	mong.Disconnect(context.Background())
}

func stringToHex(id string) primitive.ObjectID {
	ids, _ := primitive.ObjectIDFromHex(id)
	return ids
}

package main

import (
	"context"
	"fmt"

	"github.com/lin-sel/expensedb/apicontr"
	"github.com/lin-sel/expensedb/dboperation"
	"github.com/lin-sel/expensedb/model"
)

func main() {
	// TestGetData()
	// TestGetAllData()
	// TestInsert()
	// TestUpdate()
	// TestDelete()
	apicontr.Router()
}

// TestInsert function
// func TestInsert() {
// 	data := model.Expense{"12", 1300, "11/12/1997", "Tested Description", "Food"}
// 	st, err := dboperation.Insert(data)
// 	if err != nil {
// 		fmt.Println(err)
// 	}
// 	fmt.Println(st.InsertedID)
// }

// // TestUpdate function
// func TestUpdate() {
// 	data := model.Expense{"12", 1300, "11/12/1997", "Tested Twice Description", "Food"}
// 	st, err := dboperation.Update(data)
// 	if err != nil {
// 		fmt.Println(err)
// 	}
// 	fmt.Println(st.ModifiedCount)
// }

// TestGetData test function
func TestGetData() {
	st, err := dboperation.GetByID("12")
	if err != nil {
		fmt.Println(err)
	}
	var expense []model.Expense
	st.All(context.TODO(), &expense)
	fmt.Println(expense, string(2))
}

// TestGetAllData test function
func TestGetAllData() {
	st, err := dboperation.GetAll()
	if err != nil {
		fmt.Println(err)
	}
	var expense []model.Expense
	st.All(context.TODO(), &expense)
	fmt.Println(expense, string(2))
}

// TestDelete function
func TestDelete() {
	st, err := dboperation.DeleteByID("12")
	if err != nil {
		fmt.Println(err)
	}
	fmt.Println(st.DeletedCount)
}

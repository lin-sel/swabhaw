import { Injectable } from '@angular/core';
import { Platform } from '@ionic/angular';
import { SQLite, SQLiteObject } from '@ionic-native/sqlite/ngx'

@Injectable({
  providedIn: 'root'
})
export class DatabaseService {

  // Database Accessory.
  private dbname: string = 'dbexpense';
  private location: string = 'default';
  private table: string = 'expense';
  private password: string = 'ABCD(*#$%';
  private db: SQLiteObject;

  constructor(private _plt: Platform, private _sqlite: SQLite) {
    this.initDB();
  }

  initDB() {
    this._sqlite.create({
      name: this.dbname,
      location: this.location,
      key: this.password
    }).then((dbs: SQLiteObject) => {
      this.db = dbs;
      console.log("Created SuccessFully");
    }).catch((err) => {
      console.log(err);
    });
  }


  private createTable() {
    this.db.executeSql(`CREATE TABLE IF NOT EXISTS ${this.table}(id, amount, description, category, date)`, []).catch(() => {
      console.log('Table Created SuccessFully');
    }).catch((err) => {
      console.log(err);
    }).catch(e => {
      console.log('outside', e);
    })
  }
}

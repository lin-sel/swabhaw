
export class Customer {
    constructor(private _id, private _name) {
    }

    get ID() {
        return this._id;
    }

    get Name() {
        return this._name;
    }

    set Id(id) {
        this._id = id;
    }
}


let c = new Customer(101, "ABCED");
console.log(c.ID);
console.log(c.Name);
c.Id = 201;
console.log(c.ID);


export class Address {
    constructor(private _address) { }

    get Addre() {
        return this._address;
    }
}
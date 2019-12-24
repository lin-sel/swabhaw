"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Customer = /** @class */ (function () {
    function Customer(_id, _name) {
        this._id = _id;
        this._name = _name;
    }
    Object.defineProperty(Customer.prototype, "ID", {
        get: function () {
            return this._id;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Customer.prototype, "Name", {
        get: function () {
            return this._name;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Customer.prototype, "Id", {
        set: function (id) {
            this._id = id;
        },
        enumerable: true,
        configurable: true
    });
    return Customer;
}());
exports.Customer = Customer;
var c = new Customer(101, "ABCED");
console.log(c.ID);
console.log(c.Name);
c.Id = 201;
console.log(c.ID);
var Address = /** @class */ (function () {
    function Address(_address) {
        this._address = _address;
    }
    Object.defineProperty(Address.prototype, "Addre", {
        get: function () {
            return this._address;
        },
        enumerable: true,
        configurable: true
    });
    return Address;
}());
exports.Address = Address;

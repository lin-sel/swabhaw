import { Pipe, PipeTransform } from '@angular/core';
import { IProduct } from '../interface/Iproduct';

@Pipe({ name: 'ListFilter' })
export class ListFilter implements PipeTransform {
    transform(value: IProduct[], input: string): IProduct[] {
        if (!input) {
            return value;
        }
        return value.filter(data => {
            if (data.productName.toLowerCase().indexOf(input.toLowerCase()) != -1) {
                return true;
            }
            return false;
        })
    }
}
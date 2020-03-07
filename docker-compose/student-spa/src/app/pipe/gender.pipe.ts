import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'getGender' })
export class GetGenderPipe implements PipeTransform {
    transform(value: boolean): string {
        if (value) {
            return "Male";
        }
        return "Female";
    }
}
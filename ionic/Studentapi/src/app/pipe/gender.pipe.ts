import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'isMale' })
export class IsMale implements PipeTransform {
    transform(value: boolean): string {
        return value ? 'Male' : 'Female';
    }
}
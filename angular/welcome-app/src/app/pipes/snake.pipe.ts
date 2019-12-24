import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'snake' })
export class Snake implements PipeTransform {
    transform(input: string): string {
        return input.replace(/ /g, '_');
    }
}
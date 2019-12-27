import { Pipe, PipeTransform, Input } from '@angular/core';
import { createNgModule } from '@angular/compiler/src/core';

@Pipe({ name: 'odd' })
export class OddFact implements PipeTransform {
    transform(input: IFact[], condition: boolean): IFact[] {
        if (condition) {
            return input.filter(f => f.num % 2 != 0);
        }
        return input;
    }
}
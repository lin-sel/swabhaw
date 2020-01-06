export interface IExpense {
    id: number,
    date: string,
    amount: number,
    description: string,
    category: string
}

export const Category: string[] = ['Food', 'Entertainment', 'Travel'];
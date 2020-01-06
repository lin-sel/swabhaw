export interface IExpense {
    _id: string,
    date: string,
    amount: number,
    description: string,
    category: string
}

export const Category: string[] = ['Food', 'Entertainment', 'Travel'];
export interface IQuestion {
    id: number,
    question: string,
    option: IOption[],
    ans: number;
}

interface IOption {
    optionid: number;
    option: string
}
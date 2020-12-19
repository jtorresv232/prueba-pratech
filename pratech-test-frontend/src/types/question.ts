import { Answer } from "./answer";
import { Validation } from "./validation";

export type Question = {
    id: number,
    question: string,
    answer: Answer,
    type: string,
    validations: Validation[]
}
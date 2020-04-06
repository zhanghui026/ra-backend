import { Moment } from 'moment';

export interface IReview {
  id?: number;
  date?: Moment;
  status?: string;
  customerId?: number;
  commandId?: number;
  productId?: number;
  rating?: number;
  comment?: string;
}

export const defaultValue: Readonly<IReview> = {};

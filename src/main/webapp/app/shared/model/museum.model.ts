import { Moment } from 'moment';

export interface IMuseum {
  id?: number;
  name?: string;
  rsName?: string;
  enName?: string;
  fullName?: string;
  rsFullName?: string;
  enFullName?: string;
  address?: string;
  rsAddress?: string;
  enAddress?: string;
  brief?: string;
  enBrief?: string;
  rsBrief?: string;
  phoneNum?: string;
  contactPerson?: string;
  createDate?: Moment;
  updateDate?: Moment;
  mainImg?: string;
}

export const defaultValue: Readonly<IMuseum> = {};

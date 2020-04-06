import { Moment } from 'moment';

export interface ICustomer {
  id?: number;
  firstName?: string;
  lastName?: string;
  email?: string;
  address?: string;
  zipcode?: string;
  city?: string;
  avatar?: string;
  birthday?: Moment;
  firstSeen?: Moment;
  lastSeen?: Moment;
  hasOrdered?: boolean;
  latestPurchase?: Moment;
  hasNewsletter?: boolean;
  groups?: string;
  nbCommands?: number;
  totalSpend?: number;
}

export const defaultValue: Readonly<ICustomer> = {
  hasOrdered: false,
  hasNewsletter: false
};

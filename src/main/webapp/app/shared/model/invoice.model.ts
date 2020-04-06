import { Moment } from 'moment';

export interface IInvoice {
  id?: number;
  date?: Moment;
  customerId?: number;
  commandId?: number;
  totalExTaxes?: number;
  deliveryFees?: number;
  taxRate?: number;
  taxes?: number;
  total?: number;
}

export const defaultValue: Readonly<IInvoice> = {};

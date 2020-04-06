import { Moment } from 'moment';

export interface ICommand {
  id?: number;
  reference?: string;
  date?: Moment;
  customerId?: number;
  basket?: string;
  totalExTaxes?: number;
  deliveryFees?: number;
  taxRate?: number;
  taxes?: number;
  total?: number;
  status?: string;
  returned?: boolean;
}

export const defaultValue: Readonly<ICommand> = {
  returned: false
};

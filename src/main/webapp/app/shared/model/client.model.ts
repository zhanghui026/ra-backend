export interface IClient {
  id?: number;
  name?: string;
  username?: string;
  email?: string;
  address?: string;
  phone?: string;
  website?: string;
  company?: string;
}

export const defaultValue: Readonly<IClient> = {};

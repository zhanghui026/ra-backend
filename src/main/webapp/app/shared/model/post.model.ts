export interface IPost {
  id?: number;
  userId?: number;
  title?: string;
  body?: string;
}

export const defaultValue: Readonly<IPost> = {};

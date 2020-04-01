export interface IProduct {
  id?: number;
  categoryId?: number;
  description?: string;
  height?: number;
  image?: string;
  price?: number;
  reference?: string;
  stock?: number;
  thumbnail?: string;
  width?: number;
}

export const defaultValue: Readonly<IProduct> = {};

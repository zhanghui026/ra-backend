import { Moment } from 'moment';

export interface IPainting {
  id?: number;
  name?: string;
  rsName?: string;
  enName?: string;
  artistId?: number;
  museumId?: number;
  age?: string;
  tags?: string;
  width?: number;
  height?: number;
  rawImg?: string;
  webImg?: string;
  thumbnailImg?: string;
  pin?: string;
  pinImg?: string;
  reference?: string;
  sentence?: string;
  rsSentence?: string;
  enSentence?: string;
  brief?: string;
  rsBrief?: string;
  enBrief?: string;
  info?: string;
  rsArtInfo?: string;
  enArtInfo?: string;
  rating?: number;
  createDate?: Moment;
  updateDate?: Moment;
  useArtistInfo?: boolean;
  category?: string;
  material?: string;
}

export const defaultValue: Readonly<IPainting> = {
  useArtistInfo: false
};

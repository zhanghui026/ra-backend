import { Moment } from 'moment';

export interface IArtist {
  id?: number;
  name?: string;
  rsName?: string;
  enName?: string;
  avatar?: string;
  citizenship?: string;
  bornAge?: string;
  sentence?: string;
  rsSentence?: string;
  enSentence?: string;
  brief?: string;
  rsBrief?: string;
  enBrief?: string;
  artInfo?: string;
  rsArtInfo?: string;
  enArtInfo?: string;
  createDate?: Moment;
  updateDate?: Moment;
}

export const defaultValue: Readonly<IArtist> = {};

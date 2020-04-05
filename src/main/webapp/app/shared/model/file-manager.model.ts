import { Moment } from 'moment';

export interface IFileManager {
  id?: number;
  fileNo?: string;
  bizCode?: string;
  defaultUrl?: string;
  defaultPath?: string;
  defaultFileName?: string;
  isImg?: boolean;
  size?: number;
  isThumbnail?: boolean;
  isCommit?: boolean;
  createTime?: Moment;
  updateTime?: Moment;
}

export const defaultValue: Readonly<IFileManager> = {
  isImg: false,
  isThumbnail: false,
  isCommit: false
};

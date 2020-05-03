import { combineReducers } from 'redux';
import { loadingBarReducer as loadingBar } from 'react-redux-loading-bar';

import locale, { LocaleState } from './locale';
import authentication, { AuthenticationState } from './authentication';
import applicationProfile, { ApplicationProfileState } from './application-profile';

import administration, { AdministrationState } from 'app/modules/administration/administration.reducer';
import userManagement, { UserManagementState } from 'app/modules/administration/user-management/user-management.reducer';
import register, { RegisterState } from 'app/modules/account/register/register.reducer';
import activate, { ActivateState } from 'app/modules/account/activate/activate.reducer';
import password, { PasswordState } from 'app/modules/account/password/password.reducer';
import settings, { SettingsState } from 'app/modules/account/settings/settings.reducer';
import passwordReset, { PasswordResetState } from 'app/modules/account/password-reset/password-reset.reducer';
// prettier-ignore
import post, {
  PostState
} from 'app/entities/post/post.reducer';
// prettier-ignore
import client, {
  ClientState
} from 'app/entities/client/client.reducer';
// prettier-ignore
import category, {
  CategoryState
} from 'app/entities/category/category.reducer';
// prettier-ignore
import product, {
  ProductState
} from 'app/entities/product/product.reducer';
// prettier-ignore
import fileManager, {
  FileManagerState
} from 'app/entities/file-manager/file-manager.reducer';
// prettier-ignore
import customer, {
  CustomerState
} from 'app/entities/customer/customer.reducer';
// prettier-ignore
import command, {
  CommandState
} from 'app/entities/command/command.reducer';
// prettier-ignore
import invoice, {
  InvoiceState
} from 'app/entities/invoice/invoice.reducer';
// prettier-ignore
import review, {
  ReviewState
} from 'app/entities/review/review.reducer';
// prettier-ignore
import artist, {
  ArtistState
} from 'app/entities/artist/artist.reducer';
// prettier-ignore
import painting, {
  PaintingState
} from 'app/entities/painting/painting.reducer';
// prettier-ignore
import museum, {
  MuseumState
} from 'app/entities/museum/museum.reducer';
// prettier-ignore
import tag, {
  TagState
} from 'app/entities/tag/tag.reducer';
/* jhipster-needle-add-reducer-import - JHipster will add reducer here */

export interface IRootState {
  readonly authentication: AuthenticationState;
  readonly locale: LocaleState;
  readonly applicationProfile: ApplicationProfileState;
  readonly administration: AdministrationState;
  readonly userManagement: UserManagementState;
  readonly register: RegisterState;
  readonly activate: ActivateState;
  readonly passwordReset: PasswordResetState;
  readonly password: PasswordState;
  readonly settings: SettingsState;
  readonly post: PostState;
  readonly client: ClientState;
  readonly category: CategoryState;
  readonly product: ProductState;
  readonly fileManager: FileManagerState;
  readonly customer: CustomerState;
  readonly command: CommandState;
  readonly invoice: InvoiceState;
  readonly review: ReviewState;
  readonly artist: ArtistState;
  readonly painting: PaintingState;
  readonly museum: MuseumState;
  readonly tag: TagState;
  /* jhipster-needle-add-reducer-type - JHipster will add reducer type here */
  readonly loadingBar: any;
}

const rootReducer = combineReducers<IRootState>({
  authentication,
  locale,
  applicationProfile,
  administration,
  userManagement,
  register,
  activate,
  passwordReset,
  password,
  settings,
  post,
  client,
  category,
  product,
  fileManager,
  customer,
  command,
  invoice,
  review,
  artist,
  painting,
  museum,
  tag,
  /* jhipster-needle-add-reducer-combine - JHipster will add reducer here */
  loadingBar
});

export default rootReducer;

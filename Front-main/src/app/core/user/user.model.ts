import { Collection } from "lodash";

export interface IUser {
  id?: any;
  firstName?: string;
  lastName?: string;
  email?: string;
  dateNaiss?: string;
  ine?: string;
  password?: string;
}

export class User implements IUser {
  constructor(
    public id?: any,
    public firstName?: string,
    public lastName?: string,
    public email?: string,
    public dateNaiss?: string,
    public ine?: string,
    public password?: string
  ) {}
}

export class Trainer {
    private cellphone: string;
    private cpf: string;
    private email: string;
    private name: string;
    private surname: string;
    private whatsapp: string;
    private zoomAccount: string;

    constructor(value: any | Trainer = {}) {
        this.cellphone = value.cellphone;
        this.cpf = value.cpf;
        this.email = value.email;
        this.name = value.name;
        this.surname = value.surname;
        this.whatsapp = value.whatsapp;
        this.zoomAccount = value.zoomAccount;
    }
}

const restful  = require('node-restful')
const mongoose = restful.mongoose

const usuarioSchema = new mongoose.Schema({
    usuario: {type: String, required: true},
        senha: {type: String, required: true},
        email: {type: String, required: true},
        status: {type: String},
        perfil: {
            nome: {type: String, required: false},
            apelido: {type: String, required: false},
            categoria: {type: String, required: false},
            sub_categoria: {type: String, required: false},
            telefone: {type: String, required: false},
            descricao: {type: String, required: false},
            site: {type: String, required: false}
        },
        endereco: {
            cep: {type: String, required: false},
            uf: {type: String, required: false},
            logradouro: {type: String, required: false},
            bairro: {type: String, required: false},
            cidade: {type: String, required: false},
            numero: {type: String, required: false}
        }
})
module.exports = restful.model('Usuario', usuarioSchema)
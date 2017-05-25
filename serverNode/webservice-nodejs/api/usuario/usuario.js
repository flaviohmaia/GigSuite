const restful  = require('node-restful')
const mongoose = restful.mongoose

const usuarioSchema = new mongoose.Schema({
    nomeUsuario: {type: String, required: true},
    senha: {type: String, required: true}
})
module.exports = restful.model('Usuario', usuarioSchema)
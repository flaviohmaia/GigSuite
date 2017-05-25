const express = require('express')
const router = express.Router()
const usuarioServico = require('../api/usuario/usuarioServicos.js')

module.exports = function(app) {
    app.use('/api', router)
    usuarioServico.register(router, '/usuario')
}
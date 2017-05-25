const port = 8080

const bodyParser = require('body-parser')
   const express = require('express')
       const app = express()

app.use(bodyParser.urlencoded({extended: true}))
app.use(bodyParser.json())

app.listen(port, function(){
    console.log(`Aplicação rodando em http://localhost:${port}`)
})

module.exports = app
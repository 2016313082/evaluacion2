$(document).ready(function(){
        
        $('#form-login').validate({
            rules:{
                mail:{required: true, email:true, minlength: 8, maxlength: 80}
            },
            messages:{
                mail:{required: 'El campo es requerido', email:'el formato de email es incorrcto', minlength:'El minimo permitido son 8 caracteres', maxlength:'el maximo permitido son 80 caracteres'}
            }
        });
        //http://localhost:8080/evaluacion_1_web-master/login
   
});

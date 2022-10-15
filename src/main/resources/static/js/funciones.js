function traerInformacionCategoria(){
    $.ajax({
        url         :   "http://localhost:8080/api/Category/all",
        type        :   "GET",
        datatype    :   "JSON",
        success:function(respuesta){
                pintarRespuestaCategoria(respuesta);
                }
            });
}

function pintarRespuestaCategoria(items){
    $("#resultado").empty();
    
    let myTable="<table>";
    
    myTable += "<tr> <th>Codigo</th><th>Nombre</th><th>Descripcion</th> </tr>";
   
    for(i = 0; i < items.length; i++){
       
    myTable+="<tr>";
       myTable+="<td>"+ items[i].id + "</td>";
       myTable+="<td>"+ items[i].name + "</td>";
       myTable+="<td>"+ items[i].description + "</td>";
       myTable+="<td><button onclick='borrarInformacionCategoria("+items[i].id+")'>Borrar</button>";
       //myTable+="<td><button onclick='ModificarInformacionCategoria("+items[i].id+")'>Modificar</button>";
    myTable+="</tr>";
   }
   myTable +="</table>";
   $("#resultado").append(myTable);
}

function guardarInformacionCategoria(){
    let myData = {
        id:$("#id").val(),
        name:$("#nombreCategoria").val(),
        description:$("#descripcionCategoria").val(),
    };
    
    let dataToSend = JSON.stringify(myData);

    $.ajax ({
        url          : "http://localhost:8080/api/Category/save",
        type         : "POST",
        data         :  dataToSend,
        datatype     :  "JSON",
        contentType  : 'application/json',
            success      :  function(respuesta){
                $("#resultado").empty();
                
                $("#id").val("");
                $("#nombreCategoria").val("");
                $("#descripcionCategoria").val("");
                traerInformacionCategoria();
                alert("Se guardo exitosamente");
            },
            error       :   function(xhr,status){
                alert('No se guardo datos,'+ xhr.status );
            }           
        });
}

function modificarInformacionCategoria() {
    
    let myData = {
        id:$("#id").val(),
        name:$("#nombreCategoria").val(),
        description:$("#descripcionCategoria").val(),
    };
        
    let dataToSend = JSON.stringify(myData);

    $.ajax (
        {
           url          : "http://localhost:8080/api/Category/update",
           type         : 'PUT',
           data         :  dataToSend,
           datatype     : "JSON",
           contentType  : 'application/json',                    
               success  :  function(respuesta){

                            $("#id").val("");
                            $("#nombreCategoria").val("");
                            $("#descripcionCategoria").val("");
                            traerInformacionCategoria();   
                            alert("Actualizacion exitosa");
                           },
               error    :  function(xhr,status){
                               alert('Operacion no satisfactoria,'+ xhr.status );
                           }
               });
    }


function borrarInformacionCategoria(idElemento) {
    
    let myData = {id:idElemento}
    let dataToSend   = JSON.stringify(myData);

    $.ajax (
        {
            url          : "http://localhost:8080/api/Category/"+ idElemento,
            type         : "DELETE",
            data         :  dataToSend,
            contentType  : 'application/json',
            datatype     :  "JSON",
            success      :  function(respuesta){           
                            traerInformacionCategoria();
                            alert("Se Borro categoria");
                            },
            error       :   function(xhr,status){                                
                                alert('Operacion no satisfactoria,'+ xhr.status );
                            }
        });
}

function consultarId() {
    let codigo = $("#id").val();
    
    $.ajax (
        {
            url          : "http://localhost:8080/api/Category/" + codigo ,
            type         : "GET",
            dataType     : "JSON",
            success      :  function(respuesta){
                            codigo = $("#id").val("");
                            
                            traerInformacionCategoria();   
                            alert('Operacion  satisfactoria')          
                            },
            error        :  function(xhr,status){
                                alert('Operacion no satisfactoria,'+ xhr.status );
                            },
                });
}




//  partyroom
function traerInformacionPartyroom(){
    $.ajax(
              {
                url:"http://localhost:8080/api/Partyroom/all",
                type:"GET",
                datatype:"JSON",
                success:function(respuesta){
                
                pintarRespuestaPartyroom(respuesta); },
    
                error       :   function(xhr,status){
                    alert('Operacion no satisfactoria,'+ xhr.status );
                }      
              });
}

function pintarRespuestaPartyroom(items){

    $("#resultado").empty();
   //declarar variables js
   let myTable="<table>";
   myTable += "<tr><th>Codigo</th><th>Nombre</th> <th> Dueño</th><th>Capacidad</th><th>descripcion</th><th>Codigo Categoria</th><th>Nombre Categoria</th><th>Descripcion Categoria</th> <th>Mensaje</th><th>Reservacion</th></tr>";
   for(i=0; i<items.length; i++){
       myTable+="<tr>";
       myTable+="<td>"+items[i].id+"</td>";
       myTable+="<td>"+items[i].name+"</td>";
       myTable+="<td>"+items[i].owner+"</td>";
       myTable+="<td>"+items[i].capacity+"</td>";
       myTable+="<td>"+items[i].description+"</td>";                
       myTable+="<td>"+items[i].category.id +"</td>";                
       myTable+="<td>"+items[i].category.name +"</td>";                
       myTable+="<td>"+items[i].category.description +"</td>";                
       myTable+="<td>"+items[i].messages +"</td>";                        
       myTable+="<td>"+items[i].reservations+"</td>";                
       // myTable+="<td><button onclick='borrarElemento("+items[i].id+")'>Borrar</button>";
       myTable+="</tr>";
   }
   myTable +="</table>";
   $("#resultado").append(myTable);
}


function guardarInformacionPartyroom(){

    $("#resultado").empty();
    
    let myData ={
        name:$("#nombrePartyroom").val(),
        owner:$("#duenoPartyroom").val(),
        capacity:$("#capacidadPartyroom").val(),
        description:$("#descripcionPartyroom").val(),
        category:{id:$("#idCategoria").val()}
    };
    let dataToSend = JSON.stringify(myData);

    $.ajax (
        {
            url          : 'http://localhost:8080/api/Partyroom/save',
            type         : 'POST',
            data         :  dataToSend,
            datatype     :  "JSON",
            contentType  : 'application/json',
            success      :  function(respuesta){
                            
                            traerInformacionPartyroom();
                            $("#resultado").empty();
                            $("#nombrePartyroom").val("");
                            $("#duenoPartyroom").val("");
                            $("#capacidadPartyroom").val("");
                            $("#descripcionPartyroom").val("");
                            $("#idCategoria").val("");
                            
                            alert("Inserción exitosa");
                            },
            error       :   function(xhr,status){
                                alert('Operacion no satisfactoria,'+ xhr.status );
                            }

        }
    );
}

//Cliente
function guardarInformacionCliente(){

    $("#resultado").empty();

    let myData ={
        name:$("#nombreCliente").val(),
        email:$("#emailCliente").val(),
        password:$("#claveCliente").val(),
        age:$("#edadCliente").val()};
    
    let dataToSend = JSON.stringify(myData);

    $.ajax (
        {
            url          : 'http://localhost:8080/api/Client/save',
            type         : 'POST',
            data         :  dataToSend,
            datatype     :  "JSON",
            contentType  : 'application/json',
            success      :  function(respuesta){
                            traerInformacionCliente();
                            $("#nombreCliente").val("");
                            $("#emailCliente").val("");
                            $("#claveCliente").val("");
                            $("#edadCliente").val("");
                            alert("Se guardo exitosamente el cliente");
                            },
            error       :   function(xhr,status){
                                alert('Operacion no satisfactoria,'+ xhr.status );
                            }
        });
}

function traerInformacionCliente(){
    $.ajax(
              {
                url:"http://localhost:8080/api/Client/all",
                type:"GET",
                datatype:"JSON",
                success:function(respuesta){
                    pintarRespuestaCliente(respuesta);                    
                },
                error       :   function(xhr,status){
                    alert('Operacion no satisfactoria,'+ xhr.status );
                }
             });
}

function pintarRespuestaCliente(items){

    $("#resultado").empty();

   let myTable="<table>";
   myTable += "<tr><th>Codigo</th><th>Correo</th><th>Password</th><th>Nombre</th><th>Edad</th><th>Mensaje</th><th>Reservaciones</th></tr>";
   for(i=0;i<items.length;i++){
       myTable+="<tr>";
       myTable+="<td>"+items[i].idClient+"</td>";
       myTable+="<td>"+items[i].email+"</td>";
       myTable+="<td>"+items[i].password+"</td>";
       myTable+="<td>"+items[i].name+"</td>";
       myTable+="<td>"+items[i].age+"</td>";                
       myTable+="<td>"+items[i].messages+"</td>";                        
       myTable+="<td>"+items[i].reservations+"</td>";                
       // myTable+="<td><button onclick='borrarElemento("+items[i].id+")'>Borrar</button>";
       myTable+="</tr>";
   }
   myTable +="</table>";
   $("#resultado").append(myTable);
}

//mensaje
function guardarInformacionMensaje(){

    $("#resultado").empty();

    let myData ={messageText:$("#mensaje").val(),
                partyroom:{id:$("#idPartyroomM").val()},
                client:{idClient:$("#idClienteM").val()}
            };
    let dataToSend = JSON.stringify(myData);

    $.ajax (
        {
            url          : 'http://localhost:8080/api/Message/save',
            type         : 'POST',
            data         :  dataToSend,
            datatype     :  "JSON",
            contentType  : 'application/json',
            success      :  function(respuesta){

                            $("#mensaje").val(""),
                            $("#idPartyroomM").val(""),
                            $("#idClienteM").val("")
                            traerInformacionMensaje();
                            alert("Inserción exitosa");
                            },
            error       :   function(xhr,status){
                                alert('Operacion no satisfactoria,'+ xhr.status );
                            }

        }
    );
}

function traerInformacionMensaje(){
    $.ajax(
              {
                url:"http://localhost:8080/api/Message/all",
                type:"GET",
                datatype:"JSON",
                success:function(respuesta){
                    pintarRespuestaMensaje(respuesta);                    
                },
                error       :   function(xhr,status){
                    alert('Operacion no satisfactoria,'+ xhr.status );
                }       
              });
}


function pintarRespuestaMensaje(items){

    $("#resultado").empty();

   //declarar variables js
   let myTable="<table>";
   myTable += "<tr><th>Codigo</th><th> Mensaje</th><th>codigo Bicicleta</th><th>Nombre Bicicleta</th><th>Codigo Cliente</th><th>Nombre Cliente</th></tr>";
   for(i=0;i<items.length;i++){
       myTable+="<tr>";
       myTable+="<td>"+items[i].idMessage+"</td>";
       myTable+="<td>"+items[i].messageText+"</td>";
       myTable+="<td>"+items[i].partyroom.id+"</td>";       
       myTable+="<td>"+items[i].partyroom.name+"</td>";
       myTable+="<td>"+items[i].client.idClient+"</td>";
       myTable+="<td>"+items[i].client.name+"</td>";
       
       // myTable+="<td><button onclick='borrarElemento("+items[i].id+")'>Borrar</button>";
       myTable+="</tr>";
   }
   myTable +="</table>";
   $("#resultado").append(myTable);
}

// {"startDate":"2020-12-20","devolutionDate":"2020-12-20",
// "client":{"idClient":1},"bike":{"id":1}}
function guardarInformacionReservacion(){

    $("#resultado").empty();

    let myData ={
                startDate:$("#fechaInicio").val(),
                devolutionDate:$("#fechaFinal").val(),
                client:{idClient:$("#idClienteR").val()},
                partyroom:{id:$("#idPartyroomR").val()}}
    let dataToSend = JSON.stringify(myData);

    $.ajax (
        {
            url          : 'http://localhost:8080/api/Reservation/save',
            type         : 'POST',
            data         :  dataToSend,
            datatype     :  "JSON",
            contentType  : 'application/json',
            success      :  function(respuesta){

                            $("#fechaInicio").val("");
                            $("#fechaFinal").val("");
                            $("#idClienteR").val("");
                            $("#idPartyroomR").val("");
                            traerInformacionReservacion();
                            alert("Inserción exitosa");
                            },
                        
            error       :   function(xhr,status){
                                alert('Operacion no satisfactoria,'+ xhr.status );
                            }

        }
    );
}

function traerInformacionReservacion(){
    $.ajax(
              {
                url:"http://localhost:8080/api/Reservation/all",
                type:"GET",
                datatype:"JSON",
                success:function(respuesta){
                    pintarRespuestaReservacion(respuesta);                    
                },
                error       :   function(xhr,status){
                    alert('Operacion no satisfactoria,'+ xhr.status );
                }    
              });
}


function pintarRespuestaReservacion(items){

    $("#resultado").empty();

   //declarar variables js
   let myTable="<table>";
   myTable += "<tr><th>Codigo Res</th><th> Fecha Inicio</th><th>Fecha final</th><th>Status</th><th>Codigo Partyroom</th><th>Nombre Partyroom</th><th>Codigo Cliente</th><th>Nombre Cliente</th></tr>";
   for(i=0;i<items.length;i++){
       myTable+="<tr>";
       myTable+="<td>"+items[i].idReservation+"</td>";
       myTable+="<td>"+items[i].startDate+"</td>";
       myTable+="<td>"+items[i].devolutionDate+"</td>";
       myTable+="<td>"+items[i].status+"</td>";       
       myTable+="<td>"+items[i].partyroom.id+"</td>";       
       myTable+="<td>"+items[i].partyroom.name+"</td>";
       myTable+="<td>"+items[i].client.idClient+"</td>";
       myTable+="<td>"+items[i].client.name+"</td>";
       
       // myTable+="<td><button onclick='borrarElemento("+items[i].id+")'>Borrar</button>";
       myTable+="</tr>";
   }
   myTable +="</table>";
   $("#resultado").append(myTable);
}


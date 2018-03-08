$(document).ready(function(){
        activaTab('graficoCero');
    });

function activaTab(tab){
	
  $('.nav-tabs a[href="#' + tab + '"]').tab('show');
  
  $('.nav-tabs a[href="#' + tab + '"]').on('shown.bs.tab', function(event){
	  switch (tab) {
	  case 'graficoCero': 
		  drawChart(); 
		  break;
	  case 'graficoUno': 
		  graficar1('grafico1'); 
		  break;
	  case 'graficoDos': 
		  graficar2('grafico2'); 
		  break;
	  case 'graficoTres': 
		  graficar3('grafico3'); 
		  break;
	  case 'graficoCuatro': 
		  graficar4('grafico4'); 
		  break;
	  case 'graficoCinco': 
		  graficar5('grafico5'); 
		  break;
	  case 'graficoSeis': 
		  graficar6('grafico6'); 
		  break;
	  default:
	}
  });
  
};

/*
$(window).resize(function(){
	graficar($('div.active').attr('id'));
});
*/
// Load the Visualization API and the piechart package.
google.load('visualization', '1.0', {'packages':['corechart']});

google.setOnLoadCallback(drawChart);
var datos = 0;
var parametroCero = 0;
var etiquetaCero;
var parametroUno = 0;
var etiquetaUno;
var parametroDos = 0;
var etiquetaDos;
var parametroTres = 0;
var etiquetaTres;
var parametroCuatro = 0;
var etiquetaCuatro;
var parametroCinco = 0;
var etiquetaCinco;
var url = "graficos.json";


function drawChart() {
  var dataJson;

  $.ajax( { 
	  type: 'GET', 
	  contentType : 'application/json',
	  dataType:"json",
	  beforeSend: function(xhr){
		        xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
	  },
	  url:url,
 	  error: function(xhr, error, thrown) {
		 setError(xhr.status, xhr.responseText);
	  },
	  data:{ 
		  "tipoGrafico" : "0", 
		  "parametroCero": null,
		  "parametroUno":null,
		  "parametroDos":null,
		  "parametroTres":null,
		  "parametroCuatro":null,
		  "parametroCinco":null
		  } } )
      .done(function( data, textStatus, jqXHR ) {
          if ( console && console.log ) {
            //console.log( "La solicitud se ha completado correctamente." );
            dataJson = data;
            var datos = new google.visualization.DataTable(dataJson);
            var chart = new google.visualization.PieChart(document.getElementById('grafico0'));
            var options = { 'title':'CONCURSOS PROYECTO',
            				'width':$('#grafico0').width()*0.90,
            				'height':$('#grafico0').width()*0.5,
                            'sliceVisibilityThreshold': 0,
                            'tooltip': { 'trigger': 'selection' }
                          };

              chart.setAction({
                id: 'increase',
                text: 'Detalle',
                action: function() {
                    var selectedItem = chart.getSelection()[0];
                    if (selectedItem) {                      
                    	parametroCero = datos.getValue(selectedItem.row, 0);
                    	etiquetaCero = datos.getFormattedValue(selectedItem.row, 0);
	                    $('grafico0').empty();
	                    activaTab('graficoUno');
                    }
                }
              });
             chart.draw(datos, options);
        }
      })
      .fail(function( jqXHR, textStatus, errorThrown ) {
          if ( console && console.log ) {
              console.log( "Algo ha fallado: "  +errorThrown );
          }
  });
  }

function graficar1(grafico) {
	  var dataJson;

	  $.ajax( { 
		  type: 'GET', 
		  contentType : 'application/json',
		  dataType:"json",
		  url:url,
		  beforeSend: function(xhr){
		        xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
		  },
		  error: function(xhr, error, thrown) {
				 setError(xhr.status, xhr.responseText);
		  },
		  data:{ 
			  "tipoGrafico" : "1", 
			  "parametroCero": parametroCero,
			  "parametroUno":null,
			  "parametroDos":null,
			  "parametroTres":null,
			  "parametroCuatro":null,
			  "parametroCinco":null
			  } } )
	      .done(function( data, textStatus, jqXHR ) {
	          if ( console && console.log ) {
	            //console.log( "La solicitud se ha completado correctamente." );
	            dataJson = data;
	            var datos = new google.visualization.DataTable(dataJson);
	            var chart = new google.visualization.PieChart(document.getElementById('grafico1'));
	            var options = { 'title':etiquetaCero,
	            				'width':$('#grafico1').width()*0.90,
	            				'height':$('#grafico1').width()*0.5,
	                            'sliceVisibilityThreshold': 0,
	                            'tooltip': { 'trigger': 'selection' }
	                          };

	              chart.setAction({
	                id: 'increase',
	                text: 'Detalle',
	                action: function() {
	                      var selectedItem = chart.getSelection()[0];
	                    if (selectedItem) {                      
	                    	parametroUno = datos.getValue(selectedItem.row, 0);
	                    	etiquetaUno = datos.getFormattedValue(selectedItem.row, 0);
		                    $('grafico2').empty();
		                    $('#leyenda_dos').text(etiquetaUno);
		                    activaTab('graficoDos');
	                    }
	                }
	              });
	             chart.draw(datos, options);
	        }
	      })
	      .fail(function( jqXHR, textStatus, errorThrown ) {
	          if ( console && console.log ) {
	              console.log( "Algo ha fallado: "  +errorThrown );
	          }
	  });
  }

  function graficar2(grafico) {

  var dataJson;
  
  $.ajax( { 
	  type: 'GET', 
	  contentType : 'application/json',
	  dataType:"json",
	  beforeSend: function(xhr){
	        xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
	  },
	  url:url,
	  error: function(xhr, error, thrown) {
			 setError(xhr.status, xhr.responseText);
		  },
	  data:{ 
	 "tipoGrafico" : "2", 
	 "parametroCero":parametroCero,
	 "parametroUno":parametroUno,
	 "parametroDos":null,
	 "parametroTres":null,
	 "parametroCuatro":null,
	 "parametroCinco":null} } )
      .done(function( data, textStatus, jqXHR ) {
          if ( console && console.log ) {
            //console.log( "La solicitud se ha completado correctamente." );
            dataJson = data;
            var datos = new google.visualization.DataTable(dataJson);
            var titulo = etiquetaUno;
            var chart = new google.visualization.PieChart(document.getElementById('grafico2'));
            var options = { 'title':titulo,
		            		'width':$('#grafico2').width()*0.9,
		    				'height':$('#grafico2').width()*0.5,
		                    'sliceVisibilityThreshold': 0,
		                    'tooltip': { 'trigger': 'selection' }
		                  };
                if(parametroUno == 2){

                                chart.setAction({
                id: 'increase',
                text: 'No se puede profundizar',
                action: function() {}
              });
                }
                else{
              chart.setAction({
                id: 'increase',
                text: 'Detalle',
                action: function() {
                      var selectedItem = chart.getSelection()[0];
                    if (selectedItem) {
                      $('grafico3').empty();
                       parametroDos = datos.getValue(selectedItem.row, 0);
                       etiquetaDos = datos.getFormattedValue(selectedItem.row, 0);
                      activaTab('graficoTres');
                    }
                }
              });
            }
            // $("text:contains(" + options.title + ")").attr({'x':'60', 'y':'20'})
             chart.draw(datos, options);

        }
      })
      .fail(function( jqXHR, textStatus, errorThrown ) {
          if ( console && console.log ) {
              console.log( "Algo ha fallado: "  +errorThrown );
          }
  });
  }

function graficar3(grafico) {
	var dataJson;

	$.ajax( { 
	  type: 'GET', 
	  contentType : 'application/json',
	  dataType:"json",
	  beforeSend: function(xhr){
	        xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
	  },
	  url:url, 
	  error: function(xhr, error, thrown) {
			 setError(xhr.status, xhr.responseText);
		  },
	  data:{ 
	  "tipoGrafico" : "3", 
	  "parametroCero": parametroCero,
	  "parametroUno":parametroUno,
	  "parametroDos":parametroDos, 
	  "parametroTres":null,
	  "parametroCuatro":null,
	  "parametroCinco":null } } )
	  .done(function( data, textStatus, jqXHR ) {
          if ( console && console.log ) {
    
              dataJson = data;
              var datos = new google.visualization.DataTable(dataJson);
              var titulo = decodeURIComponent(etiquetaUno + " - " + etiquetaDos);
              var options = { 'title':titulo,'width':1024,
            		  		  'width':$('#grafico3').width()*0.9,
      						  'height':$('#grafico3').width()*0.5,
		                      'sliceVisibilityThreshold': 0,
		                      'tooltip': { 'trigger': 'selection' }
		                    };
              var chart = new google.visualization.PieChart(document.getElementById(grafico));
              var a = 0;
              
              function selectHandler() {
   
            	  var selectedItem = chart.getSelection()[0];
            	  if (selectedItem) {
            		  var value = datos.getValue(selectedItem.row, 0);
            		  if(value == 1){
            			  chart.removeAction('increase');
            			  chart.setAction({
            				  id: 'increase',
            				  text: 'Detalle',
            				  action: function() {
            					  var selectedItem = chart.getSelection()[0];
            					  if (selectedItem) {
            						  $('grafico4').empty();
            						  parametroTres = datos.getValue(selectedItem.row, 0);
            						  etiquetaTres = datos.getFormattedValue(selectedItem.row, 0);
            						  activaTab('graficoCuatro');
            					  }
                   
            				  }
            			  });
            			  chart.draw(datos, options);
            			  chart.setSelection([{row:selectedItem.row,column:null}]);
            		  }
            		  else{
            			  chart.removeAction('increase');
            			  chart.setAction({
            				  id: 'increase',
            				  text: 'No es posible detallar mas',
            			  });
            			  chart.draw(datos, options);
            			  chart.setSelection([{row:selectedItem.row,column:null}]);
            		  }
            	  }
              }

              google.visualization.events.addListener(chart, 'select', selectHandler);
              chart.draw(datos, options);
            //  $("text:contains(" + options.title + ")").attr({'x':'60', 'y':'20'})
          } 
	  })
      .fail(function( jqXHR, textStatus, errorThrown ) {
    	  if ( console && console.log ) {
              console.log( "Algo ha fallado: "  +errorThrown );
          }
      });
}

function graficar4(grafico) {

  var dataJson;

  $.ajax( { 
	  type: 'GET', 
	  contentType : 'application/json',
	  dataType:"json",
	  beforeSend: function(xhr){
	        xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
	  },
	  url:url, 
	  error: function(xhr, error, thrown) {
			 setError(xhr.status, xhr.responseText);
		  },
	  data:{
	  "tipoGrafico" : "4", 
	  "parametroCero": parametroCero,
	  "parametroUno":parametroUno,
	  "parametroDos":parametroDos,
	  "parametroTres":parametroTres,
	  "parametroCuatro":null,
	  "parametroCinco":null } } )
 
      .done(function( data, textStatus, jqXHR ) {
          if ( console && console.log ) {

              dataJson = data;
              var datos = new google.visualization.DataTable(dataJson);

              var titulo = etiquetaUno + " - " + etiquetaDos + " - " + etiquetaTres;
              var options = { 'title':titulo,'width':1024,
		            		  'width':$('#grafico4').width()*0.9,
		      				  'height':$('#grafico4').width()*0.5,
		                      'sliceVisibilityThreshold': 0,
		                      'tooltip': { 'trigger': 'selection' }
		                    };
              var chart = new google.visualization.PieChart(document.getElementById(grafico));
              chart.setAction({
                id: 'increase',
                text: 'Detalle',
                action: function() {
                      var selectedItem = chart.getSelection()[0];
                    if (selectedItem) {
                      $('grafico5').empty();
                      parametroCuatro = datos.getValue(selectedItem.row, 0);
                      etiquetaCuatro = datos.getFormattedValue(selectedItem.row, 0);
                      activaTab('graficoCinco');
                    }
                }
              });
                
                  chart.draw(datos, options);
           //     $("text:contains(" + options.title + ")").attr({'x':'60', 'y':'20'})

                 }
                
               })
      .fail(function( jqXHR, textStatus, errorThrown ) {
          if ( console && console.log ) {
              console.log( "Algo ha fallado: "  +errorThrown );
          }
  });
}
function graficar5(grafico) {

  var dataJson;

  $.ajax( { 
	  type: 'GET', 
	  contentType : 'application/json',
	  dataType:"json",
	  beforeSend: function(xhr){
	        xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
	  },
	  url:url, 
	  error: function(xhr, error, thrown) {
			 setError(xhr.status, xhr.responseText);
		  },
	  data:{
	  "tipoGrafico" : "5", 
	  "parametroCero": parametroCero,
	  "parametroUno":parametroUno,
	  "parametroDos":parametroDos,
	  "parametroTres":parametroTres,
	  "parametroCuatro":parametroCuatro ,
	  "parametroCinco":null} } )
      .done(function( data, textStatus, jqXHR ) {
          if ( console && console.log ) {

              dataJson = data;
              
              var datos = new google.visualization.DataTable(dataJson);
              var titulo = etiquetaUno + " - " + etiquetaDos + " - " + etiquetaTres + " - " + etiquetaCuatro;
              var options = { 'title':titulo,'width':1024,
            		  		  'width':$('#grafico5').width()*0.9,
            		  		  'height':$('#grafico5').width()*0.5,
		                      'sliceVisibilityThreshold': 0,
		                      'tooltip': { 'trigger': 'selection' }
		                    };
              var chart = new google.visualization.PieChart(document.getElementById(grafico));
              chart.setAction({
                id: 'increase',
                text: 'Detalle',
                action: function() {
                      var selectedItem = chart.getSelection()[0];
                    if (selectedItem) {
                      $('grafico6').empty();
                      parametroCinco = datos.getValue(selectedItem.row, 0);
                      etiquetaCinco = datos.getFormattedValue(selectedItem.row, 0);
                      activaTab('graficoSeis');
                    }
                }
              });
                  chart.draw(datos, options);
                $("text:contains(" + options.title + ")").attr({'x':'30'})

                 }
               })
      .fail(function( jqXHR, textStatus, errorThrown ) {
          if ( console && console.log ) {
              console.log( "Algo ha fallado: "  +errorThrown );
          }
  });
}
function graficar6(grafico) {

  var dataJson;

  $.ajax( { 
	  type: 'GET', 
	  contentType : 'application/json',
	  dataType:"json",
	  beforeSend: function(xhr){
	        xhr.setRequestHeader($("meta[name='_csrf_header']").attr("content"), $("meta[name='_csrf']").attr("content"));
	  },
	  url:url, 
	  error: function(xhr, error, thrown) {
			 setError(xhr.status, xhr.responseText);
		  },
	  data:{
	  "tipoGrafico" : "6", 
	  "parametroCero": parametroCero,
	  "parametroUno":parametroUno,
	  "parametroDos":parametroDos,
	  "parametroTres":parametroTres,
	  "parametroCuatro":parametroCuatro,
	  "parametroCinco":parametroCinco } } )
      .done(function( data, textStatus, jqXHR ) {
          if ( console && console.log ) {

              dataJson = data;
              
              var datos = new google.visualization.DataTable(dataJson);
              var titulo = etiquetaUno + " - " + etiquetaDos + " - " + etiquetaTres + " - " + etiquetaCuatro + " - " + etiquetaCinco;
              var options = { 'title':titulo,
            		  		  'width':$('#grafico6').width()*0.9,
      						  'height':$('#grafico6').width()*0.5,
		                      'sliceVisibilityThreshold': 0,
		                      'tooltip': { 'trigger': 'selection' }
		                    };
              var chart = new google.visualization.PieChart(document.getElementById(grafico));
              chart.setAction({
                id: 'increase',
                text: 'No es posible detallar mas',
                action: function() {
                    
                }
              });
                  // Instantiate and draw our chart, passing in some options.

                  chart.draw(datos, options);
                $("text:contains(" + options.title + ")").attr({'x':'10'})

                 }
               })
      .fail(function( jqXHR, textStatus, errorThrown ) {
          if ( console && console.log ) {
              console.log( "Algo ha fallado: "  +errorThrown );
          }
  });
}




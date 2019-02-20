
function getPath() {
	var url = window.location.protocol+"//"+window.location.host;
	var path = "/"+window.location.pathname.split("/")[1];
	var existeUrl;
	try {
		var http = new XMLHttpRequest();
		http.open('HEAD', url+path, false);
		http.send();
		if (http.status==200) {
			existeUrl = true;
		} else {
			existeUrl = false;
		}
	}catch(e) {
		existeUrl = false;
	}
	if (!existeUrl) {
		path = "";
	} 
	return url+path;
}

var table;								
var idTable;							
var columns;							
var data;								
var serverSide;							
var type;								
var info;								
var length;								
var filterSearch;						
var select;								
var buttons;							
var parameters;							

var sizeRow = 35; 						
var responsive = true;					
var scrollX = true;						
$.fn.dataTable.ext.errMode = 'none';	


function DataTable(idTable,columns,data,serverSide,type,info,length,filterSearch,select,buttons,parameters) {
	var data = getPath()+"/"+data;
	if (serverSide) data += "?tb="+idTable;
	if (filterSearch == null) filterSearch = 'none';
	if (select == null) select = 'none';
	if (buttons == null) buttons = [];
	if (parameters == null) parameters = [];
	if (filterSearch == 'all' || filterSearch == 'columns') responsive = false;
	
	this.idTable = idTable;
	this.columns = columns;
	this.data = data;
	this.serverSide = serverSide;
	this.type = type;
	this.info = info;
	this.length = length;
	this.filterSearch = filterSearch;
	this.select = select;
	this.buttons = buttons;
	this.parameters = parameters;
	
	createTableHTML();
	createDataTable();
	posCssDataTable();
	
	return table;
}


function createDataTable() {
    if (serverSide) {
        if (type == 'scroll') {
        	table = $('#'+idTable).DataTable( {
        		dom: typeDom(),
        		responsive: responsive,
        		processing: serverSide,
        		serverSide: serverSide,
        		sAjaxSource: data,
        	    fnServerParams: function (aoData) {
        	    	for (var i=0; i<parameters.length; i++) {
        	    		aoData.push(parameters[i]);
					}
        	    },
        		initComplete: function() {
                    var api = this.api();
                    api.columns().every(function() {
                        var column = this;
                        $('input', this.footer()).on('keyup change', function() {
                            if (column.search() !== this.value) {
                            	column.search(this.value).draw();
                            }
                        });
                    });
                },
        		aoColumns: createColumns(),
        		aaSorting: defOrder(),
        		select: typeSelect(),
        		buttons: createButtons(),
        		language: language(),
                scrollY: length*sizeRow,
                scrollX: scrollX,
                scroller: {
                    loadingIndicator: true
                }
        	});
        }else if (type == 'fixed') {
        	table = $('#'+idTable).DataTable( {
        		dom: typeDom(),
        		lengthMenu: [[5, 10, 25, 50, 100, -1], [5, 10, 25, 50, 100, 'Todos']],
        		pageLength: length,
        		responsive: responsive,
        		processing: serverSide,
        		serverSide: serverSide,
        		sAjaxSource: data,
        	    fnServerParams: function (aoData) {
        	    	for (var i=0; i<parameters.length; i++) {
        	    		aoData.push(parameters[i]);
					}
        	    },
        		initComplete: function() {
                    var api = this.api();
                    api.columns().every(function() {
                        var column = this;
                        $('input', this.footer()).on('keyup change', function() {
                            if (column.search() !== this.value) {
                            	column.search(this.value).draw();
                            }
                        });
                    });
                },
        		aoColumns: createColumns(),
        		aaSorting: defOrder(),
        		select: typeSelect(),
        		buttons: createButtons(),
        		language: language(),
                scrollX: scrollX
        	});
        }
    }else {
    	if (type == 'scroll') {
    		table = $('#'+idTable).DataTable( {
        		dom: typeDom(),
        		responsive: responsive,
        		processing: serverSide,
        		serverSide: serverSide,
        		ajax: data,
        		initComplete: function() {
                    var api = this.api();
                    api.columns().every(function() {
                        var column = this;
                        $('input', this.footer()).on('keyup change', function() {
                            if (column.search() !== this.value) {
                            	column.search(this.value).draw();
                            }
                        });
                    });
                },
        		aoColumns: createColumns(),
        		aaSorting: defOrder(),
        		select: typeSelect(),
        		buttons: createButtons(),
        		language: language(),
        		scrollY: length*sizeRow,
                scrollX: scrollX,
                scroller: {
                    loadingIndicator: true
                }
        	});
        }else if (type == 'fixed') {
        	table = $('#'+idTable).DataTable( {
        		dom: typeDom(),
        		lengthMenu: [[5, 10, 25, 50, 100, -1], [5, 10, 25, 50, 100, 'Todos']],
        		pageLength: length,
        		responsive: responsive,
        		processing: serverSide,
        		serverSide: serverSide,
        		ajax: data,
        		initComplete: function() {
                    var api = this.api();
                    api.columns().every(function() {
                        var column = this;
                        $('input', this.footer()).on('keyup change', function() {
                            if (column.search() !== this.value) {
                            	column.search(this.value).draw();
                            }
                        });
                    });
                },
        		aoColumns: createColumns(),
        		aaSorting: defOrder(),
        		select: typeSelect(),
        		buttons: createButtons(),
        		language: language(),
                scrollX: scrollX
        	});
        }
    }
}


function posCssDataTable() {
	setTimeout(function(){ 
		// Oculta el texto de filas seleccionadas si la tabla es tipo select none
		var selectItem = document.getElementsByClassName("select-item");
		for (var i=0; i<selectItem.length; i++) {
			if (select == 'none') {
				selectItem[i].style.display = "none";
			}
		}
	}, 500);
}


function createTableHTML() {
    var tablaHTML = document.getElementById(idTable);
    tablaHTML.setAttribute("cellspacing", "0");
    tablaHTML.setAttribute("width", "100%");
    var thead = document.createElement("thead");
    var trh = document.createElement("tr");
    tablaHTML.appendChild(thead);
    thead.appendChild(trh);
    columns.forEach(function(item, index){
        var th = document.createElement("th");
        item = item.split(":defOrder")[0];
        th.innerHTML = item.toUpperCase();
        trh.appendChild(th);
    });

    if (filterSearch == 'columns' || filterSearch == 'all') {
        var tfoot = document.createElement("tfoot");
        var trf = document.createElement("tr");
        tablaHTML.appendChild(tfoot);
        tfoot.appendChild(trf);
        columns.forEach(function(item, index){
            var th = document.createElement("th");
            item = item.split(":defOrder")[0];
            th.innerHTML = item.toUpperCase();
            trf.appendChild(th);
        });
        
        var i = 0;
    	$('#'+idTable+' tfoot th').each(function () {
    		var title = $(this).text();
    		$(this).html('<input type="text" id="fcol_'+(i++)+'" class="form-control input-sm dt-search" placeholder="'+title+'" title="Filtrar por '+title.toLowerCase()+'" />');
    	} );
    }
}


function language() {
	var lang = {
		sProcessing: 		"Procesando...",
    	sLengthMenu: 		"Mostrar _MENU_ registros",
    	sZeroRecords:   	"No se encontraron resultados",
    	sEmptyTable:    	"Ningún dato disponible en esta tabla",
    	sInfo:          	"Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
    	sInfoEmpty:     	"Mostrando registros del 0 al 0 de un total de 0 registros",
    	sInfoFiltered:  	"(filtrado de un total de _MAX_ registros)",
    	sInfoPostFix:   	"",
    	sSearch:        	"Buscar:",
    	sUrl:           	"",
    	sInfoThousands: 	",",
    	sLoadingRecords:	"Cargando...",
    	oPaginate: {
    		sFirst:    		"Primero",
    		sLast:     		"Último",
    		sNext:     		"Siguiente",
    		sPrevious: 		"Anterior"
    	},
    	oAria: {
    		sSortAscending: ": Activar para ordenar la columna de manera ascendente",
    		sSortDescending:": Activar para ordenar la columna de manera descendente"
    	},
        select: {
            rows: {
                _: 			"Seleccionadas %d filas",
                1: 			"Seleccionada 1 fila"
            }
        },
        buttons: {
            copyTitle: 'Copiado en el porta papeles',
            copySuccess: {
                _: '%d filas copiadas',
                1: '1 fila copiada'
            }
        }
	};
	return lang;
}


function typeSelect() {
	var type = false;
    if (select != 'none') {
    	if (select == 'select') {
    		type = true;
        } else if (select == 'multi-select') {
        	type = {
    	    	style: 'multi'
    	    }
        }
    } 
	return type;
}


function typeDom() {
	var dom = '';
    if (buttons.length > 0) {
    	dom += 'B';
    }
    if (filterSearch == 'global' || filterSearch == 'all') {
    	dom += 'f';
    }
    if (type == 'fixed') {
    	dom += 'rtlp';
    } else if(type == 'scroll') {
    	dom += 'rtp';
    }
    if (info) {
    	dom += 'i';
    }
	return dom;
}


function createColumns() {
    var columnsTemp = [];
    columns.forEach(function(item, index){
    	item = item.split(":defOrder")[0];
        columnsTemp.push({sName: item});
    });
    return columnsTemp;
}


function defOrder() {
    var order = [];
    var orderColumn = [];
    columns.forEach(function(item, index){
    	var orderTemp = item.split(":defOrder");
    	if (orderTemp.length > 1) {
    		orderColumn = [index, orderTemp[1]];
    		order.push(orderColumn);
    	}
    });
    if (order.length == 0) {
    	orderColumn = ["0", "asc"];
		order.push(orderColumn);
    }
    return order;
}


function createButtons() {
    var buttonsTemp = [];
    buttons.forEach(function(item, index){
        if(item['type'] === "simple") {
            buttonsTemp.push({text: item['name'], action: item['action'], titleAttr: item['name'], className: "btn-dt btn-dt-"+item['name']});
        }
        if(item['type'] === "select") {
            buttonsTemp.push({extend: "selectedSingle", text: item['name'], titleAttr: item['name'], action: item['action'], className: "btn-dt btn-dt-"+item['name']});
        }
        if(item['type'] === "multi-select") {
            buttonsTemp.push({extend: "selected", text: item['name'], titleAttr: item['name'], action: item['action'], className: "btn-dt btn-dt-"+item['name']});
        }
        if(item['type'] === "export") {
        	if (item['messageTop'] != null && item['messageBottom'] != null) {
        		if (item['exportColumns'] != null) {
    	        	buttonsTemp.push({extend: 'collection', text: 'Exportar', titleAttr: 'Exportar', className: "btn-dt btn-dt-Exportar",
    	                buttons: [
    	                    { extend: 'copy', text: 'Copiar', title: item['nameField'], className: "li-dt btn-dt-copy", exportOptions: {columns: item['exportColumns']}},
    	                    { extend: 'csv', text: 'CSV', title: item['nameField'], className: "li-dt btn-dt-csv", exportOptions: {columns: item['exportColumns']}},
    	                    { extend: 'excel', text: 'Excel', title: item['nameField'], className: "li-dt btn-dt-excel", exportOptions: {columns: item['exportColumns']}},
    	                    { extend: 'pdf', text: 'PDF', title: item['nameField'], className: "li-dt btn-dt-pdf", 
    	                    	messageTop: item['messageTop'], messageBottom: '\n'+item['messageBottom'], 
    	                    	orientation: item['orientation'], pageSize: item['pageSize'], 
    	                    	exportOptions: {columns: item['exportColumns']},
    	                    	customize: item['exportCustomize'] 
    	        		    },
    	                    { extend: 'print', text: 'Imprimir', title: item['nameField'], className: "li-dt btn-dt-print", 
    	        		    	messageTop: item['messageTop'], messageBottom: '\n'+item['messageBottom'], 
    	                    	exportOptions: {columns: item['exportColumns']}
    	    			    }
    	                ]
    	            });
            	} else {
            		buttonsTemp.push({extend: 'collection', text: 'Exportar', titleAttr: 'Exportar', className: "btn-dt btn-dt-Exportar",
                        buttons: [
                            { extend: 'copy', text: 'Copiar', title: item['nameField'], className: "li-dt btn-dt-copy"},
                            { extend: 'csv', text: 'CSV', title: item['nameField'], className: "li-dt btn-dt-csv"},
                            { extend: 'excel', text: 'Excel', title: item['nameField'], className: "li-dt btn-dt-excel"},
                            { extend: 'pdf', text: 'PDF', title: item['nameField'], className: "li-dt btn-dt-pdf", 
                            	messageTop: item['messageTop'], messageBottom: '\n'+item['messageBottom'], 
                            	orientation: item['orientation'], pageSize: item['pageSize'],
    	                    	customize: item['exportCustomize'] 
                		    },
                            { extend: 'print', text: 'Imprimir', title: item['nameField'], className: "li-dt btn-dt-print", 
                		    	messageTop: item['messageTop'], messageBottom: '\n'+item['messageBottom']
            			    }
                        ]
                    });
            	}
        	} else {
        		if (item['exportColumns'] != null) {
    	        	buttonsTemp.push({extend: 'collection', text: 'Exportar', titleAttr: 'Exportar', className: "btn-dt btn-dt-Exportar",
    	                buttons: [
    	                    { extend: 'copy', text: 'Copiar', title: item['nameField'], className: "li-dt btn-dt-copy", exportOptions: {columns: item['exportColumns']}},
    	                    { extend: 'csv', text: 'CSV', title: item['nameField'], className: "li-dt btn-dt-csv", exportOptions: {columns: item['exportColumns']}},
    	                    { extend: 'excel', text: 'Excel', title: item['nameField'], className: "li-dt btn-dt-excel", exportOptions: {columns: item['exportColumns']}},
    	                    { extend: 'pdf', text: 'PDF', title: item['nameField'], className: "li-dt btn-dt-pdf", 
    	                    	orientation: item['orientation'], pageSize: item['pageSize'], 
    	                    	exportOptions: {columns: item['exportColumns']},
    	                    	customize: item['exportCustomize'] 
    	        		    },
    	                    { extend: 'print', text: 'Imprimir', title: item['nameField'], className: "li-dt btn-dt-print", 
    	                    	exportOptions: {columns: item['exportColumns']}
    	    			    }
    	                ]
    	            });
            	} else {
            		buttonsTemp.push({extend: 'collection', text: 'Exportar', titleAttr: 'Exportar', className: "btn-dt btn-dt-Exportar",
                        buttons: [
                            { extend: 'copy', text: 'Copiar', title: item['nameField'], className: "li-dt btn-dt-copy"},
                            { extend: 'csv', text: 'CSV', title: item['nameField'], className: "li-dt btn-dt-csv"},
                            { extend: 'excel', text: 'Excel', title: item['nameField'], className: "li-dt btn-dt-excel"},
                            { extend: 'pdf', text: 'PDF', title: item['nameField'], className: "li-dt btn-dt-pdf", 
                            	orientation: item['orientation'], pageSize: item['pageSize'],
    	                    	customize: item['exportCustomize'] 
                		    },
                            { extend: 'print', text: 'Imprimir', title: item['nameField'], className: "li-dt btn-dt-print"}
                        ]
                    });
            	}
        	}
        }
    });
    
    if (filterSearch != 'none') {
    	var actionRefresh = function(){
    		$("#"+idTable).DataTable().columns().every(function() {
                $('input', this.footer()).val('').change();
            });
    		$("#"+idTable).DataTable().search('').draw();
    	};
        buttonsTemp.push({text: '', action: actionRefresh, titleAttr: 'Refrescar', className: "btn-dt btn-dt-Refresh"});
    }
    
    return buttonsTemp;
}


function deleteRow(r) {
	  var i = r.parentNode.parentNode.rowIndex;
	  document.getElementById("feetbl1").deleteRow(i);
	}

function deafaultDate() {
	  var date = document.getElementById("tbl1");
	  document.getElementById("tbl1").deleteRow(i);
	}
function calDiscount(r){
	 var input, discount=0, totalFee,netpayable;
	 var i = r.parentNode.parentNode.rowIndex;
	 totalFee = document.getElementById("tbl1").rows[i].cells[1].innerHTML;
	 //alert(document.getElementById("tbl1").rows[1].cells[1].innerHTML)
	 input = document.getElementById("tbl1").rows[i].cells[4].children[0].value;
	  if(input>0){
		  discount = input*totalFee*'0.01';
		  
	  }
	  netpayable = totalFee-discount;
	  document.getElementById("tbl1").rows[i].cells[2].innerHTML  = netpayable;
	  
	  var table = document.getElementById("tbl1");
	  var totNetpayable=0,tot_paid=0,discount=0, tot_amt =0;
	  var lastRow = table.rows.length-1;
	  if(table){
			for (var i = 1, row; row = table.rows[i]; i++) {
				if(lastRow > i){
					totNetpayable = totNetpayable + parseFloat(table.rows[i].cells[2].innerHTML);
				}
			}
		}
	 
	  table.rows[lastRow].cells[2].innerHTML  = totNetpayable;
}

window.onload = function(){
	var netpayable=0,tot_paid=0,discount=0, tot_amt =0;
	var table = document.getElementById("myTble");
	var pendTable = document.getElementById("tbl1");
	if(table){
		for (var i = 1, row; row = table.rows[i]; i++) {
			/*netpayable = document.getElementById("tbl1").rows[i].cells[2].innerHTML;
			tot_paid = document.getElementById("tbl1").rows[i].cells[3].children[0].value;
			discount = document.getElementById("tbl1").rows[i].cells[4].children[0].value;
			
			if(netpayable<=tot_paid){
				document.getElementById("tbl1").rows[i].bgColor="#ccc";
				document.getElementById("tbl1").rows[i].cells[3].innerHTML=tot_paid;
				document.getElementById("tbl1").rows[i].cells[4].innerHTML=discount;
			}*/
			
			tot_paid = tot_paid + parseFloat(table.rows[i].cells[3].innerHTML);
			tot_amt = tot_amt + parseFloat(table.rows[i].cells[1].innerHTML);
			netpayable = netpayable + parseFloat(table.rows[i].cells[2].innerHTML);
		}
		var lastRow = table.rows.length-1;
		table.rows[lastRow].cells[1].innerHTML= tot_amt;
		table.rows[lastRow].cells[2].innerHTML= netpayable;
		table.rows[lastRow].cells[3].innerHTML= tot_paid;
	}
	
	if(pendTable){
		var pend_netpayable=0,pend_tot_paid=0,pend_discount=0, pend_tot_amt =0;
		for (var i = 1, row; row = pendTable.rows[i]; i++) {
			//pend_tot_paid = pend_tot_paid + parseFloat(pendTable.rows[i].cells[3].children[0].value);
			if(!isNaN(parseFloat(pendTable.rows[i].cells[1].innerHTML))){
				pend_tot_amt = pend_tot_amt + parseFloat(pendTable.rows[i].cells[1].innerHTML);
			}
			
			if(!isNaN(parseFloat(pendTable.rows[i].cells[2].innerHTML))){
				pend_netpayable = pend_netpayable + parseFloat(pendTable.rows[i].cells[2].innerHTML);
			}
			
		}
		var lastRow = pendTable.rows.length-1;
		pendTable.rows[lastRow].cells[1].innerHTML= pend_tot_amt;
		pendTable.rows[lastRow].cells[2].innerHTML= pend_netpayable;
		//pendTable.rows[lastRow].cells[3].innerHTML= pend_tot_paid;
	}
	
}
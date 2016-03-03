function countAmount() {
var totalCashAmount = 0;
var products=document.querySelector('table.basket tbody').childNodes;
for (var i=1; i<products.length; i++) {
  console.log(products[1].innerHTML);
  var amount = products[i].querySelector('input[type="number"]').value;
  var price = products[i].querySelector('span.price').innerHTML;
  totalCashAmount += (amount*price);
}
alert(totalCashAmount);
return totalCashAmount;
}
document.querySelector('h1').addEventListener("click",countAmount);

End of third
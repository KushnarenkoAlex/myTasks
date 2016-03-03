function showBasketCounter() {
  var basketCounter = localStorage.getItem('basketCounter') || 0;
  var headerBasketCounter = document.querySelector("span#basketCounter");
  headerBasketCounter.innerHTML = basketCounter;
  return false;
}
document.addEventListener("DOMContentLoaded",showBasketCounter);

End of second
var searchIcon=document.getElementById('searchIcon');var searchField=document.getElementById('searchField');var searchArea=document.getElementById('search');var searchForm=document.getElementById('searchForm');var width=(self.innerWidth||(document.documentElement&&document.documentElement.clientWidth)||document.body.clientWidth);searchArea.onmouseover=function(){if(width<=466){var spaceBelow=document.getElementById("spaceBelow");spaceBelow.parentNode.insertBefore(searchArea,spaceBelow.nextSibling);searchArea.style.marginBottom="20px";searchArea.style.width="100%";searchField.style.width="100%";searchIcon.style.marginLeft="-40px";searchForm.style.width="100%";}searchField.style.display="inline-block";searchIcon.src="images/search.png";}if(width>=466){searchArea.onmouseout=function(){searchIcon.src="images/searchWhite.png";searchField.style.display="none";}}if(width<=466){document.addEventListener("DOMContentLoaded",function(){var allElements=document.getElementsByTagName("*");for(var i=0;i<allElements.length;i++){allElements[i].addEventListener("click",function(){if(this.id==="searchField")event.stopImmediatePropagation();},false);};document.addEventListener("click",function(){searchIcon.src="images/searchWhite.png";searchField.style.display="none";userSide.insertBefore(searchArea,userSide.childNodes[1]);searchArea.style.marginBottom="0px";searchArea.style.width="";searchField.style.width="";searchIcon.style.marginLeft="0px";document.getElementById('searchForm').style.width="";},false);});}EndoffirstfunctionshowBasketCounter(){var basketCounter=localStorage.getItem('basketCounter')||0;var headerBasketCounter=document.querySelector("span#basketCounter");headerBasketCounter.innerHTML=basketCounter;return false;}document.addEventListener("DOMContentLoaded",showBasketCounter);EndofsecondfunctioncountAmount(){var totalCashAmount=0;var products=document.querySelector('table.baskettbody').childNodes;for(var i=1;i<products.length;i++){console.log(products[1].innerHTML);var amount=products[i].querySelector('input[type="number"]').value;var price=products[i].querySelector('span.price').innerHTML;totalCashAmount+=(amount*price);}alert(totalCashAmount);return totalCashAmount;}document.querySelector('h1').addEventListener("click",countAmount);Endofthirdvar searchIcon=document.getElementById('searchIcon');var searchField=document.getElementById('searchField');var searchArea=document.getElementById('search');var searchForm=document.getElementById('searchForm');var width=(self.innerWidth||(document.documentElement&&document.documentElement.clientWidth)||document.body.clientWidth);searchArea.onmouseover=function(){if(width<=466){var spaceBelow=document.getElementById("spaceBelow");spaceBelow.parentNode.insertBefore(searchArea,spaceBelow.nextSibling);searchArea.style.marginBottom="20px";searchArea.style.width="100%";searchField.style.width="100%";searchIcon.style.marginLeft="-40px";searchForm.style.width="100%";}searchField.style.display="inline-block";searchIcon.src="images/search.png";}if(width>=466){searchArea.onmouseout=function(){searchIcon.src="images/searchWhite.png";searchField.style.display="none";}}if(width<=466){document.addEventListener("DOMContentLoaded",function(){var allElements=document.getElementsByTagName("*");for(var i=0;i<allElements.length;i++){allElements[i].addEventListener("click",function(){if(this.id==="searchField")event.stopImmediatePropagation();},false);};document.addEventListener("click",function(){searchIcon.src="images/searchWhite.png";searchField.style.display="none";userSide.insertBefore(searchArea,userSide.childNodes[1]);searchArea.style.marginBottom="0px";searchArea.style.width="";searchField.style.width="";searchIcon.style.marginLeft="0px";document.getElementById('searchForm').style.width="";},false);});}EndoffirstfunctionshowBasketCounter(){var basketCounter=localStorage.getItem('basketCounter')||0;var headerBasketCounter=document.querySelector("span#basketCounter");headerBasketCounter.innerHTML=basketCounter;return false;}document.addEventListener("DOMContentLoaded",showBasketCounter);EndofsecondfunctioncountAmount(){var totalCashAmount=0;var products=document.querySelector('table.baskettbody').childNodes;for(var i=1;i<products.length;i++){console.log(products[1].innerHTML);var amount=products[i].querySelector('input[type="number"]').value;var price=products[i].querySelector('span.price').innerHTML;totalCashAmount+=(amount*price);}alert(totalCashAmount);return totalCashAmount;}document.querySelector('h1').addEventListener("click",countAmount);Endofthirdvar searchIcon=document.getElementById('searchIcon');var searchField=document.getElementById('searchField');var searchArea=document.getElementById('search');var searchForm=document.getElementById('searchForm');var width=(self.innerWidth||(document.documentElement&&document.documentElement.clientWidth)||document.body.clientWidth);searchArea.onmouseover=function(){if(width<=466){var spaceBelow=document.getElementById("spaceBelow");spaceBelow.parentNode.insertBefore(searchArea,spaceBelow.nextSibling);searchArea.style.marginBottom="20px";searchArea.style.width="100%";searchField.style.width="100%";searchIcon.style.marginLeft="-40px";searchForm.style.width="100%";}searchField.style.display="inline-block";searchIcon.src="images/search.png";}if(width>=466){searchArea.onmouseout=function(){searchIcon.src="images/searchWhite.png";searchField.style.display="none";}}if(width<=466){document.addEventListener("DOMContentLoaded",function(){var allElements=document.getElementsByTagName("*");for(var i=0;i<allElements.length;i++){allElements[i].addEventListener("click",function(){if(this.id==="searchField")event.stopImmediatePropagation();},false);};document.addEventListener("click",function(){searchIcon.src="images/searchWhite.png";searchField.style.display="none";userSide.insertBefore(searchArea,userSide.childNodes[1]);searchArea.style.marginBottom="0px";searchArea.style.width="";searchField.style.width="";searchIcon.style.marginLeft="0px";document.getElementById('searchForm').style.width="";},false);});}EndoffirstfunctionshowBasketCounter(){var basketCounter=localStorage.getItem('basketCounter')||0;var headerBasketCounter=document.querySelector("span#basketCounter");headerBasketCounter.innerHTML=basketCounter;return false;}document.addEventListener("DOMContentLoaded",showBasketCounter);EndofsecondfunctioncountAmount(){var totalCashAmount=0;var products=document.querySelector('table.baskettbody').childNodes;for(var i=1;i<products.length;i++){console.log(products[1].innerHTML);var amount=products[i].querySelector('input[type="number"]').value;var price=products[i].querySelector('span.price').innerHTML;totalCashAmount+=(amount*price);}alert(totalCashAmount);return totalCashAmount;}document.querySelector('h1').addEventListener("click",countAmount);Endofthirdvar searchIcon=document.getElementById('searchIcon');var searchField=document.getElementById('searchField');var searchArea=document.getElementById('search');var searchForm=document.getElementById('searchForm');var width=(self.innerWidth||(document.documentElement&&document.documentElement.clientWidth)||document.body.clientWidth);searchArea.onmouseover=function(){if(width<=466){var spaceBelow=document.getElementById("spaceBelow");spaceBelow.parentNode.insertBefore(searchArea,spaceBelow.nextSibling);searchArea.style.marginBottom="20px";searchArea.style.width="100%";searchField.style.width="100%";searchIcon.style.marginLeft="-40px";searchForm.style.width="100%";}searchField.style.display="inline-block";searchIcon.src="images/search.png";}if(width>=466){searchArea.onmouseout=function(){searchIcon.src="images/searchWhite.png";searchField.style.display="none";}}if(width<=466){document.addEventListener("DOMContentLoaded",function(){var allElements=document.getElementsByTagName("*");for(var i=0;i<allElements.length;i++){allElements[i].addEventListener("click",function(){if(this.id==="searchField")event.stopImmediatePropagation();},false);};document.addEventListener("click",function(){searchIcon.src="images/searchWhite.png";searchField.style.display="none";userSide.insertBefore(searchArea,userSide.childNodes[1]);searchArea.style.marginBottom="0px";searchArea.style.width="";searchField.style.width="";searchIcon.style.marginLeft="0px";document.getElementById('searchForm').style.width="";},false);});}EndoffirstfunctionshowBasketCounter(){var basketCounter=localStorage.getItem('basketCounter')||0;var headerBasketCounter=document.querySelector("span#basketCounter");headerBasketCounter.innerHTML=basketCounter;return false;}document.addEventListener("DOMContentLoaded",showBasketCounter);EndofsecondfunctioncountAmount(){var totalCashAmount=0;var products=document.querySelector('table.baskettbody').childNodes;for(var i=1;i<products.length;i++){console.log(products[1].innerHTML);var amount=products[i].querySelector('input[type="number"]').value;var price=products[i].querySelector('span.price').innerHTML;totalCashAmount+=(amount*price);}alert(totalCashAmount);return totalCashAmount;}document.querySelector('h1').addEventListener("click",countAmount);Endofthird